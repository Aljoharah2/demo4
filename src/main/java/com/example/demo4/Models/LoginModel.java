package com.example.demo4.Models;


public class LoginModel {

    public static String username;
    private String password;
    private String request_token;

    public LoginModel(String username, String password, String request_token) {
        this.username = username;
        this.password = password;
        this.request_token = request_token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRequest_token() {
        return request_token;
    }

    public void setRequest_token(String request_token) {
        this.request_token = request_token;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", request_token='" + request_token + '\'' +
                '}';
    }
}
