package com.master.design.gala.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.DataModel.CartList;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;

import java.util.ArrayList;

public class Adapter_My_Order extends RecyclerView.Adapter<Adapter_My_Order.ViewHolder>{
    private Activity context;
    private ArrayList<SubListingModel> arrayList;
    private SubListingModel selected;
    User user;


    int selectedPosition=0;

    public Adapter_My_Order(Activity context, ArrayList<SubListingModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);
    }


    View v;
    @NonNull
    @Override
    public Adapter_My_Order.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_My_Order.ViewHolder vh = new Adapter_My_Order.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_My_Order.ViewHolder holder, int position) {
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




    private void setDetails(Adapter_My_Order.ViewHolder viewHolder, int position) {


        SubListingModel data = arrayList.get(position);
        Binding(viewHolder);

    }
    public void Binding(Adapter_My_Order.ViewHolder viewHolder){
//    {
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
//        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);
//        viewHolder.recyclerView.setAdapter(new Adapter_Add_To_Cart_sub(context, arrayList));

        viewHolder.viewPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(!viewHolder.isViewing)
                    {
                        viewHolder.paymentLL.setVisibility(View.VISIBLE);
                        viewHolder.isViewing=true;
                    }else
                    {
                        viewHolder.paymentLL.setVisibility(View.GONE);
                        viewHolder.isViewing=false;
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
        private TextView heading,descrption,price,viewPayment;
        private ImageView img;
        private RecyclerView recyclerView;
        private LinearLayout paymentLL;

        private boolean isViewing=false;
        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView= itemView.findViewById(R.id.recycleView);
            viewPayment = itemView.findViewById(R.id.viewAllDetails);
            paymentLL=itemView.findViewById(R.id.paymentLL);
        }
    }


}