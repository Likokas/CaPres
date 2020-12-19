package com.example.capres.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.capres.MyApplication;
import com.example.capres.model.response.LogoutResponse;
import com.example.capres.model.response.TokenResponse;
import com.example.capres.network.RetrofitService;
import com.example.capres.util.SharedPreferenceHelper;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private static AuthRepository authRepository;
    private RetrofitService apiService;
    private static final String TAG = "AuthRepository";
    private SharedPreferenceHelper prefs;

    private AuthRepository(){
        prefs = SharedPreferenceHelper.getInstance(MyApplication.getContext());
        apiService=RetrofitService.getInstance(prefs.getAccessToken());
    }

    public static AuthRepository getInstance(){
        authRepository = new AuthRepository();
        return authRepository;
    }

    public MutableLiveData<TokenResponse> login(String email, String password){
        MutableLiveData<TokenResponse> tokenResponse = new MutableLiveData<>();

        apiService.login(email, password).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        Log.d(TAG, "onResponse: "+response.body().getAccessToken());
                        tokenResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
        return tokenResponse;
    }

    public MutableLiveData<TokenResponse> loginAdmin(String email, String password){
        MutableLiveData<TokenResponse> tokenResponse = new MutableLiveData<>();

        apiService.loginAdmin(email, password).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        Log.d(TAG, "onResponse: "+response.body().getAccessToken());
                        tokenResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
        return tokenResponse;
    }

    public MutableLiveData<LogoutResponse> logout(){

        MutableLiveData<LogoutResponse> tokenResponse = new MutableLiveData<>();

        apiService.logout().enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                Log.d(TAG, "onResponse: "+response.message());
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        Log.d(TAG, "onResponse: "+response.body().getMessage());
                        tokenResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
        return tokenResponse;
    }
}
