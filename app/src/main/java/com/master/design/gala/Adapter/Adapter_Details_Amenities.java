package com.master.design.gala.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.DetailsActivity;
import com.master.design.gala.DataModel.AmenityList;
import com.master.design.gala.Helper.User;

import com.master.design.gala.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Details_Amenities extends RecyclerView.Adapter<Adapter_Details_Amenities.ViewHolder>{
    private Activity context;
    private ArrayList<AmenityList> arrayList;
    private AmenityList selected;
    User user;


    int selectedPosition=0;

    boolean isVertical;

    public Adapter_Details_Amenities(Activity context, ArrayList<AmenityList> arrayList,boolean isVertical) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);
        this.isVertical = isVertical;
    }


    View v;
    @NonNull
    @Override
    public Adapter_Details_Amenities.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_amenities_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Details_Amenities.ViewHolder vh = new Adapter_Details_Amenities.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Details_Amenities.ViewHolder holder, int position) {
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




    private void setDetails(Adapter_Details_Amenities.ViewHolder viewHolder, int position) {


        AmenityList data = arrayList.get(position);

//        Picasso.with(context).load(arrayList.get(position).getImg_plus()).into(viewHolder.img);
           viewHolder.name.setText(data.getAmenity());
           viewHolder.des.setText(data.getPrice());




        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                context.startActivity(new Intent(context, DetailsActivity.class));

//              if(viewHolder.img.getDrawable().getConstantState() == context.getResources().getDrawable(R.drawable.ic_group_5684,null).getConstantState())
//                 {
//                    viewHolder.img.setImageResource(R.drawable.ic_stroke_3);
//                    ((DetailsActivity)context).AmenityIDList = ((DetailsActivity)context).AmenityIDList + data.getAmenityID()+",";
//                    Log.e("Checking","Checking");
//                 } else {
//                    viewHolder.img.setImageResource(R.drawable.ic_group_5684);
// //                 ((DetailsActivity) context).AmenityIDList.replace(data.getAmenityID()+",","");
//                    ((DetailsActivity) context).AmenityIDList= ((DetailsActivity) context).AmenityIDList.replace(data.getAmenityID()+",","");
//                    Log.e("Checking", "Checking");
//                    }


                viewHolder.img.setImageResource(R.drawable.ic_stroke_3);
                ((DetailsActivity)context).AmenityIDList = ((DetailsActivity)context).AmenityIDList + data.getAmenityID()+",";
                Log.e("Checking","Checking");
            }
        });
    }




    public AmenityList getSelected() {
        return selected;
    }

    public void setSelected(AmenityList selected) {
        this.selected = selected;
    }

    public static class ViewHolder   extends RecyclerView.ViewHolder{
        private TextView name,des;
        private ImageView img;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.heading);
            des= itemView.findViewById(R.id.descriptionTxt);


            img = itemView.findViewById(R.id.img);
        }
    }


}
