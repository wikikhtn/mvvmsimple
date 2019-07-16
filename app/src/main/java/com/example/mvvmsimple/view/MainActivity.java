package com.example.mvvmsimple.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvvmsimple.R;
import com.example.mvvmsimple.base.BaseActivity;
import com.example.mvvmsimple.event.LoadingEvent;
import com.example.mvvmsimple.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<MainViewModel> {
    ProgressBar progressBar;
    EditText edtEn;
    EditText edtVn;
    Button btnAdd;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        progressBar = findViewById(R.id.progressBar);
        edtEn = findViewById(R.id.edtEn);
        edtVn = findViewById(R.id.edtVn);
        btnAdd = findViewById(R.id.btnAdd);
    }

    @Override
    public MainViewModel getViewModel() {
        return new MainViewModel(new LoadingEvent(progressBar));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel.tuVung.observe(this, data -> {
            if (data!= null) {
                Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
            }
        });

        btnAdd.setOnClickListener(view ->
                mViewModel.getWord(edtEn.getText().toString(),
                        edtVn.getText().toString(),
                        mess -> Toast.makeText(MainActivity.this, mess, Toast.LENGTH_LONG).show()));
    }
}
