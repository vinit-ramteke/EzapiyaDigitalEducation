package com.ezapiya.ezapiyadigitaleducation.Model;

public class messageModel {
    private String code;
    private String message;

    public messageModel() {
    }

    public messageModel(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
