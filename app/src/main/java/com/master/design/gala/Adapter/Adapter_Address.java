package com.master.design.gala.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Models.AddressDM;
import com.master.design.gala.R;

import java.util.ArrayList;

public class Adapter_Address extends RecyclerView.Adapter<Adapter_Address.ViewHolder>{

    private Activity context;
    private ArrayList<AddressDM> list;

    public Adapter_Address(Activity context,ArrayList<AddressDM> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_Address.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_address_recycle_data_item, parent, false);

        Adapter_Address.ViewHolder vh = new Adapter_Address.ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Address.ViewHolder holder, int position) {
        setDetails(holder, position);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    private void setDetails(Adapter_Address.ViewHolder viewHolder, int position) {


        AddressDM data = list.get(position);

        viewHolder.home.setText(data.getHome());
        viewHolder.address.setText(data.getAddress());
        viewHolder.direction.setText(data.getDirection());
        viewHolder.phone.setText(data.getPhoneNumber());

  /*      viewHolder.linearLayoutOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, AddToCartActivity.class);
                context.startActivity(intent);

            }
        });  */

    }



    public static class ViewHolder   extends RecyclerView.ViewHolder{
        private TextView home,address,direction,phone;

//       LinearLayout linearLayoutOnClick;


        public ViewHolder(View itemView) {
            super(itemView);
            home= itemView.findViewById(R.id.homeTV);
            address= itemView.findViewById(R.id.addressTV);
            direction= itemView.findViewById(R.id.directionTV);
            phone= itemView.findViewById(R.id.phoneTV);
//            linearLayoutOnClick=itemView.findViewById(R.id.linearOnClick);

        }
    }



}
