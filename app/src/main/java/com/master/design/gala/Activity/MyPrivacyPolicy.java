package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.DataPrivacyPolicyDM;
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

public class MyPrivacyPolicy extends AppCompatActivity {

    AppController appController;
    ConnectionDetector connectionDetector;
    User user;

    @BindView(R.id.MyPrivacyPolicy)
    TextView DataPrivacyPolicy;

    public void MyPrivacyPolicy () {
        if (connectionDetector.isConnectingToInternet()) {

            appController.paServices.DataPrivacyPolicy(new Callback<DataPrivacyPolicyDM>() {
                @Override

                public void success(DataPrivacyPolicyDM dataPrivacyPolicyDM, Response response) {
                    if (dataPrivacyPolicyDM.getStatus().equalsIgnoreCase("1"))

                        DataPrivacyPolicy.setText(Html.fromHtml(dataPrivacyPolicyDM.getItem().getDescription(), Html.FROM_HTML_MODE_COMPACT));

                        //termAndCondition.setText(dataTerm.getItem().getDescription());

                    else
                        Helper.showToast(MyPrivacyPolicy.this,dataPrivacyPolicyDM.getMessage());
                }

                @Override
                public void failure( RetrofitError retrofitError) {
                    Log.e("error", retrofitError.toString());

                }
            });
        } else
            Helper.showToast(MyPrivacyPolicy.this, getString(R.string.no_internet_connection));

    }



    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(this,AddToCart.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_privacy_policy);
        ButterKnife.bind(this);

        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(MyPrivacyPolicy.this);
        user = new User(MyPrivacyPolicy.this);
        MyPrivacyPolicy();

    }
}
