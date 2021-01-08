package com.example.capres.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.capres.MyApplication;
import com.example.capres.model.Event;
import com.example.capres.model.response.EventResponse;
import com.example.capres.network.RetrofitService;
import com.example.capres.util.SharedPreferenceHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventURepository {
    private static EventURepository eventURepository;
    private RetrofitService apiService;
    private static final String TAG = "EventURepository";
    private SharedPreferenceHelper prefs;

    private EventURepository(){
        prefs = SharedPreferenceHelper.getInstance(MyApplication.getContext());
        apiService = RetrofitService.getInstance(prefs.getAccessToken());
    }

    public static EventURepository getInstance(){
        eventURepository = new EventURepository();
        return eventURepository;
    }

    public MutableLiveData<List<Event>> getEvents(){
        MutableLiveData<List<Event>> liveEvents = new MutableLiveData<>();

        apiService.getEventsU().enqueue(new Callback<EventResponse>() {
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

