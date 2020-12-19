package com.example.capres.model.response;

import com.example.capres.model.Event;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LogoutResponse {

    @SerializedName("message")
    String message;

    private List<Event> results;

    public String getMessage() {
        return message;
    }

    public List<Event>getResults(){return results;}

}
