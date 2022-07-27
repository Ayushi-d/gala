package com.master.design.gala.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.MainListingActivity;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CategoryList;
import com.master.design.gala.DataModel.OccasionList;
import com.master.design.gala.DataModel.OccasionListDM;
import com.master.design.gala.Helper.BottomDateTimeSelector;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Helper.User;

import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class OccasionAdapter extends RecyclerView.Adapter<OccasionAdapter.ViewHolder> implements ResponseListener {
    private Activity context;


    public Intent intent;
    private ArrayList<OccasionList> arrayList;
    private OccasionList selected;
    User user;

    int getSelectedPosition;

    int selectedPosition=0;

    public OccasionAdapter(Activity context, ArrayList<OccasionList> arrayList,int selectedPosition) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);
        getSelectedPosition=selectedPosition;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.occasion_items, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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


    public void OpenBottomSheet(ArrayList<CategoryList> categoryLists) {

        bottomDateTimeSelector = new BottomDateTimeSelector();
        bottomDateTimeSelector.setResponseListener(this);
        bottomDateTimeSelector.selectedPosition = getSelectedPosition;
        bottomDateTimeSelector.categoryLists111 = categoryLists;
        bottomDateTimeSelector.show(((AppCompatActivity) context).getSupportFragmentManager(), "bottomSheetCountry");





    }




    private void setDetails(OccasionAdapter.ViewHolder viewHolder, int position) {


        OccasionList data = arrayList.get(position);
//        viewHolder.img.setImageResource(data.);

        Picasso.with(context).load(arrayList.get(position).getImage()).into(viewHolder.img);
        viewHolder.mainHeading.setText(data.getName());
        viewHolder.description.setText(data.getDescription());


        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                OpenBottomSheet(data.getCategoryList());
            }
        });
    }

    public OccasionList getSelected() {
        return selected;
    }

    public void setSelected(OccasionList selected) {
        this.selected = selected;
    }

    public static class ViewHolder   extends RecyclerView.ViewHolder{
        private TextView mainHeading,description;
        private ImageView img;


        public ViewHolder(View itemView) {
            super(itemView);
            mainHeading = itemView.findViewById(R.id.headingTxt);
            description = itemView.findViewById(R.id.descriptionTxt);
            img = itemView.findViewById(R.id.img);

        }
    }

    @Override
    public void response(Object object) {
        if(object instanceof OccasionList) {
            if(((OccasionList) object).getOccasionID().equalsIgnoreCase("1"))
            {

            }else
            {

            }
        }


    }
}
