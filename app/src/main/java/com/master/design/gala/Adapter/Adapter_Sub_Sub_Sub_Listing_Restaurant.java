package com.master.design.gala.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.DetailsActivity;
import com.master.design.gala.Activity.SubListingActivity;
import com.master.design.gala.Activity.SubSubListingActivity;
import com.master.design.gala.DataModel.CategoryList;
import com.master.design.gala.DataModel.ServingServicesList;
import com.master.design.gala.Helper.User;
import com.master.design.gala.R;

import java.util.ArrayList;

public class Adapter_Sub_Sub_Sub_Listing_Restaurant extends RecyclerView.Adapter<Adapter_Sub_Sub_Sub_Listing_Restaurant.ViewHolder>{

    private Activity context;
    private ArrayList<CategoryList> arrayList;
    private ServingServicesList selected;
    User user;
    String CategoryId;
    String  VendorID;

    int selectedPosition = 0;

    public Adapter_Sub_Sub_Sub_Listing_Restaurant(Activity context, ArrayList<CategoryList> arrayList,String  CategoryId,String VendorID) {
        this.context = context;
        this.arrayList = arrayList;
        user = new User(context);
        this.CategoryId=CategoryId;
        this.VendorID=VendorID;
    }


    @NonNull
    @Override
    public Adapter_Sub_Sub_Sub_Listing_Restaurant.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_sub_sub_listing_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Sub_Sub_Sub_Listing_Restaurant.ViewHolder vh = new Adapter_Sub_Sub_Sub_Listing_Restaurant.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Sub_Sub_Sub_Listing_Restaurant.ViewHolder holder, int position) {
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


    private void setDetails(Adapter_Sub_Sub_Sub_Listing_Restaurant.ViewHolder viewHolder, int position) {


        CategoryList data = arrayList.get(position);

        viewHolder.name.setText(data.getCategoryName());

        viewHolder.mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CategoryId.equalsIgnoreCase("7")) {
                    Intent intent = new Intent(context, SubListingActivity.class);
                    intent.putExtra("CategoryId", CategoryId);
                    intent.putExtra("VendorID",VendorID);
                    intent.putExtra("ProductList",arrayList.get(position).getProductList());
                   context.startActivity(intent);
                }
//                else
//                if(CategoryId.equalsIgnoreCase("8"))
//                {
//                    Intent intent = new Intent(context, DetailsActivity.class);
//                    intent.putExtra("CategoryId", CategoryId);
//                    intent.putExtra("CategoryName", arrayList.get(position).getCategoryName());
//                     context.startActivity(intent);
//                }
            }
        });

    }

    public ServingServicesList getSelected() {
        return selected;
    }

    public void setSelected(ServingServicesList selected) {
        this.selected = selected;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        private CardView mainCard;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTxt);
            mainCard = itemView.findViewById(R.id.maincardView);
        }
    }
    
    
}
