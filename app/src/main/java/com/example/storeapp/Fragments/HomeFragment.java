package com.example.storeapp.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.storeapp.Adapter.FragmentAdapter;
import com.example.storeapp.Adapter.VerticalAdapter;
import com.example.storeapp.Model.Recommendation;
import com.example.storeapp.R;
import com.example.storeapp.UserInfoActivity;
import com.example.storeapp.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<Recommendation> list = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        binding.mainHamburgerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });

        binding.Viewpager.setAdapter(new FragmentAdapter(getChildFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.Viewpager);

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LinearLayout tabLayout = (LinearLayout)((ViewGroup) binding.tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
//                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);
                tabTextView.setTextAppearance(R.style.tab_text_selected);

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LinearLayout tabLayout = (LinearLayout)((ViewGroup) binding.tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
//                tabTextView.setTypeface(null, Typeface.NORMAL);
                tabTextView.setTextAppearance(R.style.tab_text);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerViewWillBuy.setLayoutManager(linearLayoutManager);
        list.add(new Recommendation(R.drawable.bubble_tea,"Bubble Tea","Good day time","56.99"));
        list.add(new Recommendation(R.drawable.purple_tea,"Purple Tea","Happy Hours","25.99"));
        list.add(new Recommendation(R.drawable.bubble_tea,"Bubble Tea","Good day time","56.99"));



        VerticalAdapter adapter = new VerticalAdapter(list,getContext());
        binding.recyclerViewWillBuy.setAdapter(adapter);

        return binding.getRoot();
    }
}