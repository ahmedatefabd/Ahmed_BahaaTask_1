package com.example.engahmedatef.ahmed_bahaatask_1.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class PostsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
    }
}
