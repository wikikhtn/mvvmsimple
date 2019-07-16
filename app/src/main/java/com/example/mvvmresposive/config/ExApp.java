package com.example.mvvmresposive.config;

import android.app.Application;

import com.example.mvvmresposive.api.ApiConnection;

public class ExApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApiConnection.init();
    }
}
