package com.example.storeapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.storeapp.Fragments.CartFragment;
import com.example.storeapp.Fragments.HomeFragment;
import com.example.storeapp.Fragments.ShopFragment;
import com.example.storeapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.bottomNavBar.getMenu().findItem(R.id.home).setChecked(true);


        replaceFragment(new HomeFragment());
        binding.bottomNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
//                        Toast.makeText(MainActivity.this, "ee", Toast.LENGTH_SHORT).show();
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.cart:
//                        Toast.makeText(MainActivity.this, "ee", Toast.LENGTH_SHORT).show();
                        replaceFragment(new CartFragment());
                        break;
                    case R.id.shop:
//                        Toast.makeText(MainActivity.this, "ee", Toast.LENGTH_SHORT).show();

                        replaceFragment(new ShopFragment());
                        break;
                }

                return true;
            }
        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.farmelayout,fragment);
        fragmentTransaction.commit();
    }
}