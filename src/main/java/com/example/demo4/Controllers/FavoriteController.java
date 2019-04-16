package com.example.demo4.Controllers;

import com.example.demo4.Models.LatestModel;
import com.example.demo4.Models.SessionModel;
//import io.joshworks.restclient.http.HttpResponse;
//import io.joshworks.restclient.http.Unirest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class FavoriteController {

    // Favorite for Latest page
    @PostMapping("/favYes")
    public String fav(HttpServletRequest request, Model model) throws IOException, JSONException {

        Boolean fav;
        String isFav = "";
        isFav = request.getParameter("fav");

        if(isFav.equals("true")){
            fav = true;
        }
        else {
            fav = false;
        }
        
        final String POST_PARAMS = "{\n"+"\"media_type\": \"movie\",\"media_id\":\""+LatestModel.id+"\",\"favorite\":\""+fav+"\"}";

        URL url1 = new URL("https://api.themoviedb.org/3/account/{account_id}/favorite?session_id="+SessionModel.session_id+"&api_key=0572bed39dcd3b94eafff8fcca979a9d");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setDoOutput(true);
        con1.setRequestMethod("POST");
        con1.setRequestProperty("Content-Type", "application/json");
        OutputStream os1 = con1.getOutputStream();
        os1.write(POST_PARAMS.getBytes());
        os1.flush();
        os1.close();
        
        int responseCode1 = con1.getResponseCode();
        //System.out.println("code latest:"+ responseCode1);
        
        if (responseCode1 == HttpURLConnection.HTTP_CREATED) { //success
        	
        	BufferedReader br = new BufferedReader(new InputStreamReader((con1.getInputStream())));
            String output = br.readLine();
           	
            JSONObject jsonObj2 = new JSONObject(output);
            String statusMsg = jsonObj2.getString("status_message");
            model.addAttribute("statusMsg", statusMsg);
            
        } else {
        	model.addAttribute("statusMsg","There is some error, please check again");
        }
        
        

        /*
        HttpResponse<String> response1 = Unirest.post("https://api.themoviedb.org/3/account/{account_id}/favorite?session_id="+SessionModel.session_id+"&api_key=0572bed39dcd3b94eafff8fcca979a9d")
                .header("content-type", "application/json;charset=utf-8")
                .body("{\"media_type\":\"movie\",\"media_id\":"+LatestModel.id+",\"favorite\":"+fav+"}")
                .asString();

        if(response1.isSuccessful()) {

            String responseStr = response1.getBody();
            JSONObject jsonObj = new JSONObject(responseStr);
            String statusMsg = jsonObj.getString("status_message");
            model.addAttribute("statusMsg", statusMsg);
        }
        */
        return "favYes";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Favorite for Search page
    @PostMapping("/favYes1")
    public String fav2(HttpServletRequest request, Model model) throws IOException, JSONException {

        String favStr = request.getParameter("fav");
        int favId = Integer.parseInt(favStr);

        Boolean fav1;
        String isFav = "";
        isFav = request.getParameter("fav1");

        if(isFav.equals("true")){
            fav1 = true;
        }
        else {
            fav1 = false;
        }
        
        final String POST_PARAMS1 = "{\n"+"\"media_type\": \"movie\",\"media_id\":\""+favId+"\",\"favorite\":\""+fav1+"\"}";

        URL url1 = new URL("https://api.themoviedb.org/3/account/{account_id}/favorite?session_id="+SessionModel.session_id+"&api_key=0572bed39dcd3b94eafff8fcca979a9d");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setDoOutput(true);
        con1.setRequestMethod("POST");
        con1.setRequestProperty("Content-Type", "application/json");
        OutputStream os1 = con1.getOutputStream();
        os1.write(POST_PARAMS1.getBytes());
        os1.flush();
        os1.close();
        
        int responseCode1 = con1.getResponseCode();
        
        if (responseCode1 == HttpURLConnection.HTTP_CREATED) { //success
        	
        	BufferedReader br = new BufferedReader(new InputStreamReader((con1.getInputStream())));
            String output = br.readLine();
           	
            JSONObject jsonObj2 = new JSONObject(output);
            String statusMsg = jsonObj2.getString("status_message");
            model.addAttribute("statusMsg", statusMsg);
            
        } else {
        	model.addAttribute("statusMsg","There is some error, please check again");
        }
        
        

        /*
        HttpResponse<String> response1 = Unirest.post("https://api.themoviedb.org/3/account/{account_id}/favorite?session_id="+SessionModel.session_id+"&api_key=0572bed39dcd3b94eafff8fcca979a9d")
                .header("content-type", "application/json;charset=utf-8")
                .body("{\"media_type\":\"movie\",\"media_id\":"+favId+",\"favorite\":"+fav1+"}")
                .asString();

        if(response1.isSuccessful()) {

            String responseStr = response1.getBody();

            JSONObject jsonObj = new JSONObject(responseStr);
            String statusMsg = jsonObj.getString("status_message");
            model.addAttribute("statusMsg", statusMsg);
        }
        */

        return "favYes1";
    }

}
