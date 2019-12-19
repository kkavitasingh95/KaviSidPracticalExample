package com.kavisid.practical.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kavisid.practical.example.R;
import com.kavisid.practical.example.retrofit.RetrofitExample;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnRetrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //initialisation all views
        init();
    }

    void init(){
        btnRetrofit = (Button) findViewById(R.id.btn_retrofit);
        btnRetrofit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnRetrofit)
            startActivity(new Intent(HomeActivity.this, RetrofitExample.class));
    }
}
