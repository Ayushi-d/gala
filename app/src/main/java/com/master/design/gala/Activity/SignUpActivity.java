package com.master.design.gala.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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

public class SignUpActivity extends AppCompatActivity {
    AppController appController;
    ConnectionDetector connectionDetector;
    User user;
    DialogUtil dialogUtil;
    Dialog progress;

    @BindView(R.id.fullNameET)
    EditText fullNameET;

    @BindView(R.id.emailET)
    EditText emailEt;

    @BindView(R.id.passwordET)
    EditText passwordET;

    @BindView(R.id.confirmPasswordET)
    EditText confirmPasswordET;

    @BindView(R.id.countryCodeET)
    EditText countryCodeET;

    @BindView(R.id.mobilenumberET)
    EditText mobilenumberET;

    @BindView(R.id.checkboxCB)
    CheckBox checkboxCB;

    @BindView(R.id.alreadyaccountTxt)
    TextView alreadyaccountTxt;

    @OnClick(R.id.loginTxt)
    public void SignUp () {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }



    @OnClick(R.id.checkboxCB)
    public void checkboxCB  (){ startActivity(new Intent(SignUpActivity.this, TermsAndCondition.class)); }



    @OnClick(R.id.signUpTxt)
    public void Signup()
    {


        if(connectionDetector.isConnectingToInternet())
        {
            boolean correct =true;
            if(fullNameET.getText().toString().equalsIgnoreCase(""))
            {
                correct=false;
                Helper.showToast(SignUpActivity.this,"kindly enter your name");
            }
           else if(emailEt.getText().toString().equalsIgnoreCase(""))
            {
                correct=false;
                Helper.showToast(SignUpActivity.this,"kindly enter your email");
            }
            else if (passwordET.getText().toString().equalsIgnoreCase("")){
                correct=false;
                Helper.showToast(SignUpActivity.this,"kindly enter your password");
            }

            else if (confirmPasswordET.getText().toString().equalsIgnoreCase("")){
                correct=false;
                Helper.showToast(SignUpActivity.this,"kindly enter your confirm password");
            }
            else if (countryCodeET.getText().toString().equalsIgnoreCase("")) {
                correct=false;
                Helper.showToast(SignUpActivity.this,"kindly enter your country Code");
            }
           else if(mobilenumberET.getText().toString().equalsIgnoreCase("")){
                correct=false;
                Helper.showToast(SignUpActivity.this,"kindly enter your mobile number");
            }

           else if(!checkboxCB.isChecked())
            {
                correct=false;
                Helper.showToast(SignUpActivity.this,"kindly read terms and conditions");
            }


        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
           if(correct) {
                progress = dialogUtil.showProgressDialog(SignUpActivity.this,getString(R.string.please_wait));

                appController.paServices.CustomerRegister(fullNameET.getText().toString(), emailEt.getText().toString(), countryCodeET.getText().toString(), mobilenumberET.getText().toString(), passwordET.getText().toString(), confirmPasswordET.getText().toString(), "2", refreshedToken, new Callback<CustomerRegisterDM>() {
                            @Override

                            public void success ( CustomerRegisterDM customerRegisterDM, Response response ) {
                                progress.dismiss();
                                if (customerRegisterDM.getStatus().equalsIgnoreCase("1") || customerRegisterDM.getStatus().equalsIgnoreCase("5") || customerRegisterDM.getStatus().equalsIgnoreCase("4") || customerRegisterDM.getStatus().equalsIgnoreCase("3") || customerRegisterDM.getStatus().equalsIgnoreCase("2")) {
//

                                    user.setId(Integer.valueOf(customerRegisterDM.getCustomerID()));


                                    startActivity(new Intent(SignUpActivity.this, VerifyActivity.class));

                                } else
                                    Helper.showToast(SignUpActivity.this, customerRegisterDM.getMessage());
                            }

                            @Override
                            public void failure ( RetrofitError retrofitError ) {
                                progress.dismiss();
                                Log.e("error", retrofitError.toString());

                            }
                        });
            }
        }else
            Helper.showToast(SignUpActivity.this,getString(R.string.no_internet_connection));



    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(SignUpActivity.this);
        user = new User(SignUpActivity.this);
        dialogUtil = new DialogUtil();

    }
}



