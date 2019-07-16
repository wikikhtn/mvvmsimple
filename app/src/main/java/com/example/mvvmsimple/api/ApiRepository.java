package com.example.mvvmsimple.api;

import com.example.mvvmsimple.api.response.WordResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRepository {
    @GET("word")
    Call<WordResponse> getWord();
}
