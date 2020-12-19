package com.example.capres.model.response;

import com.google.gson.annotations.SerializedName;

public class TokenResponse {

    @SerializedName("message")
    String message;

    @SerializedName("token_type")
    String tokenType;

    @SerializedName("expires_in")
    String expiresIn;

    @SerializedName("access_token")
    String accessToken;

    @SerializedName("refresh_token")
    String refreshToken;

    public String getMessage() {
        return message;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getAuthorization(){
        return this.tokenType + "" + this.accessToken;
    }
}
