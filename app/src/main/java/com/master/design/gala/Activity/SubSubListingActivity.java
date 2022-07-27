package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.iid.FirebaseInstanceId;
import com.master.design.gala.Adapter.DynamicFragmentAdapter;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CategoryList;
import com.master.design.gala.DataModel.DataPrivacyPolicyDM;
import com.master.design.gala.DataModel.ECommerceCategoryList;
import com.master.design.gala.DataModel.ECommerceCategoryListDM;
import com.master.design.gala.DataModel.ECommerceCategoryProductListDM;
import com.master.design.gala.DataModel.ECommerceListDM;
import com.master.design.gala.Helper.BottomDateTimeSelector;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.OccasionDataModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SubSubListingActivity extends AppCompatActivity implements ResponseListener {

    AppController appController;
    ConnectionDetector connectionDetector;
    DialogUtil dialogUtil;
    Dialog dialog;
    User user;

    String CategoryID;
    String VendorID;


    private ViewPager viewPager;
    private TabLayout mTabLayout;
    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(this,AddToCart.class));
    }
    @BindView(R.id.title)
    TextView title;
    BottomDateTimeSelector bottomDateTimeSelector;


    @OnClick(R.id.filterImg)
    public void FilterImg()
    {
        Intent intent=new Intent(this,FilterActivity.class);
        startActivity(intent);
    }

    public void OpenBottomSheet()
    {
        bottomDateTimeSelector= new BottomDateTimeSelector();
        bottomDateTimeSelector.setResponseListener(this);

        bottomDateTimeSelector.show(getSupportFragmentManager(), "bottomSheetCountry");
    }
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sub_listing);
        ButterKnife.bind(this);

        user = new User(SubSubListingActivity.this);
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(SubSubListingActivity.this);
        dialogUtil = new DialogUtil();

        title.setText(getIntent().getStringExtra("title"));
        CategoryID=getIntent().getStringExtra("CategoryId");
        VendorID = getIntent().getStringExtra("VendorID");
//        position = getIntent().getIntExtra("position",0);
        initViews();
    }

    private void initViews() {

        // initialise the layout
        viewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tablayout);

        // setOffscreenPageLimit means number
        // of tabs to be shown in one page
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // setCurrentItem as the tab position
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setDynamicFragmentToTabLayout();
    }

    // show all the tab using DynamicFragmnetAdapter
    public void setDynamicFragmentToTabLayout() {
        // here we have given 10 as the tab number
        // you can give any number here

            // set the tab name as "Page: " + i

        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            dialog = dialogUtil.showProgressDialog(SubSubListingActivity.this, getString(R.string.please_wait));
            appController.paServices.ECommerceCategoryProductList(VendorID, new Callback<ECommerceCategoryProductListDM>() {
                @Override
                public void success(ECommerceCategoryProductListDM eCommerceCategoryProductListDM, Response response) {
                    dialog.dismiss();

                    if (eCommerceCategoryProductListDM.getStatus().equalsIgnoreCase("1")) {


                        for (CategoryList list:eCommerceCategoryProductListDM.getCategoryList()
                        ) {
                            mTabLayout.addTab(mTabLayout.newTab().setText(list.getCategoryName()));
                        }


                        DynamicFragmentAdapter mDynamicFragmentAdapter = new DynamicFragmentAdapter(getSupportFragmentManager(), mTabLayout.getTabCount(), eCommerceCategoryProductListDM.getCategoryList(),CategoryID,VendorID);


                        // set the adapter
                        viewPager.setAdapter(mDynamicFragmentAdapter);

                        // set the current item as 0 (when app opens for first time)
                        viewPager.setCurrentItem(0);

                    }
                    else
                        Helper.showToast(SubSubListingActivity.this,eCommerceCategoryProductListDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    dialog.dismiss();
                    Log.e("error", retrofitError.toString());

                }
            });
        } else
            Helper.showToast(SubSubListingActivity.this, getString(R.string.no_internet_connection));
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