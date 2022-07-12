package com.example.storeapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeapp.Model.Recommendation;
import com.example.storeapp.R;
import com.example.storeapp.databinding.WillBuyViewBinding;

import java.util.ArrayList;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.viewHolder>{

    ArrayList<Recommendation> list;
    Context context;

    public VerticalAdapter(ArrayList<Recommendation> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VerticalAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.will_buy_view,parent,false);


        return new VerticalAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalAdapter.viewHolder holder, int position) {

        Recommendation willBuy = list.get(position);

        holder.binding.drinKImageWillBuy.setImageResource(willBuy.getImage());
        holder.binding.drinkName.setText(willBuy.getDrink());
        holder.binding.drinkDescription.setText(willBuy.getDescription());
        holder.binding.drinkRate.setText(willBuy.getRate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        WillBuyViewBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = WillBuyViewBinding.bind(itemView);


        }
    }
}
