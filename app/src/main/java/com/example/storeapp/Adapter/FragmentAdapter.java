package com.example.storeapp.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.storeapp.Fragments.BlackTeaFragment;
import com.example.storeapp.Fragments.GreenTeaFragment;
import com.example.storeapp.Fragments.RecommendationFragment;


public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 : return new RecommendationFragment();
            case 1 : return new BlackTeaFragment();
            case 2 : return new GreenTeaFragment();
            default: return new RecommendationFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Recommendation";
            case 1:
                return "Black Tea";
            case 2:
                return "Green Tea" ;

            default:
                return "Recommendation";
        }

    }
}
