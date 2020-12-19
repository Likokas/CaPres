package com.example.capres.ui.user;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.capres.model.response.LogoutResponse;
import com.example.capres.repository.AuthRepository;

public class UserViewModel extends ViewModel {

    private AuthRepository repository;

    public UserViewModel() {
        repository = AuthRepository.getInstance();
    }

    public MutableLiveData<LogoutResponse> logout(){
        return repository.logout();
    }
}
