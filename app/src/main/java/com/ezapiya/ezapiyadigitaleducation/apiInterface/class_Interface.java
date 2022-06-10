package com.ezapiya.ezapiyadigitaleducation.apiInterface;

import  com.ezapiya.ezapiyadigitaleducation.Model.messageModel;
import  com.ezapiya.ezapiyadigitaleducation.Model.class_Model;
import com.ezapiya.ezapiyadigitaleducation.Model.user;


import android.graphics.ColorSpace;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface class_Interface {
    @FormUrlEncoded
    @POST("index.php")
    Call<messageModel> addclass_(@Field("loginkey") String loginkey, @Field("command") String command,@Field("className") String className);

    @FormUrlEncoded
    @POST("index.php")
    Call<List<class_Model>> getClass_List(@Field("loginkey") String loginkey, @Field("command") String command);

    @FormUrlEncoded
    @POST("index.php")
    Call<messageModel> editclass_(@Field("loginkey") String loginkey, @Field("command") String command,@Field("classId") String classId,@Field("className") String className);


    @FormUrlEncoded
    @POST("index.php")
    Call<messageModel> removeclass_(@Field("loginkey") String loginkey, @Field("command") String command,@Field("classId") String classId);


}
