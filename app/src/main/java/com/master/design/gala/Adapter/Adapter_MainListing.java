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

import com.master.design.gala.Activity.SubListingActivity;
import com.master.design.gala.DataModel.CategoryList;
import com.master.design.gala.Helper.BottomDateTimeSelector;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Helper.User;

import com.master.design.gala.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_MainListing extends RecyclerView.Adapter<Adapter_MainListing.ViewHolder>{
    private Activity context;
    private ArrayList<CategoryList> arrayList;
    private CategoryList selected;
    User user;


    int selectedPosition=0;

    public Adapter_MainListing(Activity context, ArrayList<CategoryList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);

    }



    @NonNull
    @Override
    public Adapter_MainListing.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_listing_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_MainListing.ViewHolder vh = new Adapter_MainListing.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_MainListing.ViewHolder holder, int position) {
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




    private void setDetails(Adapter_MainListing.ViewHolder viewHolder, int position) {


        CategoryList data = arrayList.get(position);
//       viewHolder.img.setImageResource(data.get);
        Picasso.with(context).load(arrayList.get(position).getImage()).into(viewHolder.img);
        viewHolder.name.setText(data.getCategoryName());



        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,SubListingActivity.class);
                intent.putExtra("title",arrayList.get(position).getCategoryName());
                intent.putExtra("CategoryId",arrayList.get(position).getCategoryID());
                context.startActivity(intent);

            }
        });
    }

    public CategoryList getSelected() {
        return selected;
    }

    public void setSelected(CategoryList selected) {
        this.selected = selected;
    }

    public static class ViewHolder   extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView img;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTxt);
            img = itemView.findViewById(R.id.img);
        }
    }


}
