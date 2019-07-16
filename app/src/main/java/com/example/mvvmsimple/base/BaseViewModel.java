package com.example.mvvmsimple.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.mvvmsimple.event.LoadingEvent;

public class BaseViewModel extends ViewModel implements LifecycleObserver {
    private LoadingEvent mLoading;

    public BaseViewModel() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onViewModelCreate() {
        //do something
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onViewModelDestroy() {
        mLoading = null;
    }

    public void setLoading(LoadingEvent event) {
        mLoading = event;
    }

    protected void showProgress() {
        if (mLoading != null)
            mLoading.showProgress();
    }

    protected void hideProgress() {
        if (mLoading != null)
            mLoading.hideProgress();
    }
}
