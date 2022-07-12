package com.example.storeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.storeapp.databinding.ActivityMainBinding;
import com.example.storeapp.databinding.ActivityUserInfoBinding;

public class UserInfoActivity extends AppCompatActivity {

    ActivityUserInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityUserInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfoActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}