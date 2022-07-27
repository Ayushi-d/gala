package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.master.design.gala.Adapter.Adapter_MainListing;
import com.master.design.gala.Adapter.OccasionAdapter;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CategoryList;
import com.master.design.gala.DataModel.CategoryListDM;
import com.master.design.gala.Helper.BottomDateTimeSelector;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.OccasionDataModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;
import com.master.design.gala.Utils.Helper;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainListingActivity extends AppCompatActivity implements ResponseListener {
    User user;
    AppController appController;
    ConnectionDetector connectionDetector;
    DialogUtil dialogUtil;

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    Dialog progress;

    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(MainListingActivity.this,AddToCart.class));
    }
    BottomDateTimeSelector bottomDateTimeSelector;

    public void OpenBottomSheet()
    {
        bottomDateTimeSelector= new BottomDateTimeSelector();
        bottomDateTimeSelector.setResponseListener(this);

        bottomDateTimeSelector.show(getSupportFragmentManager(), "bottomSheetCountry");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listing);
        ButterKnife.bind(this);
        user = new User(MainListingActivity.this);
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(MainListingActivity.this);
        dialogUtil = new DialogUtil();
//        ArrayList<CategoryList> fCategoryData = getIntent().getParcelableArrayListExtra("data");
        DataBinding();



    }

    public void DataBinding()
    {
        if(connectionDetector.isConnectingToInternet())
        {
            progress = dialogUtil.showProgressDialog(MainListingActivity.this,getString(R.string.please_wait));
            appController.paServices.CategoryList(new Callback<CategoryListDM>() {
                @Override
                public void success(CategoryListDM categoryListDM, Response response) {
                    progress.dismiss();
                    if(categoryListDM.getStatus().equalsIgnoreCase("1")) {
                        Adapter_MainListing occasionAdapter = new Adapter_MainListing(MainListingActivity.this, categoryListDM.getList());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainListingActivity.this, RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(occasionAdapter);
                    }else
                        Helper.showToast(MainListingActivity.this,categoryListDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    progress.dismiss();

                }
            });
        }else
            Helper.showToast(MainListingActivity.this,getString(R.string.no_internet_connection));
    }

    @Override
    public void response(Object object) {
        if(object instanceof OccasionDataModel) {
            if(((OccasionDataModel) object).getHeading().equalsIgnoreCase("wedding"))
            {

            }else
            {

            }
        }


    }
}
