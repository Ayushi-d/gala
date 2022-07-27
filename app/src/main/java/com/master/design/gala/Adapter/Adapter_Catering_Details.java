package com.master.design.gala.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.DataModel.Dishes;
import com.master.design.gala.Helper.User;

import com.master.design.gala.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Catering_Details extends RecyclerView.Adapter<Adapter_Catering_Details.ViewHolder> {
    private Activity context;
    private ArrayList<Dishes> arrayList;
    private Dishes selected;
    User user;


    int selectedPosition = 0;


    public Adapter_Catering_Details(Activity context, ArrayList<Dishes> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        user = new User(context);

    }


    View v;

    @NonNull
    @Override
    public Adapter_Catering_Details.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catering_details_items, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Catering_Details.ViewHolder vh = new Adapter_Catering_Details.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Catering_Details.ViewHolder holder, int position) {
        setDetails(holder, position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    private void setDetails(Adapter_Catering_Details.ViewHolder viewHolder, int position) {


        Dishes data = arrayList.get(position);

        Picasso.with(context).load(data.getThumbImage()).into(viewHolder.dishimg);
        viewHolder.dishname.setText(data.getDishName());
        viewHolder.dishcount.setText("5");



//        viewHolder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, DetailsActivity.class));
//
//            }
//        });
    }

    public Dishes getSelected() {
        return selected;
    }

    public void setSelected(Dishes selected) {
        this.selected = selected;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView dishname,dishcount;
        ImageView dishimg,imgminus,imgplus;


        public ViewHolder(View itemView) {
            super(itemView);
             dishname=itemView.findViewById(R.id.heading);
            dishimg=itemView.findViewById(R.id.img);
            imgminus=itemView.findViewById(R.id.minus_dishImg);
            imgplus=itemView.findViewById(R.id.plusdishImg);
            dishcount=itemView.findViewById(R.id.dish_count_img);



        }
    }


}