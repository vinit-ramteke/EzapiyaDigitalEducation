package com.ezapiya.ezapiyadigitaleducation.Model;


import com.ezapiya.ezapiyadigitaleducation.Globle_data;

public class user {
    private int userId;
    private String userName;


    // Getter Methods

    public  user(int userId,String userName)
    {
        this.userId=userId;
        this.userName=userName;

    }
    public int getuserId() {
        return userId;
    }

    public String getuserName() {
        return userName;
    }

    // Setter Methods

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }
}
