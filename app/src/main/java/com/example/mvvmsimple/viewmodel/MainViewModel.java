package com.example.mvvmsimple.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmsimple.api.ApiConnection;
import com.example.mvvmsimple.base.BaseViewModel;
import com.example.mvvmsimple.event.LoadingEvent;
import com.example.mvvmsimple.api.response.WordResponse;
import com.example.mvvmsimple.event.MessageCallback;
import com.example.mvvmsimple.model.Word;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends BaseViewModel {
    public MainViewModel() {
    }

    public MainViewModel(LoadingEvent event) {
        setLoading(event);
    }

    public MutableLiveData<WordResponse> tuVung = new MutableLiveData<>();

    public void getWord(String en, String vn, MessageCallback callback) {
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
