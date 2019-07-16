package com.example.mvvmsimple.config;

import android.app.Application;

import com.example.mvvmsimple.api.ApiConnection;

public class ExApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApiConnection.init();
    }
}
