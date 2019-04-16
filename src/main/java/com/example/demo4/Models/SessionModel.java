package com.example.demo4.Models;

public class SessionModel {

    public static Boolean success;
    public static String session_id;

    public SessionModel(Boolean success, String session_id) {
        this.success = success;
        this.session_id = session_id;
    }

    public SessionModel() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    @Override
    public String toString() {
        return "SessionModel{" +
                "success=" + success +
                ", session_id='" + session_id + '\'' +
                '}';
    }
}
