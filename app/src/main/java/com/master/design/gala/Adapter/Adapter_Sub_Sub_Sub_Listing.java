package com.master.design.gala.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.DetailsActivity;
import com.master.design.gala.Activity.SubListingActivity;
import com.master.design.gala.Activity.SubSubListingActivity;
import com.master.design.gala.DataModel.ServingServicesList;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.User;

import com.master.design.gala.R;

import java.util.ArrayList;

public class Adapter_Sub_Sub_Sub_Listing extends RecyclerView.Adapter<Adapter_Sub_Sub_Sub_Listing.ViewHolder> {
    private Activity context;
    private ArrayList<ServingServicesList> arrayList;
    private ServingServicesList selected;
    User user;
    String CategoryId;
    String VendorID;

    int selectedPosition = 0;

    public Adapter_Sub_Sub_Sub_Listing(Activity context, ArrayList<ServingServicesList> arrayList,String  CategoryId) {
        this.context = context;
        this.arrayList = arrayList;
        user = new User(context);
        this.CategoryId=CategoryId;

    }


    @NonNull
    @Override
    public Adapter_Sub_Sub_Sub_Listing.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_sub_sub_listing_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Sub_Sub_Sub_Listing.ViewHolder vh = new Adapter_Sub_Sub_Sub_Listing.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Sub_Sub_Sub_Listing.ViewHolder holder, int position) {
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


    private void setDetails(Adapter_Sub_Sub_Sub_Listing.ViewHolder viewHolder, int position) {


        ServingServicesList data = arrayList.get(position);

        viewHolder.name.setText(data.getCategoryName());

        viewHolder.mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(CategoryId.equalsIgnoreCase("7")) {
//                    Intent intent = new Intent(context, SubSubListingActivity.class);
//                    intent.putExtra("CategoryId", CategoryId);
//                    context.startActivity(intent);
//               }else
                if(CategoryId.equalsIgnoreCase("8"))
               {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("CategoryId", CategoryId);
                    intent.putExtra("CategoryName", arrayList.get(position).getCategoryName());
                    intent.putExtra("item",arrayList.get(position).getItem());
                    intent.putExtra(" ServingID",arrayList.get(position).getItem().getServingID());

                    intent.putExtra("title", arrayList.get(position).getCategoryName());
                    context.startActivity(intent);
                }
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

