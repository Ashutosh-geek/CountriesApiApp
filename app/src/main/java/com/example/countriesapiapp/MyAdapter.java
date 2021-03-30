package com.example.countriesapiapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;



import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter .HomeViewHolder> {
    private Context context;
    private List<Countries> countriesList;
    private itemClickListener clickListener;

    public void setOnItemClickListener(itemClickListener listener){
        clickListener=listener;
    }

    public MyAdapter(Context context, List<Countries> countriesList) {
        this.context = context;
        this.countriesList = countriesList;

    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_add, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, int position) {
    holder.name.setText(countriesList.get(position).getName());
        SvgLoader.pluck().with((Activity) context).load(countriesList.get(position).getFlagurl(),holder.flagImage);


    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView flagImage;
        public AdapterView.OnItemClickListener itemClickListener;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
          name = itemView.findViewById(R.id.profile_username_txt);
        flagImage = itemView.findViewById(R.id.profile_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(clickListener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            clickListener.onItemClick(position);
                        }
                    }
                }
            });
        }


    }
}