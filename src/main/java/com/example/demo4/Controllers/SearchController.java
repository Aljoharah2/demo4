package com.example.demo4.Controllers;

import com.example.demo4.Models.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String getResult(HttpServletRequest request, Model model) throws IOException, JSONException {

        String searchInput;
        searchInput = request.getParameter("searchInput");

        URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=0572bed39dcd3b94eafff8fcca979a9d&query="+searchInput);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        if(con.getResponseCode() == 200) {

            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String output = br.readLine();

            // Initializing json objects and getting the info needed provided if the value is null.
            // Given that the default value for String is (Not provided)
            // and for int is 0
            // and for Boolean is false

            Boolean objAdult;
            int objId;
            String objOriginalLanguage;
            String objOriginalTitle;
            String objOverview;
            int objPopularity;
            String objPosterPath;
            String objReleaseDate;
            String objTitle;
            Boolean objVideo;

            JSONObject obj1 = new JSONObject(output);
            JSONArray values = obj1.getJSONArray("results");

            Result[] results = new Result[values.length()];

            for (int i = 0; i < values.length(); i++) {

                JSONObject result = values.getJSONObject(i);

                if (result.isNull("adult")) {
                    objAdult = false;
                } else {
                    objAdult = result.getBoolean("adult");
                }

                if (result.isNull("id")) {
                    objId = 0;
                } else {
                    objId = result.getInt("id");
                }

                if (result.isNull("original_language")) {
                    objOriginalLanguage = "(Not provided)";
                } else {
                    objOriginalLanguage = result.getString("original_language");
                }

                if (result.isNull("original_title")) {
                    objOriginalTitle = "(Not provided)";
                } else {
                    objOriginalTitle = result.getString("original_title");
                }

                if (result.isNull("overview")) {
                    objOverview = "(Not provided)";
                } else {
                    objOverview = result.getString("overview");
                }

                if (result.isNull("popularity")) {
                    objPopularity = 0;
                } else {
                    objPopularity = result.getInt("popularity");
                }

                if (result.isNull("poster_path")) {
                    objPosterPath = "(Not provided)";
                } else {
                    objPosterPath = result.getString("poster_path");
                }

                if (result.isNull("release_date")) {
                    objReleaseDate = "(Not provided)";
                } else {
                    objReleaseDate = result.getString("release_date");
                }

                if (result.isNull("title")) {
                    objTitle = "(Not provided)";
                } else {
                    objTitle = result.getString("title");
                }

                if (result.isNull("video")) {
                    objVideo = false;
                } else {
                    objVideo = result.getBoolean("video");
                }

                results[i] = new Result(objAdult, objId, objOriginalLanguage, objOriginalTitle,
                        objOverview, objPopularity, objPosterPath, objReleaseDate, objTitle, objVideo);
            }

            model.addAttribute("results", results);
        }
return "search";

    }
}
