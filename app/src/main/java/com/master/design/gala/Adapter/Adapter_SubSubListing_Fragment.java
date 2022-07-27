package com.master.design.gala.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.DetailsActivity;
import com.master.design.gala.Activity.SubSubListingActivity;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_SubSubListing_Fragment extends RecyclerView.Adapter<Adapter_SubSubListing_Fragment.ViewHolder> {
    private Activity context;
    private ArrayList<SubListingModel> arrayList;
    private SubListingModel selected;
    User user;


    int selectedPosition = 0;

    public Adapter_SubSubListing_Fragment(Activity context, ArrayList<SubListingModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        user = new User(context);
    }


    @NonNull
    @Override
    public Adapter_SubSubListing_Fragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_listing_horizontal_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_SubSubListing_Fragment.ViewHolder vh = new Adapter_SubSubListing_Fragment.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_SubSubListing_Fragment.ViewHolder holder, int position) {
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


    private void setDetails(Adapter_SubSubListing_Fragment.ViewHolder viewHolder, int position) {


        SubListingModel data = arrayList.get(position);
        //       viewHolder.img.setImageResource(data.getImgUrl());
        Picasso.with(context).load(data.getImgUrl()).into(viewHolder.img);
        viewHolder.heading.setText(data.getHeading());
//        viewHolder.descrption.setText(Html.fromHtml(data.getDescription(),Html.FROM_HTML_MODE_COMPACT));
        viewHolder.descrption.setVisibility(View.GONE);
        viewHolder.price.setText(data.getPrice());
        
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                intent.putExtra("ProductID", arrayList.get(position).getId());
                intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                intent.putExtra("title",arrayList.get(position).getHeading());
                context.startActivity(intent);


            }
        });

    }

    public SubListingModel getSelected() {
        return selected;
    }

    public void setSelected(SubListingModel selected) {
        this.selected = selected;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView heading,descrption,price;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            descrption = itemView.findViewById(R.id.descriptionTxt);
            price = itemView.findViewById(R.id.priceTxt);

            img = itemView.findViewById(R.id.img);
        }
    }
}
