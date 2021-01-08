package com.example.capres.network;

import com.example.capres.model.response.EventResponse;
import com.example.capres.model.response.LogoutResponse;
import com.example.capres.model.response.TokenResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Endpoints {

    @POST("api-login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email")String email, @Field("password")String password);

    @POST("api-loginadmin")
    @FormUrlEncoded
    Call<TokenResponse> loginAdmin(@Field("email")String email, @Field("password")String password);

    @GET("events")
    Call<EventResponse> getEvents();

    @GET("eventsU")
    Call<EventResponse> getEventsU();

    @POST("logout")
    Call<LogoutResponse> logout();
}
