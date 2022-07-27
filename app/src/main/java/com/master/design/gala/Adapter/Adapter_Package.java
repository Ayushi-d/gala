package com.master.design.gala.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.AddToCart;
import com.master.design.gala.Activity.DetailsActivity;
import com.master.design.gala.Helper.BottomDateTimeSelector;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.OccasionDataModel;
import com.master.design.gala.R;

import java.util.ArrayList;

public class Adapter_Package extends RecyclerView.Adapter<Adapter_Package.ViewHolder> implements ResponseListener {
    private Activity context;
    private ArrayList<OccasionDataModel> arrayList;
    private OccasionDataModel selected;
    User user;


    int selectedPosition=0;

    public Adapter_Package(Activity context, ArrayList<OccasionDataModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);

    }



    @NonNull
    @Override
    public Adapter_Package.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.package_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Package.ViewHolder vh = new Adapter_Package.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Package.ViewHolder holder, int position) {
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
    BottomDateTimeSelector bottomDateTimeSelector;

    public void OpenBottomSheet()
    {
        bottomDateTimeSelector= new BottomDateTimeSelector();
        bottomDateTimeSelector.setResponseListener(this);
        bottomDateTimeSelector.show(((AppCompatActivity)context).getSupportFragmentManager(), "bottomSheetCountry");
    }

    private void setDetails(Adapter_Package.ViewHolder viewHolder, int position) {


        OccasionDataModel data = arrayList.get(position);
        viewHolder.img.setImageResource(data.getImg());
        viewHolder.mainHeading.setText(data.getHeading());
        viewHolder.description.setText(data.getDescription());

        viewHolder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, AddToCart.class));

            }
        });


    }

    public OccasionDataModel getSelected() {
        return selected;
    }

    public void setSelected(OccasionDataModel selected) {
        this.selected = selected;
    }

    public static class ViewHolder   extends RecyclerView.ViewHolder{
        private TextView mainHeading,description,price,addToCart;
        private ImageView img;


        public ViewHolder(View itemView) {
            super(itemView);
            mainHeading = itemView.findViewById(R.id.heading);
            description = itemView.findViewById(R.id.descriptionTxt);
            img = itemView.findViewById(R.id.img);
            price = itemView.findViewById(R.id.priceTxt);
            addToCart=itemView.findViewById(R.id.loginTxt);
        }
    }

    @Override
    public void response(Object object) {
        if(object instanceof OccasionDataModel) {
            if(((OccasionDataModel) object).getHeading().equalsIgnoreCase("wedding"))
            {

            }else
            {

            }
        }
    }
}
