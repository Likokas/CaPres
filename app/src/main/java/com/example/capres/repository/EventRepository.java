package com.example.capres.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.capres.MyApplication;
import com.example.capres.model.Event;
import com.example.capres.model.response.EventResponse;
import com.example.capres.model.response.LogoutResponse;
import com.example.capres.network.RetrofitService;
import com.example.capres.util.SharedPreferenceHelper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRepository {

    private static EventRepository eventRepository;
    private RetrofitService apiService;
    private static final String TAG = "EventRepository";
    private SharedPreferenceHelper prefs;

    private EventRepository(){
        prefs = SharedPreferenceHelper.getInstance(MyApplication.getContext());
        apiService = RetrofitService.getInstance(prefs.getAccessToken());
    }

    public static EventRepository getInstance(){
        eventRepository = new EventRepository();
        return eventRepository;
    }

    public MutableLiveData<List<Event>> getEvents(){
        MutableLiveData<List<Event>> liveEvents = new MutableLiveData<>();

        apiService.getEvents().enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        Log.d(TAG, "onResponse: "+response.body().getResults().size());
                        liveEvents.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });

        return liveEvents;
    }
}
