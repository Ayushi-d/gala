package com.master.design.gala.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.DataModel.Description;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;

import java.util.ArrayList;

public class Adapter_Description extends RecyclerView.Adapter<Adapter_Description.ViewHolder>{
    private Activity context;
    private ArrayList<Description> arrayList;
    private SubListingModel selected;
    User user;


    int selectedPosition=0;

    boolean isVertical;

    public Adapter_Description(Activity context, ArrayList<Description> arrayList,boolean isVertical) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);
        this.isVertical = isVertical;
    }


    View v;
    @NonNull
    @Override
    public Adapter_Description.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.descrption_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Description.ViewHolder vh = new Adapter_Description.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Description.ViewHolder holder, int position) {
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




    private void setDetails(Adapter_Description.ViewHolder viewHolder, int position) {


        Description data = arrayList.get(position);

        viewHolder.des.setText(data.getDishType());




//        viewHolder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, DetailsActivity.class));
//
//            }
//        });
    }

    public SubListingModel getSelected() {
        return selected;
    }

    public void setSelected(SubListingModel selected) {
        this.selected = selected;
    }

    public static class ViewHolder   extends RecyclerView.ViewHolder{
        private TextView des;



        public ViewHolder(View itemView) {
            super(itemView);
            des= itemView.findViewById(R.id.text1);
        }
    }


}