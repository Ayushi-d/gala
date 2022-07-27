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

public class TermsAndCondition extends AppCompatActivity {

        AppController appController;
        ConnectionDetector connectionDetector;
        User user;

        @BindView(R.id.termAndCondition)
        TextView termAndCondition;

    public void TermCondition () {
        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            appController.paServices.DataTerm(new Callback<DataPrivacyPolicyDM>() {
                @Override

                public void success(DataPrivacyPolicyDM dataTerm, Response response) {
                    if (dataTerm.getStatus().equalsIgnoreCase("1"))

                        termAndCondition.setText(Html.fromHtml(dataTerm.getItem().getDescription(), Html.FROM_HTML_MODE_COMPACT));

                               //termAndCondition.setText(dataTerm.getItem().getDescription());

                     else
                        Helper.showToast(TermsAndCondition.this,dataTerm.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.e("error", retrofitError.toString());

                }
            });
        } else
            Helper.showToast(TermsAndCondition.this, getString(R.string.no_internet_connection));

    }



    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(this,AddToCart.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);

        ButterKnife.bind(this);

        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(TermsAndCondition.this);
        user = new User(TermsAndCondition.this);
           TermCondition();
    }
}
