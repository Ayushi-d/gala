package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.master.design.gala.Adapter.Adapter_Add_To_Cart;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CategoryListDM;
import com.master.design.gala.DataModel.HallCartListDM;
import com.master.design.gala.DataModel.HallListDM;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AddToCart extends AppCompatActivity {

    User user;
    AppController appController;
    ConnectionDetector connectionDetector;
    DialogUtil dialogUtil;
    Dialog progress;

    String SubTotal_Main;
    String  Total_Main;

    @BindView(R.id.total1)
    TextView total1;



    @BindView(R.id.recycleView111)
    RecyclerView recyclerView;

    @OnClick(R.id.checkoutTxt)
    public void Checkout()
    {
        Intent intent = new Intent(AddToCart.this,Checkout.class);
         intent.putExtra("sub_Total",SubTotal_Main);
         intent.putExtra("total",Total_Main);
         startActivity(intent);

        Helper.showToast(AddToCart.this,getString(R.string.added_successfully));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        user = new User(AddToCart.this);
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(AddToCart.this);
        dialogUtil = new DialogUtil();
        ButterKnife.bind(this);

        total1.setText(Total_Main);

 //       Binding();
    }

//    public void Binding()
//    {
//        if(connectionDetector.isConnectingToInternet())
//        {
//            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//            progress = dialogUtil.showProgressDialog(AddToCart.this,getString(R.string.please_wait));
//            appController.paServices.HallCartList(String.valueOf(user.getId()),refreshedToken, new Callback<HallCartListDM>() {
//                @Override
//                public void success(HallCartListDM hallCartListDM, Response response) {
//                    progress.dismiss();
//                    if (hallCartListDM.getStatus().equalsIgnoreCase("1")) {
//
//                        SubTotal_Main=hallCartListDM.getSubTotal_Main();
//                        Total_Main= hallCartListDM.getTotal_Main();
//
//                        Adapter_Add_To_Cart aa=  new Adapter_Add_To_Cart(AddToCart.this, hallCartListDM.getCartList());
//                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddToCart.this, RecyclerView.VERTICAL, false);
//                        recyclerView.setLayoutManager(linearLayoutManager);
//                        recyclerView.setAdapter(aa);
//
//                    }else
//                        Helper.showToast(AddToCart.this,hallCartListDM.getMessage());
//                }
//
//                @Override
//                public void failure(RetrofitError retrofitError) {
//                    Log.e("error", retrofitError.toString());
//                    progress.dismiss();
//
//                }
//            });
//        }else
//           Helper.showToast(AddToCart.this,getString(R.string.no_internet_connection));
//
//                    }
                }
