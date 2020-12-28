package com.example.capres.ui.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.capres.model.Event;
import com.example.capres.model.response.LogoutResponse;
import com.example.capres.repository.AuthRepository;
import com.example.capres.repository.EventRepository;

import java.util.List;

public class UserViewModel extends ViewModel {

    private AuthRepository repository;
    private EventRepository eventRepository;

    public UserViewModel() {
        repository = AuthRepository.getInstance();
    }

    public LiveData<List<Event>> getEvents(){
        return eventRepository.getEvents();
    }

    public MutableLiveData<LogoutResponse> logout(){
        return repository.logout();
    }
}
