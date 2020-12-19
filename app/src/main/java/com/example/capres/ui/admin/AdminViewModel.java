package com.example.capres.ui.admin;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.capres.model.response.LogoutResponse;
import com.example.capres.model.response.TokenResponse;
import com.example.capres.repository.AuthRepository;
import com.google.gson.JsonObject;

public class AdminViewModel extends ViewModel {

    private AuthRepository repository;

    public AdminViewModel() {
        repository = AuthRepository.getInstance();
    }

    public MutableLiveData<LogoutResponse> logout(){
        return repository.logout();
    }
}

