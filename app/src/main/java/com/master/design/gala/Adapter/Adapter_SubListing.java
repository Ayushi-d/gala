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
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.DetailsActivity;
import com.master.design.gala.Activity.SubListingActivity;
import com.master.design.gala.Activity.SubSubListingActivity;
import com.master.design.gala.Activity.SubSubSubListing;
import com.master.design.gala.Activity.SubSubSubListing_ViewBinding;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class Adapter_SubListing extends RecyclerView.Adapter<Adapter_SubListing.ViewHolder>{
    private Activity context;
    private ArrayList<SubListingModel> arrayList;
    private SubListingModel selected;
    User user;


    int selectedPosition=0;

    boolean isVertical,isDetail;
    int positionNEw;
    String title;

    public Adapter_SubListing(Activity context, ArrayList<SubListingModel> arrayList,boolean isVertical,int position,boolean isDetail,String title) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);
        this.isVertical = isVertical;
        this.positionNEw=position;
        this.isDetail = isDetail;
        this.title=title;
    }


View v;
     @NonNull
     @Override
    public Adapter_SubListing.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(isVertical)
              v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_listing_vertical_item, parent, false);
         else
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_listing_horizontal_item, parent, false);
          // set the view's size, margins, paddings and layout parameters
           Adapter_SubListing.ViewHolder vh = new Adapter_SubListing.ViewHolder(v);
             return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_SubListing.ViewHolder holder, int position) {
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




    private void setDetails(Adapter_SubListing.ViewHolder viewHolder, int position) {


        SubListingModel data = arrayList.get(position);
 //       viewHolder.img.setImageResource(data.getImgUrl());
        Picasso.with(context).load(data.getImgUrl()).into(viewHolder.img);
        viewHolder.heading.setText(data.getHeading());
        if(data.getDescription()!=null && !data.getDescription().equalsIgnoreCase("")) {
            viewHolder.descrption.setText(Html.fromHtml(data.getDescription(), Html.FROM_HTML_MODE_COMPACT));
        }
             viewHolder.price.setText("Starting from :"+data.getStartsFrom());



        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  /*              if(positionNEw == 0) {
                    Intent intent=new Intent(context, DetailsActivity.class);
                    intent.putExtra("position",positionNEw);
                    intent.putExtra("title",title);
                    context.startActivity(intent);

                }
                    else if(positionNEw==1) {
                        if(isDetail)
                        {
                            Intent intent = new Intent(context, DetailsActivity.class);
                            intent.putExtra("position", positionNEw);
                            intent.putExtra("title",title);

                            context.startActivity(intent);
                        }else {
                            Intent intent = new Intent(context, SubSubListingActivity.class);
                            intent.putExtra("position", positionNEw);
                            intent.putExtra("title",title);

                            context.startActivity(intent);
                        }
                }else if(positionNEw == 2)
                {
                    if(isDetail)
                    {
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("position", positionNEw);
                        intent.putExtra("title",title);

                        context.startActivity(intent);
                    }else {
                        Intent intent = new Intent(context, SubSubListingActivity.class);
                        intent.putExtra("position", positionNEw);
                        intent.putExtra("title",title);
                        context.startActivity(intent);
                    }
                }
                else if(positionNEw == 3 || positionNEw==99)
                {
                    if(isDetail)
                    {
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("position", positionNEw);
                        intent.putExtra("title",title);
                        context.startActivity(intent);
                    }else {
                        Intent intent = new Intent(context, SubListingActivity.class);
                        intent.putParcelableArrayListExtra("data", DummyData.getCatering_Main_2());
                        intent.putExtra("position", 99);
                        intent.putExtra("title",title);
                        context.startActivity(intent);
                    }
                }else if(positionNEw == 4)
                {
                    Intent intent = new Intent(context, SubSubSubListing.class);
                    intent.putExtra("position", positionNEw);
                    intent.putExtra("title",title);
                    context.startActivity(intent);
                }else if(positionNEw == 5)
                {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("position", positionNEw);
                    intent.putExtra("title",title);

                    context.startActivity(intent);
                }*/

                if(arrayList.get(position).getCategoryID().equalsIgnoreCase("1")) {
                    if(isDetail)
                    {
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("HallId", arrayList.get(position).getId());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        intent.putExtra("title",title);
                        context.startActivity(intent);
                    }else {
                        Intent intent = new Intent(context, SubListingActivity.class);
                        intent.putExtra("title", title);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        context.startActivity(intent);
                    }
                }
                else  if(arrayList.get(position).getCategoryID().equalsIgnoreCase("2")) {
                    if(isDetail)
                    {
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("HotelID", arrayList.get(position).getId());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        intent.putExtra("title",title);
                        context.startActivity(intent);

                    }else {

                        Intent intent = new Intent(context, SubListingActivity.class);
                        intent.putExtra("title", title);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        context.startActivity(intent);
                    }
                }
                else if(arrayList.get(position).getCategoryID().equalsIgnoreCase("3")) {
                    if(isDetail)
                    {

                    }else {
                        Intent intent = new Intent(context, SubListingActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                    }
                }else if(arrayList.get(position).getCategoryID().equalsIgnoreCase("4")) {
                    if(isDetail)
                    {
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        intent.putExtra("CateringProductID", arrayList.get(position).getId());
                        intent.putExtra("title",title);
                        context.startActivity(intent);

                    }else {
                        Intent intent = new Intent(context, SubListingActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("title", title);
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        context.startActivity(intent);

                    }
                }else if(arrayList.get(position).getCategoryID().equalsIgnoreCase("5")) {
                    if(isDetail)
                    {

                    }else {
                        Intent intent = new Intent(context, SubListingActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                    }
                }else if(arrayList.get(position).getCategoryID().equalsIgnoreCase("6")) {
                    if(isDetail)
                    {

                        Intent intent = new Intent(context, SubSubListingActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("HotelID", arrayList.get(position).getId());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        intent.putExtra("title",title);
                        context.startActivity(intent);

                    }else {

                        Intent intent = new Intent(context, SubListingActivity.class);
                        intent.putExtra("title", title);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        context.startActivity(intent);
                    }
                }else if(arrayList.get(position).getCategoryID().equalsIgnoreCase("7")) {

                    if(isDetail)
                    {
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("RestProductID", arrayList.get(position).getRestProductID());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        intent.putExtra("title",arrayList.get(position).getHeading());
                        context.startActivity(intent);
                    }else
                        {
                        Intent intent = new Intent(context, SubSubSubListing.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        intent.putExtra("title",arrayList.get(position).getHeading());
                        context.startActivity(intent);
                     }
                }else if(arrayList.get(position).getCategoryID().equalsIgnoreCase("8")) {

                    {
                       Intent intent = new Intent(context, SubSubSubListing.class);

                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        intent.putExtra("title",title);
                        context.startActivity(intent);


                    }
                }else if(arrayList.get(position).getCategoryID().equalsIgnoreCase("9")) {

                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("CategoryId", arrayList.get(position).getCategoryID());
                        intent.putExtra("VendorID", arrayList.get(position).getVendorID());
                        intent.putExtra("title",title);
                        context.startActivity(intent);
                }
            }
        });
    }

    public SubListingModel getSelected() {
        return selected;
    }

    public void setSelected(SubListingModel selected) {
        this.selected = selected;
    }

    public static class ViewHolder   extends RecyclerView.ViewHolder{
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
