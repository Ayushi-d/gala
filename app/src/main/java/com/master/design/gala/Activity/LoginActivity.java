package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.Login;
import com.google.firebase.iid.FirebaseInstanceId;
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

public class LoginActivity extends AppCompatActivity {
    AppController appController;
    ConnectionDetector connectionDetector;
    User user;
    DialogUtil dialogUtil;
    Dialog progress;

    @BindView(R.id.emailET)
    EditText emailET;

    @BindView(R.id.passwordET)
    EditText passwordET;

    @BindView(R.id.loginTxt)
    TextView loginTxt;

    @BindView(R.id.forgetpasswordTxt)
    TextView forgetpasswordTxt;

    @BindView(R.id.googlesignImgV)
    ImageView googlesignImgV;

    @BindView(R.id.donthaveaccountTxt)
    TextView donthaveaccountTxt;

    @BindView(R.id.signUpTxt)
    TextView signUpTxt;



    @OnClick(R.id.signUpTxt)
    public void SignUp()
    {
        startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
    }


    @OnClick(R.id.loginTxt)
    public void Login()
    {

        if(connectionDetector.isConnectingToInternet())
        {

            boolean correct = true;
            if(emailET.getText().toString().equalsIgnoreCase(""))
            {
                correct=false;
                Helper.showToast(LoginActivity.this,"kindly enter your email");
            }

           else if(passwordET.getText().toString().equalsIgnoreCase(""))
            {
                correct=false;
                Helper.showToast(LoginActivity.this,"kindly enter your password");
            }

            else if (correct) {
                String refreshedToken = FirebaseInstanceId.getInstance().getToken();

                progress = dialogUtil.showProgressDialog(LoginActivity.this, getString(R.string.please_wait));

                appController.paServices.CustomerLogin(emailET.getText().toString(), passwordET.getText().toString(),
                        "2", refreshedToken, new Callback<CustomerRegisterDM>() {

                            @Override

                            public void success ( CustomerRegisterDM customerRegisterDM, Response response ) {
                                progress.dismiss();
                                if (customerRegisterDM.getStatus().equalsIgnoreCase("1")) {
//                        Helper.shwToast(LoginActivity.this,customerRegisterDM.getMessage());
                                    user.setId(Integer.valueOf(customerRegisterDM.getCustomerID()));

                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();

                                } else
                                    Helper.showToast(LoginActivity.this, customerRegisterDM.getMessage());
                            }

                            @Override
                            public void failure ( RetrofitError retrofitError ) {
                                progress.dismiss();

                                Log.e("error", retrofitError.toString());

                            }
                        });
            }
        }else
            Helper.showToast(LoginActivity.this,getString(R.string.no_internet_connection));

//        startActivity(new Intent(LoginActivity.this,MainActivity.class));

    }


    @OnClick(R.id.forgetpasswordTxt)
    public  void ForgetPassword(){

        if(connectionDetector.isConnectingToInternet())
        {

            progress = dialogUtil.showProgressDialog(LoginActivity.this,getString(R.string.please_wait));

            String refreshedToken = FirebaseInstanceId.getInstance().getToken();


            appController.paServices.CustomerForgetPassword(emailET.getText().toString(), new Callback<CustomerResendOtpDM>() {
                @Override

                public void success ( CustomerResendOtpDM customerResendOtpDM, Response response )
                {
                    progress.dismiss();
                    if(customerResendOtpDM.getStatus().equalsIgnoreCase("1"))
                    {
                        Helper.showToast(LoginActivity.this,customerResendOtpDM.getMessage());

                    }else
                        Helper.showToast(LoginActivity.this,customerResendOtpDM.getMessage());
                }

                @Override
                public void failure ( RetrofitError retrofitError ) {
                    progress.dismiss();
                    Log.e("error",retrofitError.toString());

                }
            });
        }else
            Helper.showToast(LoginActivity.this,getString(R.string.no_internet_connection));

//        startActivity(new Intent(LoginActivity.this,MainActivity.class));

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(LoginActivity.this);
        user = new User(LoginActivity.this);

        dialogUtil = new DialogUtil();

    }
}
