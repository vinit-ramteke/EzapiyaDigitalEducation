package com.ezapiya.ezapiyadigitaleducation.apiInterface;

import  com.ezapiya.ezapiyadigitaleducation.Model.loginPojo;
import  com.ezapiya.ezapiyadigitaleducation.Model.loginPost;
import  com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import android.graphics.ColorSpace;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface loginInterface {
    //@POST("login.php");
    //@GET("login.php")
    //Call<loginPojo> getlogin();

    @GET("login.php")
    Call<List<loginPojo>> getlogin();

    @POST("login.php")
    Call<List<loginPojo>> createPost(@Body loginPost dataModal);

    @FormUrlEncoded
    @POST("login.php")
    Call<List<loginPojo>> createPost1(@Field("command") String command,@Field("userName") String userName,@Field("password") String password);


    @FormUrlEncoded
    @POST("login.php")
    Call<createUser> logout(@Field("command") String command,@Field("loginkey") String loginkey);

}
