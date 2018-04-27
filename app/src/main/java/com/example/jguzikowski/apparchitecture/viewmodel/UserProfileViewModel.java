package com.example.jguzikowski.apparchitecture.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


public class UserProfileViewModel extends ViewModel {

    private MutableLiveData<String> user = new MutableLiveData<>();
    public MutableLiveData<String> getUser() {
        return user;
    }
}

