package com.example.mvvmsimple.event;

import android.view.View;
import android.widget.ProgressBar;

public class LoadingEvent {
    private ProgressBar mProgressBar;

    public LoadingEvent() {

    }

    public LoadingEvent(ProgressBar mProgressBar) {
        this.mProgressBar = mProgressBar;
    }

    public void showProgress(){
        if (mProgressBar != null)
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        if (mProgressBar != null)
        mProgressBar.setVisibility(View.GONE);
    }
}
