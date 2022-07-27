package com.master.design.gala.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.SubListingActivity;
import com.master.design.gala.DataModel.CateringDishes;
import com.master.design.gala.Helper.User;

import com.master.design.gala.R;

import java.util.ArrayList;

public class Adapter_Description_2 extends RecyclerView.Adapter<Adapter_Description_2.ViewHolder> {
    private Activity context;
    private ArrayList<CateringDishes> arrayList;
    private CateringDishes selected;
    User user;


    int selectedPosition = 0;

    boolean isVertical;

    public Adapter_Description_2(Activity context, ArrayList<CateringDishes> arrayList, boolean isVertical) {
        this.context = context;
        this.arrayList = arrayList;
        user = new User(context);
        this.isVertical = isVertical;
    }


    View v;

    @NonNull
    @Override
    public Adapter_Description_2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.description_two_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Description_2.ViewHolder vh = new Adapter_Description_2.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Description_2.ViewHolder holder, int position) {
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


    private void setDetails(Adapter_Description_2.ViewHolder viewHolder, int position) {


        CateringDishes data = arrayList.get(position);
//        viewHolder.img.setImageResource(data.getImg());
//        viewHolder.name.setText(data.getHeading());

        viewHolder.name.setText(data.getDishType());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        viewHolder.recyclerView.setAdapter(new Adapter_Catering_Details(context, data.getDishes()));

//        viewHolder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, DetailsActivity.class));
//
//            }
//        });
    }

    public CateringDishes getSelected() {
        return selected;
    }

    public void setSelected(CateringDishes selected) {
        this.selected = selected;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.heading);
            recyclerView = itemView.findViewById(R.id.recycleView);
        }
    }


}
