package com.example.storeapp.Adapter;



import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeapp.DetailsActivity;
import com.example.storeapp.Model.Recommendation;
import com.example.storeapp.R;
import com.example.storeapp.databinding.RecommendationViewBinding;

import java.util.ArrayList;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.viewHolder>{

    ArrayList<Recommendation> list;
    Context context;

    public HorizontalAdapter(ArrayList<Recommendation> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recommendation_view,parent,false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Recommendation recommendation = list.get(position);

        if(position == 0) holder.binding.bookmark.setVisibility(View.VISIBLE);
        holder.binding.drinkImage.setImageResource(recommendation.getImage());
        holder.binding.drinkName.setText(recommendation.getDrink());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("drinkName",recommendation.getDrink());
                intent.putExtra("image",recommendation.getImage());
                intent.putExtra("rate",recommendation.getRate());
                intent.putExtra("description",recommendation.getDescription());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        RecommendationViewBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = RecommendationViewBinding.bind(itemView);


        }
    }
}