package com.example.storeapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.storeapp.Adapter.CartAdapter;
import com.example.storeapp.Model.Recommendation;
import com.example.storeapp.R;
import com.example.storeapp.databinding.FragmentCartBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    FragmentCartBinding binding;
    ArrayList<Recommendation> list = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        binding = FragmentCartBinding.inflate(inflater,container,false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.cartRecyclerView.setLayoutManager(linearLayoutManager);
        list.add(new Recommendation(R.drawable.bubble_tea,"Bubble Tea","Good day time","56.99"));
        list.add(new Recommendation(R.drawable.purple_tea,"Purple Tea","Happy Hours","25.99"));
        list.add(new Recommendation(R.drawable.bubble_tea,"Bubble Tea","Good day time","56.99"));



        CartAdapter adapter = new CartAdapter(list,getContext());
        binding.cartRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}