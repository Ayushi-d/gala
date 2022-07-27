package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CustomerRegisterDM;
import com.master.design.gala.DataModel.CustomerResendOtpDM;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.User;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;
import com.master.design.gala.Utils.Helper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class VerifyActivity extends AppCompatActivity {

    AppController appController;
    ConnectionDetector connectionDetector;
    User user;
    DialogUtil dialogUtil;
    Dialog progress;


    @BindView(R.id.timerTxt)
    TextView timerTxt;

    @BindView(R.id.resendTxt)
    TextView resendTxt;

    @BindView(R.id.editmobileTxt)
    TextView editmobileTxt;

    @BindView(R.id.otp_view)
    in.aabhasjindal.otptextview.OtpTextView otpTextView;

    @BindView(R.id.verifyTxt)
    TextView verifyTxt;


//

    @OnClick(R.id.editmobileTxt)
    public void editmobileTxt () {
        startActivity(new Intent(VerifyActivity.this, SignUpActivity.class));
    }

    @OnClick(R.id.resendTxt)
    public void ResendTxt () {

        if (connectionDetector.isConnectingToInternet()) {



            progress = dialogUtil.showProgressDialog(VerifyActivity.this,getString(R.string.please_wait));

            String customerId =String.valueOf(user.getId()) ;

            appController.paServices.CustomerResendOtp(customerId, new Callback<CustomerResendOtpDM>() {
                @Override
                public void success ( CustomerResendOtpDM customerResendOtpDM, Response response ) {
                    progress.dismiss();
                    if (customerResendOtpDM.getStatus().equalsIgnoreCase("1")) {
//                        Helper.showToast(SignUpActivity.this,customerRegisterDM.getMessage());

                        startActivity(new Intent(VerifyActivity.this, SuccessfullyActivity.class));


                    } else
                        Helper.showToast(VerifyActivity.this, customerResendOtpDM.getMessage());
                }

                @Override
                public void failure ( RetrofitError retrofitError ) {
                    progress.dismiss();
                    Log.e("error", retrofitError.toString());

                }
            });

        } else
            Helper.showToast(VerifyActivity.this,getString(R.string.no_internet_connection));

    }

    @OnClick(R.id.verifyTxt)
    public void VerifyText(){


        if(connectionDetector.isConnectingToInternet())
        {
            progress = dialogUtil.showProgressDialog(VerifyActivity.this,getString(R.string.please_wait));

            String customerId =String.valueOf(user.getId()) ;

            appController.paServices.CustomerVerify( customerId,otpTextView.getOTP(), new Callback<CustomerRegisterDM>() {
                @Override

                    public void success ( CustomerRegisterDM customerRegisterDM, Response response ) {
                    progress.dismiss();
                    if(customerRegisterDM.getStatus().equalsIgnoreCase("1"))
                    {
//                        Helper.showToast(SignUpActivity.this,customerRegisterDM.getMessage());

                        startActivity(new Intent(VerifyActivity.this,SuccessfullyActivity.class));


                    }else
                        Helper.showToast(VerifyActivity.this,customerRegisterDM.getMessage());
                }

                @Override
                public void failure ( RetrofitError retrofitError ) {
                    progress.dismiss();
                    Log.e("error",retrofitError.toString());

                }
            });
        }else
            Helper.showToast(VerifyActivity.this,getString(R.string.no_internet_connection));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        ButterKnife.bind(this);

        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(VerifyActivity.this);
        user = new User(VerifyActivity.this);
        dialogUtil = new DialogUtil();
    }
}
