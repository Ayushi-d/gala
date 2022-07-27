package com.master.design.gala.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.AddToCart;
import com.master.design.gala.Activity.DetailsActivity;
import com.master.design.gala.Activity.SubListingActivity;
import com.master.design.gala.Activity.SubSubListingActivity;
import com.master.design.gala.Activity.SubSubSubListing;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CartList;
import com.master.design.gala.DataModel.HallCartListDM;
import com.master.design.gala.DataModel.HallDeleteCartDM;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Adapter_Add_To_Cart extends RecyclerView.Adapter<Adapter_Add_To_Cart.ViewHolder>{
    private Activity context;
    private ArrayList<CartList> arrayList;
    private CartList selected;
    User user;

    Dialog progress;
    DialogUtil dialogUtil;

    AppController appController;
    ConnectionDetector connectionDetector;



    int selectedPosition=0;

    public Adapter_Add_To_Cart(Activity context, ArrayList<CartList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);
        dialogUtil = new DialogUtil();
        appController = (AppController) context.getApplicationContext();
        connectionDetector = new ConnectionDetector(context);

    }


    View v;
    @NonNull
    @Override
    public Adapter_Add_To_Cart.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_to_cart_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Adapter_Add_To_Cart.ViewHolder vh = new Adapter_Add_To_Cart.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Add_To_Cart.ViewHolder holder, int position) {
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




    private void setDetails(Adapter_Add_To_Cart.ViewHolder viewHolder, int position) {


        CartList data = arrayList.get(position);
        Picasso.with(context).load(data.getThumbImage()).into(viewHolder.img);
        viewHolder.heading.setText(data.getHallName());
        viewHolder.people.setText(data.getSelectedNumberOfPeople());
        viewHolder.price.setText(data.getSubTotalKWD_Item());
        viewHolder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (connectionDetector.isConnectingToInternet()) {
                    progress = dialogUtil.showProgressDialog(context, context.getString(R.string.please_wait));

                    appController.paServices.HallDeleteCart(data.getHallCartID(), new Callback<HallDeleteCartDM>() {
                        @Override
                        public void success(HallDeleteCartDM hallDeleteCartDM, Response response) {
                            progress.dismiss();
                            if (hallDeleteCartDM.getStatus().equalsIgnoreCase("1")) {

                                arrayList.remove(selectedPosition);
                                notifyItemRemoved(position);
                                notifyDataSetChanged();
                                Helper.showToast(context, "item deleted succesfully");


//                                openHelper.deleteProduct(shoppingCart.getId());
//                                shoppingCartList.remove(position);
//                                notifyItemRemoved(position);

                            } else
                                Helper.showToast(context, "item does not deleted");
                        }

                        @Override
                        public void failure(RetrofitError retrofitError) {
                            progress.dismiss();
                            Log.e("error", retrofitError.toString());

                        }
                    });
                } else
                    Helper.showToast(context, String.valueOf(R.string.no_internet_connection));




    }
        });


//        Binding(viewHolder);
//
//    }
//    public void Binding(Adapter_Add_To_Cart.ViewHolder viewHolder)
//    {
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
//        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);
//        viewHolder.recyclerView.setAdapter(new Adapter_Add_To_Cart_sub(context, arrayList));

    }


    public static class ViewHolder   extends RecyclerView.ViewHolder{
        private TextView heading,descrption,price,people;
        private ImageView img,deleteImg;
//        private RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.heading111);
            people = itemView.findViewById(R.id.people111);
            price = itemView.findViewById(R.id.price111);
            img = itemView.findViewById(R.id.img111);
            deleteImg= itemView.findViewById(R.id.deleteImg);
        }
    }


}
