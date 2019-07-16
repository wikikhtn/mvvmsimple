package com.example.mvvmresposive.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmresposive.api.ApiConnection;
import com.example.mvvmresposive.base.BaseViewModel;
import com.example.mvvmresposive.event.LoadingEvent;
import com.example.mvvmresposive.api.response.WordResponse;
import com.example.mvvmresposive.event.MessageCallback;
import com.example.mvvmresposive.model.Word;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends BaseViewModel {
    public MainViewModel(LoadingEvent event) {
        setLoading(event);
    }

    public MutableLiveData<WordResponse> tuVung = new MutableLiveData<>();

    public void getTuVung(String en, String vn, MessageCallback callback) {
        if (!Word.validate(en, vn)) {
            callback.message("");
            return;
        }

        showProgress();
        ApiConnection.getApi().getWord().enqueue(new Callback<WordResponse>() {
            @Override
            public void onResponse(Call<WordResponse> call, Response<WordResponse> response) {
                if (response.isSuccessful())
                    tuVung.setValue(response.body());
                hideProgress();
            }

            @Override
            public void onFailure(Call<WordResponse> call, Throwable t) {
                tuVung.setValue(null);
                t.printStackTrace();
                callback.message(t.getMessage());
                hideProgress();
            }
        });
    }
}
