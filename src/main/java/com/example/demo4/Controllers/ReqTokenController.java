package com.example.demo4.Controllers;

import com.example.demo4.Models.LoginModel;
import com.example.demo4.Models.ReqTokenModel;
import com.example.demo4.Models.SessionModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@Controller
public class ReqTokenController {

    SessionModel session;
    private ReqTokenModel rq;
    private String username;

    @GetMapping("/login")
    public String createRq(Model model) throws IOException, JSONException {

        URL url = new URL("https://api.themoviedb.org/3/authentication/token/new?api_key=0572bed39dcd3b94eafff8fcca979a9d");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        if(con.getResponseCode() == 200) {

            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String output = br.readLine();
            JSONObject obj = new JSONObject(output);

            rq = new ReqTokenModel(obj.getBoolean("success"), obj.getString("expires_at"), obj.getString("request_token"));

            //for login, it will go to that page to complete the process
            model.addAttribute("reqToken", rq.getRequest_token());
            model.addAttribute("user", LoginModel.username);
        }
        return "login";
    }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) throws IOException, JSONException {

        username = request.getParameter("username");
        String password = request.getParameter("password");
        
        final String POST_PARAMS = "{\n" + "\"username\": \""+username+"\",\r\n" +
                "    \"password\": \""+password+"\",\r\n" +
                "    \"request_token\": \""+rq.getRequest_token()+"\""+"\n}";

        URL url1 = new URL("https://api.themoviedb.org/3/authentication/token/validate_with_login?api_key=0572bed39dcd3b94eafff8fcca979a9d");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setDoOutput(true);
        con1.setRequestMethod("POST");
        con1.setRequestProperty("Content-Type", "application/json");
        con1.setDoOutput(true);
        OutputStream os = con1.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        
        int responseCode = con1.getResponseCode();
        
        if (responseCode == 200) { //success
            LoginModel.username = username;
            model.addAttribute("user", LoginModel.username);
        } else {
        	model.addAttribute("error","There is some error, please check again");
        }
        
        /*
        
        HttpResponse<String> response1 = Unirest.post("https://api.themoviedb.org/3/authentication/token/validate_with_login?api_key=0572bed39dcd3b94eafff8fcca979a9d")
                .header("content-type", "application/json")
                .body("{\"username\":\""+username+"\",\"password\":\""+password+"\",\"request_token\":\""+rq.getRequest_token()+"\"}")
                .asString();

        String responseStr = response1.getBody();
        JSONObject jsonObj = new JSONObject(responseStr);

        if(response1.isSuccessful()){
        LoginModel.username = username;
        model.addAttribute("user", LoginModel.username);
        }
        else{ model.addAttribute("error","There is some error, please check again");}
        
        */
        
        //


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        final String POST_PARAMS1 = "{\n"+"\"request_token\": \""+rq.getRequest_token()+"\""+"\n}";

        URL url2 = new URL("https://api.themoviedb.org/3/authentication/session/new?api_key=0572bed39dcd3b94eafff8fcca979a9d");
        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
        con2.setDoOutput(true);
        con2.setRequestMethod("POST");
        con2.setRequestProperty("Content-Type", "application/json");
        OutputStream os1 = con2.getOutputStream();
        os1.write(POST_PARAMS1.getBytes());
        os1.flush();
        os1.close();
        
        int responseCode1 = con2.getResponseCode();
        
        if (responseCode1 == 200) { //success
        	
        	BufferedReader br = new BufferedReader(new InputStreamReader((con2.getInputStream())));
            String output = br.readLine();
           	
            JSONObject jsonObj2 = new JSONObject(output);
            session = new SessionModel(jsonObj2.getBoolean("success"),jsonObj2.getString("session_id"));
            
        } else {
        	model.addAttribute("error","There is some error, please check again");
        }
        
        
        /*

        HttpResponse<String> response2 = Unirest.post("https://api.themoviedb.org/3/authentication/session/new?api_key=0572bed39dcd3b94eafff8fcca979a9d")
                .header("content-type", "application/json")
                .body("{\"request_token\":\""+rq.getRequest_token()+"\"}")
                .asString();

        String responseStr2 = response2.getBody();
        JSONObject jsonObj2 = new JSONObject(responseStr2);

        System.out.println(jsonObj2.toString());

        if(response2.isSuccessful()){
            session = new SessionModel(jsonObj2.getBoolean("success"),jsonObj2.getString("session_id"));
        }
        else {
            model.addAttribute("error","There is some error, please check again");

        }
        
        */
        
        

        return "login";
    }

}
