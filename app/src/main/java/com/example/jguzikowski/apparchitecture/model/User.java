package com.example.jguzikowski.apparchitecture.model;

import android.arch.lifecycle.LiveData;

/**
 * Created by j.guzikowski on 12/11/17.
 */

public class User extends LiveData<User> {
    public String name;
    public int id;

    public User(String name, int id){
        this.name = name;
        this.id = id;
    }
}
