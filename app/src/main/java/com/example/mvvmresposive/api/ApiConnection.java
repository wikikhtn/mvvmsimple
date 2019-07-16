package com.example.mvvmresposive.api;

import com.example.mvvmresposive.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConnection {
    private static Retrofit retrofit = null;
    private static ApiRepository api;

    public static void init(){
        api =  ApiConnection.getInstances("https://server2301.herokuapp.com/").create(ApiRepository.class);
    }

    public static ApiRepository getApi() {
        return api;
    }

    private static Retrofit getInstances(String base_url){
        if (retrofit == null){
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            retrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .client(getOkHttpClient())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            return retrofit;
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient(){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                                .connectTimeout(30, TimeUnit.SECONDS)
                                .writeTimeout(30,TimeUnit.SECONDS)
                                .readTimeout(30,TimeUnit.SECONDS)
                                .cache(null);

        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(loggingInterceptor);
        }
        return okHttpClient.build();
    }
}
