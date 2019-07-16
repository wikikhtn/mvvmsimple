package com.example.mvvmresposive.api;

import com.example.mvvmresposive.api.response.WordResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRepository {
    @GET("word")
    Call<WordResponse> getWord();
}
