package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.master.design.gala.Adapter.Adapter_MainListing;
import com.master.design.gala.Adapter.Adapter_Sub_Sub_Sub_Listing;
import com.master.design.gala.Adapter.Adapter_Sub_Sub_Sub_Listing_Restaurant;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.DataPrivacyPolicyDM;
import com.master.design.gala.DataModel.ParkingDetailsDM;
import com.master.design.gala.DataModel.RestaurantListDM;
import com.master.design.gala.DataModel.ServingServicesListDM;
import com.master.design.gala.Helper.BottomDateTimeSelector;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.OccasionDataModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;
import com.master.design.gala.notification.MyFirebaseInstanceIDService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SubSubSubListing extends AppCompatActivity implements ResponseListener {

    AppController appController;
    ConnectionDetector connectionDetector;
    User user;


    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(this,AddToCart.class));
    }

    @BindView(R.id.title)
    TextView title;


//   @BindView(R.id.date)
//    TextView date;

     String CategoryId;
     String VendorID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sub_sub_listing);
        ButterKnife.bind(this);
        user = new User(SubSubSubListing.this);
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(SubSubSubListing.this);


        CategoryId = getIntent().getStringExtra("CategoryId");
        VendorID= getIntent().getStringExtra("VendorID");

        if (CategoryId.equalsIgnoreCase("7")) {

            RestaurantsBinding();

        }else if(CategoryId.equalsIgnoreCase("8")) {

            ServingServicesBinding();
        }
    }
    BottomDateTimeSelector bottomDateTimeSelector;

    public void OpenBottomSheet()
    {
        bottomDateTimeSelector= new BottomDateTimeSelector();
        bottomDateTimeSelector.setResponseListener(this);

        bottomDateTimeSelector.show(getSupportFragmentManager(), "bottomSheetCountry");
    }


    public void ServingServicesBinding()
    {
        if (connectionDetector.isConnectingToInternet()) {
//       String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            appController.paServices.ServingServicesList(VendorID,new Callback<ServingServicesListDM>() {
               @Override

                public void success(ServingServicesListDM servingServicesListDM, Response response) {
                    if (servingServicesListDM.getStatus().equalsIgnoreCase("1")) {


                        Adapter_Sub_Sub_Sub_Listing occasionAdapter = new Adapter_Sub_Sub_Sub_Listing(SubSubSubListing.this, servingServicesListDM.getList(), getIntent().getStringExtra("CategoryId"));
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SubSubSubListing.this, RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(occasionAdapter);


                    }

                   else
                    Helper.showToast(SubSubSubListing.this,servingServicesListDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.e("error", retrofitError.toString());

                }
            });
        } else
            Helper.showToast(SubSubSubListing.this, getString(R.string.no_internet_connection));
    }





    public void RestaurantsBinding()
    {
        if (connectionDetector.isConnectingToInternet()) {
//            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            appController.paServices.RestaurantList(VendorID,new Callback<RestaurantListDM>() {
                @Override

                public void success(RestaurantListDM restaurantListDM, Response response) {
                    if (restaurantListDM.getStatus().equalsIgnoreCase("1")) {

                        title.setText(getIntent().getStringExtra("title"));

                        Adapter_Sub_Sub_Sub_Listing_Restaurant occasionAdapter = new Adapter_Sub_Sub_Sub_Listing_Restaurant(SubSubSubListing.this, restaurantListDM.getCategoryList(), getIntent().getStringExtra("CategoryId"), getIntent().getStringExtra("VendorID"));
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SubSubSubListing.this, RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(occasionAdapter);

                    }

                    else
                        Helper.showToast(SubSubSubListing.this,restaurantListDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.e("error", retrofitError.toString());

                }
            });
        } else
            Helper.showToast(SubSubSubListing.this, getString(R.string.no_internet_connection));
    }








//
//    @OnClick(R.id.date)
//    public void chooseDate()
//    {
//        OpenBottomSheet();
//    }

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
