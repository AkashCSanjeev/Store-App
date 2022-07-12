package com.example.storeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.storeapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        Intent intent = getIntent();
        String name = intent.getStringExtra("drinkName");
        String description = intent.getStringExtra("description");
        String rate = intent.getStringExtra("rate");
        int image = getIntent().getIntExtra("image",0);

        binding.drinkname.setText(name);
        binding.drinkImage.setImageResource(image);
        binding.drinkDescription.setText(description);
        binding.drinkRate.setText(rate);

        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}