package com.ezapiya.ezapiyadigitaleducation.apiInterface;


import com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import com.ezapiya.ezapiyadigitaleducation.Model.loginPojo;
import com.ezapiya.ezapiyadigitaleducation.Model.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface createUserInterface {
    @FormUrlEncoded
    @POST("user.php")
    Call<createUser> createUser(@Field("loginkey") String loginkey,@Field("command") String command,@Field("userName") String userName, @Field("password") String password,@Field("userType") String userType);

    @FormUrlEncoded
    @POST("user.php")
    Call<List<user>> getUserList(@Field("loginkey") String loginkey,@Field("command") String command,@Field("userId") String userId);


    @FormUrlEncoded
    @POST("user.php")
    Call<createUser> blockRemoveUser(@Field("loginkey") String loginkey,@Field("command") String command,@Field("userId") String userId);


    @FormUrlEncoded
    @POST("user.php")
    Call<loginPojo> getUser(@Field("loginkey") String loginkey, @Field("command") String command, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("user.php")
    Call<createUser> setUserParmission(@Field("loginkey") String loginkey, @Field("command") String command, @Field("userId") String userId,@Field("addNewUser") String addNewUser,@Field("removeUser") String removeUser,@Field("changePermission") String changePermission,@Field("blockUser") String blockUser);

    @FormUrlEncoded
    @POST("user.php")
    Call<createUser> changePassword(@Field("loginkey") String loginkey, @Field("command") String command, @Field("userId") String userId,@Field("password") String password);

}
