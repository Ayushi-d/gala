package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CheckoutDM;
import com.master.design.gala.DataModel.HallCartListDM;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.User;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Checkout extends AppCompatActivity {

    User user;
    AppController appController;
    ConnectionDetector connectionDetector;
    DialogUtil dialogUtil;
    Dialog progress;
    String SubTotal_Main;
    String Total_Main;
    StringBuffer sb  = new StringBuffer();
    String PaymentMethod;
    String payemturl;


    @BindView(R.id.subTotalTextView)
     TextView subTotalTextView;

     @BindView(R.id.TotalTextView)
     TextView TotalTextView;

    @BindView(R.id.total)
    TextView total;


    @BindView(R.id.radioGroup)
     RadioGroup radioGroup;

      Intent intent;

    @OnClick(R.id.payNowTxt)
    public void PayNow()
      {
          Binding();

      }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        user = new User(Checkout.this);
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(Checkout.this);
        dialogUtil = new DialogUtil();
        ButterKnife.bind(this);
        SubTotal_Main=getIntent().getStringExtra("sub_Total");
        Total_Main=getIntent().getStringExtra("total");

        subTotalTextView.setText(SubTotal_Main);
        TotalTextView.setText(Total_Main);
         total.setText(Total_Main);

        radio();



    }

    public void Binding() {
        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            progress = dialogUtil.showProgressDialog(Checkout.this, getString(R.string.please_wait));
            appController.paServices.HallCheckout(String.valueOf(user.getId()), "1",PaymentMethod,SubTotal_Main,Total_Main,"1", new Callback<CheckoutDM>() {
                @Override
                public void success(CheckoutDM checkoutDM, Response response) {
                    progress.dismiss();
                    if (checkoutDM.getStatus().equalsIgnoreCase("1")) {
                      payemturl=checkoutDM.getPaymentURL();

                        intent = new Intent(Checkout.this,PayNowActivity.class);
                        intent.putExtra("PaymentUrl",payemturl) ;
                                              startActivity(intent);

                    } else
                        Helper.showToast(Checkout.this, checkoutDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.e("error", retrofitError.toString());
                    progress.dismiss();

                }
            });
        } else
            Helper.showToast(Checkout.this, getString(R.string.no_internet_connection));

    }

    public void radio()
    {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radio1:
//                        Helper.showToast(Checkout.this,"radio1");

                      sb.append("1");
                         PaymentMethod="2";
                        // do operations specific to this selection
                        break;
                    case R.id.radio2:
 //                       Helper.showToast(Checkout.this,"radio2");

                        sb.append("2");
                        PaymentMethod="3";
                        // do operations specific to this selection
                        break;
                    case R.id.radio3:
//                        Helper.showToast(Checkout.this,"radio3");

                        sb.append("3");
                        PaymentMethod="1";
                        // do operations specific to this selection
                        break;
                }
            }
        });
    }


}
