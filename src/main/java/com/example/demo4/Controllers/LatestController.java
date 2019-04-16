package com.example.demo4.Controllers;

import com.example.demo4.Models.LatestModel;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class LatestController {
    @GetMapping("/latest")
    public String getLatest(Model model) throws IOException, JSONException {
        URL url = new URL("https://api.themoviedb.org/3/movie/latest?language=en-US&api_key=0572bed39dcd3b94eafff8fcca979a9d");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        if(con.getResponseCode() == 200) {

            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String output = br.readLine();
            JSONObject obj = new JSONObject(output);

            // Initializing json objects and getting the info needed provided if the value is null.
            // Given that the default value for String is (Not provided)
            // and for int is 0
            // and for Boolean is false

            Boolean objAdult;
            if (obj.isNull("adult")) {
                objAdult = false;
            } else {
                objAdult = obj.getBoolean("adult");
            }

            int objBudget;
            if (obj.isNull("budget")) {
                objBudget = 0;
            } else {
                objBudget = obj.getInt("budget");
            }

            int objId;
            if (obj.isNull("id")) {
                objId = 0;
            } else {
                objId = obj.getInt("id");
            }

            String objImdbId;
            if (obj.isNull("imdb_id")) {
                objImdbId = "(Not provided)";
            } else {
                objImdbId = obj.getString("imdb_id");
            }

            String objOriginalLanguage;
            if (obj.isNull("original_language")) {
                objOriginalLanguage = "(Not provided)";
            } else {
                objOriginalLanguage = obj.getString("original_language");
            }

            String objOriginalTitle;
            if (obj.isNull("original_title")) {
                objOriginalTitle = "(Not provided)";
            } else {
                objOriginalTitle = obj.getString("original_title");
            }

            String objOverview;
            if (obj.isNull("overview")) {
                objOverview = "(Not provided)";
            } else {
                objOverview = obj.getString("overview");
            }

            int objPopularity;
            if (obj.isNull("popularity")) {
                objPopularity = 0;
            } else {
                objPopularity = obj.getInt("popularity");
            }

            String objPosterPath;
            if (obj.isNull("poster_path")) {
                objPosterPath = "(Not provided)";
            } else {
                objPosterPath = obj.getString("poster_path");
            }

            String objReleaseDate;
            if (obj.isNull("release_date")) {
                objReleaseDate = "(Not provided)";
            } else {
                objReleaseDate = obj.getString("release_date");
            }

            String objStatus;
            if (obj.isNull("status")) {
                objStatus = "(Not provided)";
            } else {
                objStatus = obj.getString("status");
            }

            String objTitle;
            if (obj.isNull("title")) {
                objTitle = "(Not provided)";
            } else {
                objTitle = obj.getString("title");
            }


            Boolean objVideo;
            if (obj.isNull("video")) {
                objVideo = false;
            } else {
                objVideo = obj.getBoolean("video");
            }


            LatestModel latestObj = new LatestModel(objAdult, objBudget, objId, objImdbId, objOriginalLanguage,
                    objOriginalTitle, objOverview, objPopularity, objPosterPath, objReleaseDate, objStatus, objTitle, objVideo);

            model.addAttribute("latestM", latestObj);
        }
        return "latest";
    }
}
