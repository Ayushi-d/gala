package com.master.design.gala.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.DataModel.CartList;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Add_To_Cart_sub extends RecyclerView.Adapter<Adapter_Add_To_Cart_sub.ViewHolder>{
    private Activity context;
    private ArrayList<CartList> arrayList;
    private SubListingModel selected;
    User user;


    int selectedPosition=0;

    public Adapter_Add_To_Cart_sub(Activity context, ArrayList<CartList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);
    }


    View v;
    @NonNull
    @Override
    public Adapter_Add_To_Cart_sub.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_to_cart_sub_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Add_To_Cart_sub.ViewHolder vh = new Adapter_Add_To_Cart_sub.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Add_To_Cart_sub.ViewHolder holder, int position) {
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




    private void setDetails(Adapter_Add_To_Cart_sub.ViewHolder viewHolder, int position) {


       CartList data = arrayList.get(position);
        Picasso.with(context).load(data.getThumbImage()).into(viewHolder.img);
        viewHolder.heading.setText(data.getHallName());
        viewHolder.people.setText(data.getSelectedNumberOfPeople());
        viewHolder.price.setText(data.getSubTotalKWD_Item());

      

    }
  
    public SubListingModel getSelected() {
        return selected;
    }

    public void setSelected(SubListingModel selected) {
        this.selected = selected;
    }

    public static class ViewHolder   extends RecyclerView.ViewHolder{
        private TextView heading,people,price;
        private ImageView img;
//        private RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.heading);
            people = itemView.findViewById(R.id.people);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.img);

            
        }
    }


}
