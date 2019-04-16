package com.example.demo4.Controllers;

import com.example.demo4.Models.*;
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
public class MovieInfoController {

    @GetMapping("/moreInfo")
    public String getMovieDetails(HttpServletRequest request, Model model) throws IOException, JSONException {

        String moreInfoStr = request.getParameter("moreInfo");
        int moreInfo = Integer.parseInt(moreInfoStr);

        URL url1 = new URL("https://api.themoviedb.org/3/movie/"+moreInfo+"?api_key=0572bed39dcd3b94eafff8fcca979a9d");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setDoOutput(true);
        con1.setRequestMethod("GET");
        con1.setRequestProperty("Content-Type", "application/json");

        if(con1.getResponseCode() == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader((con1.getInputStream())));
            String output = br.readLine();
            JSONObject obj = new JSONObject(output);

            // Create the objects:

            // 1- Genres

            JSONArray genresValues = obj.getJSONArray("genres");

            Genres[] genres = new Genres[genresValues.length()];
            int genreId;
            String genreName;

            for (int i = 0; i < genresValues.length(); i++) {

                JSONObject genre = genresValues.getJSONObject(i);

                if (genre.isNull("id")) {
                    genreId = 0;
                } else {
                    genreId = genre.getInt("id");
                }

                if (genre.isNull("name")) {
                    genreName = "Not provided";
                } else {
                    genreName = genre.getString("name");
                }

                genres[i] = new Genres(genreId, genreName);
            }

            // 2- production_companies

            JSONArray production_companiesValues = obj.getJSONArray("production_companies");

            Production_companies[] production_companies = new Production_companies[production_companiesValues.length()];
            String companyName;
            int companyId;
            String companyOrigin_country;

            for (int i = 0; i < production_companiesValues.length(); i++) {
                JSONObject company = production_companiesValues.getJSONObject(i);

                if (company.isNull("name")) {
                    companyName = "Not provided";
                } else {
                    companyName = company.getString("name");
                }

                if (company.isNull("id")) {
                    companyId = 0;
                } else {
                    companyId = company.getInt("id");
                }

                if (company.isNull("origin_country")) {
                    companyOrigin_country = "Not provided";
                } else {
                    companyOrigin_country = company.getString("origin_country");
                }

                production_companies[i] = new Production_companies(companyName, companyId, companyOrigin_country);
            }

            // 3- production_countries

            JSONArray production_countriesValues = obj.getJSONArray("production_countries");
            Production_countries[] production_countries = new Production_countries[production_countriesValues.length()];
            String countryIso_3166_1;
            String countryName;

            for (int i = 0; i < production_countriesValues.length(); i++) {

                JSONObject country = production_countriesValues.getJSONObject(i);

                if (country.isNull("iso_3166_1")) {
                    countryIso_3166_1 = "Not provided";
                } else {
                    countryIso_3166_1 = country.getString("iso_3166_1");
                }

                if (country.isNull("name")) {
                    countryName = "Not provided";
                } else {
                    countryName = country.getString("name");
                }

                production_countries[i] = new Production_countries(countryIso_3166_1, countryName);
            }

            // 4- spoken_languages

            JSONArray spoken_languagesValues = obj.getJSONArray("spoken_languages");
            Spoken_languages[] spoken_languages = new Spoken_languages[spoken_languagesValues.length()];
            String langIso_639_1;
            String langNname;

            for (int i = 0; i < spoken_languagesValues.length(); i++) {

                JSONObject lang = spoken_languagesValues.getJSONObject(i);

                if (lang.isNull("iso_639_1")) {
                    langIso_639_1 = "Not provided";
                } else {
                    langIso_639_1 = lang.getString("iso_639_1");
                }

                if (lang.isNull("name")) {
                    langNname = "Not provided";
                } else {
                    langNname = lang.getString("name");
                }

                spoken_languages[i] = new Spoken_languages(langIso_639_1, langNname);
            }

            // Fill the primary object (info)

            Boolean adultObj;
            int budgetObj;
            String homepageObj;
            String imdb_idObj;
            String original_languageObj;
            String original_titleObj;
            double popularityObj;
            int revenueObj;
            int runtimeObj;
            double vote_averageObj;

            if (obj.isNull("adult")) {
                adultObj = false;
            } else {
                adultObj = obj.getBoolean("adult");
            }

            if (obj.isNull("budget")) {
                budgetObj = 0;
            } else {
                budgetObj = obj.getInt("budget");
            }

            if (obj.isNull("homepage")) {
                homepageObj = "Not provided";
            } else {
                homepageObj = obj.getString("homepage");
            }

            if (obj.isNull("imdb_id")) {
                imdb_idObj = "Not provided";
            } else {
                imdb_idObj = obj.getString("imdb_id");
            }

            if (obj.isNull("original_language")) {
                original_languageObj = "Not provided";
            } else {
                original_languageObj = obj.getString("original_language");
            }

            if (obj.isNull("original_title")) {
                original_titleObj = "Not provided";
            } else {
                original_titleObj = obj.getString("original_title");
            }

            if (obj.isNull("popularity")) {
                popularityObj = 0;
            } else {
                popularityObj = obj.getInt("popularity");
            }

            if (obj.isNull("revenue")) {
                revenueObj = 0;
            } else {
                revenueObj = obj.getInt("revenue");
            }

            if (obj.isNull("runtime")) {
                runtimeObj = 0;
            } else {
                runtimeObj = obj.getInt("runtime");
            }

            if (obj.isNull("vote_average")) {
                vote_averageObj = 0;
            } else {
                vote_averageObj = obj.getInt("vote_average");
            }


            MoreInfoModel info = new MoreInfoModel(adultObj, budgetObj, genres, homepageObj,
                    imdb_idObj, original_languageObj, original_titleObj,
                    popularityObj, production_companies, production_countries, revenueObj,
                    runtimeObj, spoken_languages, vote_averageObj);

            // send the data to the view

            model.addAttribute("genres", genres);
            model.addAttribute("production_companies", production_companies);
            model.addAttribute("production_countries", production_countries);
            model.addAttribute("spoken_languages", spoken_languages);

            model.addAttribute("info", info);
        }

        return "moreInfo";
    }

}
