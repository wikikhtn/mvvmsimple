package com.example.mvvmresposive.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

    public T mViewModel;

    public abstract int getLayoutId();
    public abstract void initView();
    public abstract T getViewModel();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        mViewModel = getViewModel();
        getLifecycle().addObserver(mViewModel);
        mViewModel.onViewModelCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.onViewModelDestroy();
    }
}
