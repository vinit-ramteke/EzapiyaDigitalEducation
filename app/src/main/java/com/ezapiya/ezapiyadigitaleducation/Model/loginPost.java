package com.ezapiya.ezapiyadigitaleducation.Model;
import com.google.gson.annotations.SerializedName;
public class loginPost {
    @SerializedName("userName")
    public String userName;
    @SerializedName("password")
    public String password;

    public String getuserName() {
        return userName;
    }

    public String getpassword() {
        return password;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
