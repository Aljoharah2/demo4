package com.example.demo4.Controllers;

import com.example.demo4.Models.LoginModel;
import com.example.demo4.Models.SessionModel;
//import io.joshworks.restclient.http.HttpResponse;
//import io.joshworks.restclient.http.Unirest;

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
public class LogoutController {

    @GetMapping("/logout")
    public String logout(Model model) throws IOException, JSONException {

        model.addAttribute("user1",LoginModel.username);
        
        final String POST_PARAMS = "{\n"+"\"session_id\": \""+SessionModel.session_id+"\""+"\n}";

        URL url1 = new URL("https://api.themoviedb.org/3/authentication/session?api_key=0572bed39dcd3b94eafff8fcca979a9d");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setDoOutput(true);
        con1.setRequestMethod("GET");
        con1.setRequestProperty("Content-Type", "application/json");
        
        int responseCode = con1.getResponseCode();
        
        if (responseCode == 200) { //success
        	
        	BufferedReader br = new BufferedReader(new InputStreamReader((con1.getInputStream())));
            String output = br.readLine();
           	
            JSONObject jsonObj2 = new JSONObject(output);
            model.addAttribute("statusMsg", jsonObj2.toString());
            LoginModel.username = null;
            
        } else {
        	model.addAttribute("statusMsg","There is some error, please check again");
        }

        /*
        HttpResponse<String> response1 = Unirest.delete("https://api.themoviedb.org/3/authentication/session?api_key=0572bed39dcd3b94eafff8fcca979a9d")
                .header("content-type", "application/json")
                .body("{\"session_id\":\""+SessionModel.session_id+"\"}")
                .asString();

        if(response1.isSuccessful()) {
            String responseStr = response1.getBody();
            JSONObject jsonObj = new JSONObject(responseStr);
            if (response1.isSuccessful()) {
                model.addAttribute("statusMsg", jsonObj.toString());

                LoginModel.username = null;
            }
        }
        */
        return "logout";
    }
}
