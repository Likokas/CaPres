package com.example.capres.ui.admin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.capres.model.Event;
import com.example.capres.model.response.LogoutResponse;
import com.example.capres.model.response.TokenResponse;
import com.example.capres.repository.AuthRepository;
import com.example.capres.repository.EventRepository;
import com.google.gson.JsonObject;

import java.util.List;

public class AdminViewModel extends ViewModel {

    private AuthRepository repository;

    private EventRepository eventRepository;

    public AdminViewModel() {
        repository = AuthRepository.getInstance();
        eventRepository = EventRepository.getInstance();
    }

    public LiveData<List<Event>> getEvents(){
        return eventRepository.getEvents();
    }

    public MutableLiveData<LogoutResponse> logout(){
        return repository.logout();
    }

}

