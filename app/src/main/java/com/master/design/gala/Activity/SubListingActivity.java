package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.master.design.gala.Adapter.Adapter_MainListing;
import com.master.design.gala.Adapter.Adapter_SubListing;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CategoryList;
import com.master.design.gala.DataModel.CateringList;
import com.master.design.gala.DataModel.CateringListDM;
import com.master.design.gala.DataModel.ECommerceList;
import com.master.design.gala.DataModel.ECommerceListDM;
import com.master.design.gala.DataModel.HallList;
import com.master.design.gala.DataModel.HallListDM;
import com.master.design.gala.DataModel.HotelList;
import com.master.design.gala.DataModel.HotelListDM;
import com.master.design.gala.DataModel.ProductList;
import com.master.design.gala.DataModel.RestaurantListDM;
import com.master.design.gala.DataModel.ServingServicesList;
import com.master.design.gala.DataModel.ServingServicesListDM;
import com.master.design.gala.DataModel.VendorList;
import com.master.design.gala.DataModel.VendorListDM;
import com.master.design.gala.Helper.BottomDateTimeSelector;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.OccasionDataModel;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.square1.richtextlib.v2.parser.handlers.Markers;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SubListingActivity extends AppCompatActivity implements  ResponseListener {

    AppController appController;
    ConnectionDetector connectionDetector;
    DialogUtil dialogUtil;
    Dialog dialog;


    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    @BindView(R.id.viewTxt)
    TextView viewTxt;

    @BindView(R.id.title)
    TextView title;

    String CategoryID;
    String VendorID;


    @BindView(R.id.date) TextView date;

    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(this,AddToCart.class));
    }

    @OnClick(R.id.viewTxt)
    public void View()
    {
        isVertical=!isVertical;
        if(isVertical)
        {
            VerticalView();
        }else
        {
            HorizontalView();
        }
    }
    BottomDateTimeSelector bottomDateTimeSelector;

    public void OpenBottomSheet()
    {
        bottomDateTimeSelector= new BottomDateTimeSelector();
        bottomDateTimeSelector.setResponseListener(this);

        bottomDateTimeSelector.show(getSupportFragmentManager(), "bottomSheetCountry");
    }
    boolean isVertical=true;

    boolean isDetail=false;

    public void VerticalView() {
        viewTxt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_two_icon, 0, 0, 0);

        if(position == 99)
            isDetail = true;

        if(CategoryID!=null && VendorID==null) {
           VendListingAPI(true);
        }
        else {
            if (CategoryID.equalsIgnoreCase("1")) {
               HallListingAPI(true);
            }else if(CategoryID.equalsIgnoreCase("2"))
            {
 //Hotel
                 HotelListingAPI(true);
            }else if(CategoryID.equalsIgnoreCase("3"))
            {
//Coffee
            }else if(CategoryID.equalsIgnoreCase("4"))
            {
                CateringListingAPI(true);
//Catering
            }else if(CategoryID.equalsIgnoreCase("5"))
            {
//Decoration
            }else if(CategoryID.equalsIgnoreCase("6"))
            {    ECommerceListingApi(true);
//ecommerce
            }else if(CategoryID.equalsIgnoreCase("7"))
               {
                  RestaurantListingAPI(true);
//restaurent
            }else if(CategoryID.equalsIgnoreCase("8"))
            {

//service
            }else if(CategoryID.equalsIgnoreCase("9"))
            {
//parking
            }
        }


    }

    public void HorizontalView()
    {
        viewTxt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_list_icon, 0, 0, 0);
        if(position==99)
            isDetail=true;

        if(CategoryID!=null && VendorID==null ) {
                VendListingAPI(false);
        } else {

            if (CategoryID.equalsIgnoreCase("1")) {
              HallListingAPI(false);
            }else if(CategoryID.equalsIgnoreCase("2"))
            {          HotelListingAPI(false);
//Hotel
            }else if(CategoryID.equalsIgnoreCase("3"))
            {
//Coffee
            }else if(CategoryID.equalsIgnoreCase("4"))
            {
                CateringListingAPI(true);
//Catering
            }else if(CategoryID.equalsIgnoreCase("5"))
            {
//Decoration
            }else if(CategoryID.equalsIgnoreCase("6"))
            {
                ECommerceListingApi(false);
//ecommerce

            }else if(CategoryID.equalsIgnoreCase("7"))
            {
                RestaurantListingAPI(false);
//restaurent
            }else if(CategoryID.equalsIgnoreCase("8"))
            {

//service
            }else if(CategoryID.equalsIgnoreCase("9"))
            {
//parking
            }
        }



    }

    public void VendListingAPI(boolean isVertical)
    {
        if (connectionDetector.isConnectingToInternet()) {
            dialog = dialogUtil.showProgressDialog(SubListingActivity.this, getString(R.string.please_wait));
            appController.paServices.VendorList(CategoryID, new Callback<VendorListDM>() {
                @Override
                public void success(VendorListDM vendorListDM, Response response) {
                    dialog.dismiss();
                    if (vendorListDM.getStatus().equalsIgnoreCase("1")) {
                        ArrayList<SubListingModel> subListingModels = new ArrayList<>();
                        for (VendorList v : vendorListDM.getList()) {
                            SubListingModel s = new SubListingModel();
                            s.setHeading(v.getName());
                            s.setHeadingAr(v.getNameAr());
                            s.setDescription(v.getDescription());
                            s.setDescriptionAr(v.getDescriptionAr());
                            s.setStartsFrom(v.getStartsFrom());
                            s.setStartsFromAr(v.getStartsFromAr());
                            s.setImgUrl(v.getImage());
                            s.setVendorID(v.getVendorID());
                            s.setCategoryID(CategoryID);

                            subListingModels.add(s);
                        }


                        Adapter_SubListing occasionAdapter = new Adapter_SubListing(SubListingActivity.this, subListingModels, isVertical, position, isDetail, title.getText().toString());
                       if(isVertical)
                       {
                           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SubListingActivity.this,RecyclerView.VERTICAL,false);
                           recyclerView.setLayoutManager(linearLayoutManager);
                           recyclerView.setAdapter(occasionAdapter);
                       }else
                       {
                           GridLayoutManager linearLayoutManager = new GridLayoutManager(SubListingActivity.this, 2);
                           recyclerView.setLayoutManager(linearLayoutManager);
                           recyclerView.setAdapter(occasionAdapter);
                       }



                    } else
                        Helper.showToast(SubListingActivity.this, vendorListDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {

                    dialog.dismiss();


                }
            });
        } else
            Helper.showToast(SubListingActivity.this, getString(R.string.no_internet_connection));
    }

    public void HallListingAPI(boolean isVertical)
    {
        if (connectionDetector.isConnectingToInternet()) {
            dialog = dialogUtil.showProgressDialog(SubListingActivity.this, getString(R.string.please_wait));
            appController.paServices.HallList(VendorID, new Callback<HallListDM>() {
                @Override
                public void success(HallListDM hallList, Response response) {
                    dialog.dismiss();
                    if (hallList.getStatus().equalsIgnoreCase("1")) {
                        ArrayList<SubListingModel> subListingModels = new ArrayList<>();
                        for (HallList v : hallList.getList()) {
                            SubListingModel s = new SubListingModel();
                            s.setHeading(v.getHallName());
                            s.setHeadingAr(v.getHallNameAr());
                            s.setDescription(v.getDescription());
                            s.setDescriptionAr(v.getDescriptionAr());
                            s.setStartsFrom(v.getStartingPrice());
                            s.setStartsFromAr(v.getStartingPriceAr());
                            s.setImgUrl(v.getThumbImage());
                            s.setId(v.getHallID());
                            s.setVendorID(VendorID);
                            s.setCategoryID(CategoryID);


                            subListingModels.add(s);
                        }

                        isDetail = true;
                        Adapter_SubListing occasionAdapter = new Adapter_SubListing(SubListingActivity.this, subListingModels, isVertical, position, isDetail, title.getText().toString());
                        if(isVertical)
                        {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SubListingActivity.this,RecyclerView.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }else
                        {
                            GridLayoutManager linearLayoutManager = new GridLayoutManager(SubListingActivity.this, 2);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }
                    } else
                        Helper.showToast(SubListingActivity.this, hallList.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    dialog.dismiss();

                }
            });
        } else
            Helper.showToast(SubListingActivity.this, getString(R.string.no_internet_connection));

    }




    public void  HotelListingAPI(boolean isVertical)
    {
        if (connectionDetector.isConnectingToInternet()) {
            dialog = dialogUtil.showProgressDialog(SubListingActivity.this, getString(R.string.please_wait));
            appController.paServices.HotelList(VendorID ,new Callback<HotelListDM>() {
                @Override
                public void success(HotelListDM hotelListDM, Response response) {
                    dialog.dismiss();
                    if (hotelListDM.getStatus().equalsIgnoreCase("1")) {
                        ArrayList<SubListingModel> subListingModels = new ArrayList<>();
                        for (HotelList v : hotelListDM.getList()) {
                            SubListingModel s = new SubListingModel();
                            s.setHeading(v.getHotelName());
                            s.setHeadingAr(v.getHotelNameAr());
                            s.setDescription(v.getDescription());
                            s.setDescriptionAr(v.getDescriptionAr());
                            s.setStartsFrom(v.getStartingPrice());
                            s.setStartsFromAr(v.getStartingPriceAr());
                            s.setImgUrl(v.getThumbImage());
                            s.setId(v.getHotelID());
                            s.setCategoryID(CategoryID);
                            s.setVendorID(VendorID);
                            subListingModels.add(s);
                        }

                        isDetail = true;
                        Adapter_SubListing occasionAdapter = new Adapter_SubListing(SubListingActivity.this, subListingModels, isVertical, position, isDetail, title.getText().toString());
                        if(isVertical)
                        {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SubListingActivity.this,RecyclerView.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }else
                        {
                            GridLayoutManager linearLayoutManager = new GridLayoutManager(SubListingActivity.this, 2);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }
                    } else
                        Helper.showToast(SubListingActivity.this, hotelListDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    dialog.dismiss();

                }
            });
        } else
            Helper.showToast(SubListingActivity.this, getString(R.string.no_internet_connection));

    }






    public void ECommerceListingApi(boolean isVertical)
    {
        if (connectionDetector.isConnectingToInternet()) {
            dialog = dialogUtil.showProgressDialog(SubListingActivity.this, getString(R.string.please_wait));
            appController.paServices.ECommerceList(new Callback<ECommerceListDM>() {
                @Override
                public void success(ECommerceListDM eCommerceListDM, Response response) {
                    dialog.dismiss();
                    if (eCommerceListDM.getStatus().equalsIgnoreCase("1")) {
                        ArrayList<SubListingModel> subListingModels = new ArrayList<>();
                        for (ECommerceList v : eCommerceListDM.getList()) {
                            SubListingModel s = new SubListingModel();
                            s.setHeading(v.getVendorName());
                            s.setHeadingAr(v.getVendorNameAr());
                            s.setDescription(v.getDescription());
                            s.setDescriptionAr(v.getDescriptionAr());
                            s.setImgUrl(v.getImage());
                            s.setVendorID(v.getVendorID());
                            s.setCategoryID(CategoryID);

                            subListingModels.add(s);
                        }

                        isDetail=true;
                        Adapter_SubListing occasionAdapter = new Adapter_SubListing(SubListingActivity.this, subListingModels, isVertical, position, isDetail, title.getText().toString());
                        if(isVertical)
                        {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SubListingActivity.this,RecyclerView.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }else
                        {
                            GridLayoutManager linearLayoutManager = new GridLayoutManager(SubListingActivity.this, 2);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }



                    } else
                        Helper.showToast(SubListingActivity.this, eCommerceListDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    dialog.dismiss();

                }
            });
        } else
            Helper.showToast(SubListingActivity.this, getString(R.string.no_internet_connection));
    }



    public void  RestaurantListingAPI(boolean isVertical)
    {
                     ArrayList<SubListingModel> subListingModels = new ArrayList<>();
                        for (ProductList v : productLists) {
                            SubListingModel s = new SubListingModel();
                            s.setHeading(v.getRestProductName());
                            s.setHeadingAr(v.getRestProductNameAr());
                            s.setDescription(v.getDescription());
                            s.setDescriptionAr(v.getDescriptionAr());
                            s.setStartsFrom(v.getUnitPrice());
                            s.setStartsFromAr(v.getUnitPriceAr());
                            s.setImgUrl(v.getThumbImage());
                            s.setRestProductID(v.getRestProductID());
                            s.setCategoryID(CategoryID);
                            s.setVendorID(VendorID);
                           subListingModels.add(s);
                        }

                        isDetail = true;
                        Adapter_SubListing occasionAdapter = new Adapter_SubListing(SubListingActivity.this, subListingModels, isVertical, position, isDetail, title.getText().toString());
                        if(isVertical)
                       {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SubListingActivity.this,RecyclerView.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }else
                        {
                            GridLayoutManager linearLayoutManager = new GridLayoutManager(SubListingActivity.this, 2);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }

                      }




    public void  CateringListingAPI(boolean isVertical)
   {
        if (connectionDetector.isConnectingToInternet()) {
            dialog = dialogUtil.showProgressDialog(SubListingActivity.this, getString(R.string.please_wait));
            appController.paServices.CateringList(VendorID, new Callback<CateringListDM>() {
               @Override
                public void success(CateringListDM cateringListDM, Response response) {
                    dialog.dismiss();
                    if (cateringListDM.getStatus().equalsIgnoreCase("1")) {
                        ArrayList<SubListingModel> subListingModels = new ArrayList<>();
                        for (CateringList v : cateringListDM.getList()) {

                            SubListingModel s = new SubListingModel();

                            s.setHeading(v.getCateringProductName());
                            s.setHeadingAr(v.getCateringProductNameAr());
                            s.setDescription(v.getDescription());
                            s.setDescriptionAr(v.getDescriptionAr());
                            s.setStartsFrom(v.getStartingPrice());
                            s.setStartsFromAr(v.getStartingPriceAr());
                            s.setId(v.getCateringProductID());
                            s.setImgUrl(v.getThumbImage());
                            s.setCategoryID(CategoryID);
                            s.setVendorID(VendorID);


                            subListingModels.add(s);
                        }

                        isDetail = true;
                        Adapter_SubListing occasionAdapter = new Adapter_SubListing(SubListingActivity.this, subListingModels, isVertical, position, isDetail, title.getText().toString());
                        if(isVertical)
                        {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SubListingActivity.this,RecyclerView.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);
                        }else
                        {
                            GridLayoutManager linearLayoutManager = new GridLayoutManager(SubListingActivity.this, 2);
                            recyclerView.setLayoutManager(linearLayoutManager);
                           recyclerView.setAdapter(occasionAdapter);
                        }
                    } else
                        Helper.showToast(SubListingActivity.this,cateringListDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    dialog.dismiss();

               }
            });
        } else
            Helper.showToast(SubListingActivity.this, getString(R.string.no_internet_connection));
    }





    @OnClick(R.id.date)
            public void chooseDate()
    {
        OpenBottomSheet();
    }

    ArrayList<ProductList> productLists;
int position;
    @OnClick(R.id.filterImg)
    public void FilterImg()
    {
        Intent intent=new Intent(this,FilterActivity.class);
        startActivity(intent);
    }
ArrayList<SubListingModel> data;
   User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_listing);
        ButterKnife.bind(this);
        user = new User(SubListingActivity.this);
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(SubListingActivity.this);
        dialogUtil = new DialogUtil();
        date.setText(user.getSelectedDate());


        if(getIntent().getStringExtra("CategoryId")!=null)
            CategoryID=getIntent().getStringExtra("CategoryId");

        if(getIntent().getStringExtra("VendorID")!=null)
            VendorID = getIntent().getStringExtra("VendorID");

       productLists  = getIntent().getParcelableArrayListExtra("ProductList");

        data = getIntent().getParcelableArrayListExtra("data");
        title.setText(getIntent().getStringExtra("title"));
        position=getIntent().getIntExtra("position",0);
        Binding();
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
    public void Binding()
    {
        VerticalView();
    }
}
