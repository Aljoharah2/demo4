package com.example.demo4.Models;

public class ReqTokenModel {

    private Boolean success;
    private String expires_at;
    private String request_token;

    public ReqTokenModel(Boolean success, String expires_at, String request_token) {
        this.success = success;
        this.expires_at = expires_at;
        this.request_token = request_token;
    }

    @Override
    public String toString() {
        return "ReqTokenModel{" +
                "success=" + success +
                ", expires_at='" + expires_at + '\'' +
                ", request_token='" + request_token + '\'' +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getRequest_token() {
        return request_token;
    }

    public void setRequest_token(String request_token) {
        this.request_token = request_token;
    }
}
