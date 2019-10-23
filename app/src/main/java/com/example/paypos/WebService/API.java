package com.example.paypos.WebService;

import com.example.paypos.Model.RSResponse;
import com.example.paypos.Model.User;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface API {
    @Headers({
            "Accept: application/json"
    })

    //Login
    @POST("Login.php")
    Call<RSResponse> loginUser(@Body User user);

    //User
    @FormUrlEncoded
    @POST("GetUserByEmail.php")
    Call<RSResponse> VerifUserByEmail(@Field("email") String email);

}
