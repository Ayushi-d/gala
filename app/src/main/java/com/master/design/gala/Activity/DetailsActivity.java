package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.transition.Visibility;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.iid.FirebaseInstanceId;

import com.master.design.gala.Adapter.Adapter_Description;
import com.master.design.gala.Adapter.Adapter_Description_2;
import com.master.design.gala.Adapter.Adapter_Details_Amenities;
import com.master.design.gala.Adapter.SliderAdapterExample;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CateringDetailsDM;
import com.master.design.gala.DataModel.Combinations;
import com.master.design.gala.DataModel.ECommerceProductDetailsDM;
import com.master.design.gala.DataModel.HallAddToCartDM;
import com.master.design.gala.DataModel.HallDetailsDM;
import com.master.design.gala.DataModel.HotelDetailsDM;
import com.master.design.gala.DataModel.ImageList;
import com.master.design.gala.DataModel.Images;
import com.master.design.gala.DataModel.Item;
import com.master.design.gala.DataModel.ParkingDetailsDM;
import com.master.design.gala.DataModel.RestaurantDetailsDM;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.SliderItem;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetailsActivity extends AppCompatActivity implements ResponseListener {

    AppController appController;
    ConnectionDetector connectionDetector;
    DialogUtil dialogUtil;
    Dialog dialog;

    @BindView(R.id.titleTextView)
    TextView  titleTextView;

    @BindView(R.id.selectTVDropDown)
    TextView  selectTVDropDown;

    @BindView(R.id.heading)
    TextView  heading;

    @BindView(R.id.termsAndConditionTxt)
    TextView  termsAndConditionTxt;

    @BindView(R.id.refundPolicyTxt)
    TextView  refundPolicyTxt;

    @BindView(R.id.priceTxt)
    TextView  priceTxt;

    @BindView(R.id.outSideFoodPolicyTxt)
    TextView  outSideFoodPolicyTxt;

 //   @BindView(R.id.noteET)
 //   EditText noteET;


    @BindView(R.id.descriptionTxt)
    TextView  descriptionTxt;


    @BindView(R.id.img)
    ImageView img;

    @BindView(R.id.imageSlider)
    SliderView imageSlider;

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    @BindView(R.id.descriptionRecycleView)
    RecyclerView descriptionRV;


    @BindView(R.id.recycleText) TextView recycleText;

    @BindView(R.id.colorText)
    TextView colorText;

    @BindView(R.id.measureImg) ImageView measureImg;


    @OnClick(R.id.addToBag)
    public void AddToBag()
    {


        startActivity(new Intent(this,AddToCart.class));
    }
    @BindView(R.id.color_1)
    ImageView color_1;
    @BindView(R.id.color_2)
    ImageView color_2;
    @BindView(R.id.color_3)
    ImageView color_3;
    @BindView(R.id.color_4)
    ImageView color_4;


    @BindView(R.id.colorLL)
    LinearLayout colorLL;

    @BindView(R.id.measureLL)
    LinearLayout measureLL;

    @BindView(R.id.descriptionRecycleLL)
    LinearLayout descriptionRecycleLL;

    @BindView(R.id.recycleViewLLWithText)
    LinearLayout recycleViewLLWithText;

//    int positionNew;

    int quantity=15;

    @BindView(R.id.quantityTxt)
    TextView quantityTxt;



@OnClick(R.id.minusImg)
public void minusClicked()
{
    quantity = quantity-1;
    if(quantity!=0)
    {
        quantityTxt.setText(String.valueOf(quantity));
    }

}


    @OnClick(R.id.plusImg)
    public void plusClicked()
    {
        quantity = quantity+1;

            quantityTxt.setText(String.valueOf(quantity));


    }

    @OnClick(R.id.AddToCartTV)
    public void AddToCart()
    {
//        Toast.makeText(DetailsActivity.this, getString(R.string.item_added_cart), Toast.LENGTH_SHORT).show();

        Helper.showToast(DetailsActivity.this,getString(R.string.item_added_cart));


            if (CategoryId.equalsIgnoreCase("1")) {
 //Hall
                HallAddToCart();
            }else if(CategoryId.equalsIgnoreCase("2"))
            {
 //Hotel
                HotalAddToCart();
            }else if(CategoryId.equalsIgnoreCase("3"))
            {
//Coffee
            }else if(CategoryId.equalsIgnoreCase("4"))
            {

//Catering
            }else if(CategoryId.equalsIgnoreCase("5"))
            {
//Decoration
            }else if(CategoryId.equalsIgnoreCase("6"))
            {          EcommerceAddToCart();
//ecommerce
            }else if(CategoryId.equalsIgnoreCase("7"))
            {
                    RestaurentAddToCart();
//restaurent
            }else if(CategoryId.equalsIgnoreCase("8"))
            {
                    ServicingServiceAddToCart();
//service
            }else if(CategoryId.equalsIgnoreCase("9"))
            {
                    ParkingAddToCart();
//parking
            }
    }




    @OnClick(R.id.submitTxt)
    public void submit()
    {
//        startActivity(new Intent(DetailsActivity.this,AddToCart.class));
//        Toast.makeText(DetailsActivity.this, getString(R.string.item_added_cart), Toast.LENGTH_SHORT).show();

        Helper.showToast(DetailsActivity.this,"submit button");
    }



  String   CategoryId;
  String   VendorID;
  String   HallID;
  String   HotelID;
  String   title;
  String   CategoryName;
  String   ProductID;
  String   ParkingID;
  String   CateringProductID;
  String   RestProductID;
  String   EComProductID;
  String   RestCombinationID;
  String   EComCombinationID;
  String  BookingRequestDate="13/05/2022";
  Item item;
  User user;

    @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
//        positionNew = getIntent().getIntExtra("position", 0);
        user = new User(DetailsActivity.this);
        BookingRequestDate=user.getSelectedDateNew();
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(DetailsActivity.this);
        dialogUtil = new DialogUtil();

        CategoryId = getIntent().getStringExtra("CategoryId");
        CategoryName = getIntent().getStringExtra("CategoryName");
        CateringProductID=getIntent().getStringExtra("CateringProductID");
        VendorID = getIntent().getStringExtra("VendorID");
        HallID = getIntent().getStringExtra("HallId");
        HotelID=getIntent().getStringExtra("HotelID");
        ProductID=getIntent().getStringExtra("ProductID");
        RestProductID=getIntent().getStringExtra("RestProductID");

        title=getIntent().getStringExtra("title");

         item=getIntent().getParcelableExtra("item");





         titleTextView.setText(title);

        if(CategoryId!=null && CategoryId.equalsIgnoreCase("1"))
        {
            Binding();
        }else if(CategoryId!=null && CategoryId.equalsIgnoreCase("2"))
        {
            Binding();

        }else if(CategoryId.equalsIgnoreCase("3"))
        {
            Binding();

        }else if(CategoryId.equalsIgnoreCase("4"))
        {
           BindingCatering();
        }else if(CategoryId.equalsIgnoreCase("5"))
        {
            Binding();

        }else if(CategoryId.equalsIgnoreCase("6"))
        {
            BindingCloth();

        }else if(CategoryId.equalsIgnoreCase("7"))
        {
            BindingRestaurent();
        }else if(CategoryId.equalsIgnoreCase("8"))
        {
            BindingService();

        }else if(CategoryId.equalsIgnoreCase("9"))
        {
            BindingParking();
        }


    }



    public void BindingCloth()
    {
        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));
            appController.paServices.ECommerceProductDetails(VendorID,ProductID, new Callback<ECommerceProductDetailsDM>() {
                @Override
                public void success(ECommerceProductDetailsDM eCommerceProductDetailsDM, Response response) {
                    dialog.dismiss();
                    if (eCommerceProductDetailsDM.getStatus().equalsIgnoreCase("1")) {

                        EComProductID=eCommerceProductDetailsDM.getDetails().getProductID();



                        heading.setText(eCommerceProductDetailsDM.getDetails().getProductName());
                        priceTxt.setText(eCommerceProductDetailsDM.getDetails().getUnitPriceKWD());
                        refundPolicyTxt.setText(eCommerceProductDetailsDM.getDetails().getRefundPolicy());
                        outSideFoodPolicyTxt.setText(eCommerceProductDetailsDM.getDetails().getOutsideFoodPolicy());
                        if(eCommerceProductDetailsDM.getDetails().getDescription()!=null)
                        descriptionTxt.setText(Html.fromHtml(eCommerceProductDetailsDM.getDetails().getDescription(),Html.FROM_HTML_MODE_COMPACT));
                        termsAndConditionTxt.setText(eCommerceProductDetailsDM.getDetails().getTerms());



                        recycleViewLLWithText.setVisibility(View.GONE);
                        colorLL.setVisibility(View.VISIBLE);
                        measureLL.setVisibility(View.VISIBLE);
                        outSideFoodPolicyTxt.setVisibility(View.GONE);



                        GradientDrawable bgShape = (GradientDrawable)color_1.getBackground();
                        bgShape.setColor(Color.BLACK);

//                        GradientDrawable bgShape1 = (GradientDrawable)color_2.getBackground();
//                        bgShape1.setColor(Color.GREEN);
//                        bgShape1.setVisible(false,false);
//
//
//                        GradientDrawable bgShape2 = (GradientDrawable)color_3.getBackground();
//                        bgShape2.setColor(Color.RED);
//                        bgShape1.setVisible(false,false);
//
//                        GradientDrawable bgShap3 = (GradientDrawable)color_4.getBackground();
//                        bgShap3.setColor(Color.BLUE);
//                        bgShape1.setVisible(false,false);


              selectTVDropDown.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
//                      Intent intent = new Intent(DetailsActivity.this,BottomForAll.class);
//                      startActivity(intent);
                          bottomForAll= new BottomForAll();
                      bottomForAll.arrayList=eCommerceProductDetailsDM.getDetails().getCombinations();
                      bottomForAll.setResponseListener(new ResponseListener() {
                          @Override
                          public void response(Object object) {
                              EComCombinationID = ((Combinations)object).getCombinationID();

                          }
                      });
                      bottomForAll.show(getSupportFragmentManager(), "bottomSheetCountry");
                  }
              });





 //                  img.setImageResource(R.drawable.arabic_dress);
 //                  heading.setText("Arabic Dress");


        ArrayList<SliderItem> imgSli=new ArrayList<>();
                        if(eCommerceProductDetailsDM.getDetails().getImageList()!=null && !eCommerceProductDetailsDM.getDetails().getImageList().isEmpty())
                            for (ImageList il:eCommerceProductDetailsDM.getDetails().getImageList()
                            ) {
                                imgSli.add(new SliderItem(il.getImage()));
                            }
                        else
                            for (Images il:eCommerceProductDetailsDM.getDetails().getImages()
                            ) {
                                imgSli.add(new SliderItem(il.getImage()));
                            }



                              SliderAdapterExample adapter = new SliderAdapterExample(DetailsActivity.this,imgSli);
                               imageSlider.setSliderAdapter(adapter);
                               imageSlider.setIndicatorAnimation(IndicatorAnimationType.NONE); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                               imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                               imageSlider.setIndicatorSelectedColor(Color.BLACK);
                                imageSlider.setIndicatorUnselectedColor(Color.GRAY);
                              imageSlider.setScrollTimeInSec(10000); //set scroll delay in seconds :

                            } else
                           Helper.showToast(DetailsActivity.this, eCommerceProductDetailsDM.getMessage());
                        }

                        @Override
                         public void failure(RetrofitError retrofitError)
                        {
                          Log.e("error", retrofitError.toString()); }
                    });
                     } else
                     Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
                   }

    BottomForAll bottomForAll;

    public void Binding() {
        if (CategoryId.equalsIgnoreCase("1")) {
            if (connectionDetector.isConnectingToInternet()) {
                String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));
                appController.paServices.HallDetails(VendorID,HallID,BookingRequestDate, new Callback<HallDetailsDM>() {
                    @Override
                    public void success(HallDetailsDM hallDetailsDM, Response response) {
                        dialog.dismiss();
                        if (hallDetailsDM.getStatus().equalsIgnoreCase("1")) {



                            heading.setText(hallDetailsDM.getDetails().getHallName());
                            priceTxt.setText(hallDetailsDM.getDetails().getPrice());
                            outSideFoodPolicyTxt.setText(hallDetailsDM.getDetails().getOutsideFoodPolicy());
                            refundPolicyTxt.setText(hallDetailsDM.getDetails().getRefundPolicy());

                            descriptionTxt.setText(Html.fromHtml(hallDetailsDM.getDetails().getDescription(),Html.FROM_HTML_MODE_COMPACT));
                            termsAndConditionTxt.setText(hallDetailsDM.getDetails().getTerms());

                            recycleViewLLWithText.setVisibility(View.VISIBLE);
                            colorLL.setVisibility(View.GONE);
                            measureLL.setVisibility(View.GONE);

                            Adapter_Details_Amenities occasionAdapter = new Adapter_Details_Amenities(DetailsActivity.this,hallDetailsDM.getAmenityList(),false);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DetailsActivity.this, RecyclerView.VERTICAL, false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);

                            ArrayList<SliderItem> imgSli = new ArrayList<>();
                            if(hallDetailsDM.getDetails().getImageList()!=null && !hallDetailsDM.getDetails().getImageList().isEmpty())
                                    for (ImageList il:hallDetailsDM.getDetails().getImageList()
                                         ) {
                                        imgSli.add(new SliderItem(il.getImage()));
                                    }
                            else
                                for (Images il:hallDetailsDM.getDetails().getImages()
                                ) {
                                    imgSli.add(new SliderItem(il.getImage()));
                                }

                            SliderAdapterExample adapter = new SliderAdapterExample(DetailsActivity.this, imgSli);

                            imageSlider.setSliderAdapter(adapter);

                            imageSlider.setIndicatorAnimation(IndicatorAnimationType.NONE); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                            imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

                            imageSlider.setIndicatorSelectedColor(Color.BLACK);
                            imageSlider.setIndicatorUnselectedColor(Color.GRAY);
                            imageSlider.setScrollTimeInSec(9000); //set scroll delay in seconds :

                        } else
                            Helper.showToast(DetailsActivity.this, hallDetailsDM.getMessage());
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        Log.e("error", retrofitError.toString());

                    }
                });
            } else
                Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
        }else

        if (CategoryId.equalsIgnoreCase("2")) {
            if (connectionDetector.isConnectingToInternet()) {
                String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));
                appController.paServices.HotelDetails(VendorID,HotelID,BookingRequestDate, new Callback<HotelDetailsDM>() {
                    @Override
                    public void success(HotelDetailsDM hotelDetailsDM, Response response) {
                        dialog.dismiss();
                        if (hotelDetailsDM.getStatus().equalsIgnoreCase("1")) {



                            heading.setText(hotelDetailsDM.getDetails().getHotelName());
                            priceTxt.setText(hotelDetailsDM.getDetails().getPrice());
                            outSideFoodPolicyTxt.setText(hotelDetailsDM.getDetails().getOutsideFoodPolicy());
                            refundPolicyTxt.setText(hotelDetailsDM.getDetails().getRefundPolicy());
                            descriptionTxt.setText(Html.fromHtml(hotelDetailsDM.getDetails().getDescription(),Html.FROM_HTML_MODE_COMPACT));
                            termsAndConditionTxt.setText(hotelDetailsDM.getDetails().getTerms());

                            recycleViewLLWithText.setVisibility(View.VISIBLE);
                            colorLL.setVisibility(View.GONE);
                            measureLL.setVisibility(View.GONE);

                            Adapter_Details_Amenities occasionAdapter = new Adapter_Details_Amenities(DetailsActivity.this,hotelDetailsDM.getAmenityList(),false);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DetailsActivity.this, RecyclerView.VERTICAL, false);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(occasionAdapter);

                            ArrayList<SliderItem> imgSli = new ArrayList<>();
                            if(hotelDetailsDM.getDetails().getImageList()!=null && !hotelDetailsDM.getDetails().getImageList().isEmpty())
                                for (ImageList il:hotelDetailsDM.getDetails().getImageList()
                                ) {
                                    imgSli.add(new SliderItem(il.getImage()));
                                }
                            else
                                for (Images il:hotelDetailsDM.getDetails().getImages()
                                ) {
                                    imgSli.add(new SliderItem(il.getImage()));
                                }

                            SliderAdapterExample adapter = new SliderAdapterExample(DetailsActivity.this, imgSli);

                            imageSlider.setSliderAdapter(adapter);

                            imageSlider.setIndicatorAnimation(IndicatorAnimationType.NONE); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                            imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

                            imageSlider.setIndicatorSelectedColor(Color.BLACK);
                            imageSlider.setIndicatorUnselectedColor(Color.GRAY);
                            imageSlider.setScrollTimeInSec(9000); //set scroll delay in seconds :

                        } else
                            Helper.showToast(DetailsActivity.this, hotelDetailsDM.getMessage());
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        Log.e("error", retrofitError.toString());

                    }
                });
            } else
                Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
        }





    }

    public void BindingRestaurent()
    {

        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));
            appController.paServices.RestaurantDetails(VendorID,RestProductID,BookingRequestDate, new Callback<RestaurantDetailsDM>() {
                @Override
                public void success(RestaurantDetailsDM restaurantDetailsDM, Response response) {
                    dialog.dismiss();
                    if (restaurantDetailsDM.getStatus().equalsIgnoreCase("1")) {



                        heading.setText(restaurantDetailsDM.getDetails().getRestProductName());
                        priceTxt.setText(restaurantDetailsDM.getDetails().getUnitPriceKWD());
                        outSideFoodPolicyTxt.setText(restaurantDetailsDM.getDetails().getOutsideFoodPolicy());
                        refundPolicyTxt.setText(restaurantDetailsDM.getDetails().getRefundPolicy());
                        descriptionTxt.setText(Html.fromHtml(restaurantDetailsDM.getDetails().getDescription(),Html.FROM_HTML_MODE_COMPACT));
                        termsAndConditionTxt.setText(restaurantDetailsDM.getDetails().getTerms());



        img.setImageResource(R.drawable.restaurent_5);
        heading.setText("Chikken Tikka");
        recycleViewLLWithText.setVisibility(View.GONE);
        colorLL.setVisibility(View.GONE);
        measureLL.setVisibility(View.VISIBLE);
        measureImg.setVisibility(View.INVISIBLE);


//
//        ArrayList<SliderItem> imgSli=new ArrayList<>();
//        imgSli.add(new SliderItem(R.drawable.restaurent_5,""));
//        imgSli.add(new SliderItem(R.drawable.restaurent_5,""));
//        imgSli.add(new SliderItem(R.drawable.restaurent_5,""));


                        ArrayList<SliderItem> imgSli = new ArrayList<>();
                        if(restaurantDetailsDM.getDetails().getImageList()!=null && !restaurantDetailsDM.getDetails().getImageList().isEmpty())
                            for (ImageList il:restaurantDetailsDM.getDetails().getImageList()
                            ) {
                                imgSli.add(new SliderItem(il.getImage()));
                            }
                        else
                            for (Images il:restaurantDetailsDM.getDetails().getImages()
                            ) {
                                imgSli.add(new SliderItem(il.getImage()));
                            }


                        selectTVDropDown.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                      Intent intent = new Intent(DetailsActivity.this,BottomForAll.class);
//                      startActivity(intent);
                                bottomForAll= new BottomForAll();
                                bottomForAll.arrayList=restaurantDetailsDM.getDetails().getCombinations();
                                bottomForAll.setResponseListener(new ResponseListener() {
                                    @Override
                                    public void response(Object object) {
                                            RestCombinationID = ((Combinations)object).getRestCombinationID();
                                    }
                                });
                                bottomForAll.show(getSupportFragmentManager(), "bottomSheetCountry");
                            }
                        });


        SliderAdapterExample adapter = new SliderAdapterExample(DetailsActivity.this,imgSli);

        imageSlider.setSliderAdapter(adapter);

        imageSlider.setIndicatorAnimation(IndicatorAnimationType.NONE); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        imageSlider.setIndicatorSelectedColor(Color.BLACK);
        imageSlider.setIndicatorUnselectedColor(Color.GRAY);
         //set scroll delay in seconds :




                    } else
                        Helper.showToast(DetailsActivity.this, restaurantDetailsDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.e("error", retrofitError.toString());

                }
            });
        } else
            Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
    }





    public void BindingCatering()
    {
        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));
            appController.paServices.CateringDetails(VendorID,CateringProductID,BookingRequestDate, new Callback<CateringDetailsDM>() {
                @Override
                public void success(CateringDetailsDM cateringDetailsDM, Response response) {
                    dialog.dismiss();
                    if (cateringDetailsDM.getStatus().equalsIgnoreCase("1")) {



                        heading.setText(cateringDetailsDM.getDetails().getCateringProductName());
                        priceTxt.setText(cateringDetailsDM.getDetails().getPriceKWD());
                        outSideFoodPolicyTxt.setText(cateringDetailsDM.getDetails().getOutsideFoodPolicy());
                        refundPolicyTxt.setText(cateringDetailsDM.getDetails().getRefundPolicy());
                        descriptionTxt.setText(Html.fromHtml(cateringDetailsDM.getDetails().getDescription(),Html.FROM_HTML_MODE_COMPACT));
                        termsAndConditionTxt.setText(cateringDetailsDM.getDetails().getTerms());




        img.setImageResource(R.drawable.catering_9);
        heading.setText("Melenzane Casa Buffet");
        recycleViewLLWithText.setVisibility(View.VISIBLE);
        colorLL.setVisibility(View.GONE);
        measureLL.setVisibility(View.GONE);
        descriptionRecycleLL.setVisibility(View.VISIBLE);



        Adapter_Description occasionAdapter=new Adapter_Description(DetailsActivity.this, cateringDetailsDM.getDescription(),false);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(DetailsActivity.this,RecyclerView.VERTICAL,false);
        descriptionRV.setLayoutManager(linearLayoutManager);
        descriptionRV.setAdapter(occasionAdapter);



//        recycleText.setText("Starter");



        Adapter_Description_2 adapter_description_2=new Adapter_Description_2(DetailsActivity.this, cateringDetailsDM.getCateringDishes(),false);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(DetailsActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager1);
        recyclerView.setAdapter(adapter_description_2);


//
//        ArrayList<SliderItem> imgSli=new ArrayList<>();
//        imgSli.add(new SliderItem(R.drawable.catering_9,""));
//        imgSli.add(new SliderItem(R.drawable.catering_9,""));
//        imgSli.add(new SliderItem(R.drawable.catering_9,""));



                        ArrayList<SliderItem> imgSli = new ArrayList<>();
                        if(cateringDetailsDM.getDetails().getImageList()!=null && !cateringDetailsDM.getDetails().getImageList().isEmpty())
                            for (ImageList il:cateringDetailsDM.getDetails().getImageList()
                            ) {
                                imgSli.add(new SliderItem(il.getImage()));
                            }
                        else
                            for (Images il:cateringDetailsDM.getDetails().getImages()
                            ) {
                                imgSli.add(new SliderItem(il.getImage()));
                            }


        SliderAdapterExample adapter = new SliderAdapterExample(DetailsActivity.this,imgSli);

        imageSlider.setSliderAdapter(adapter);

        imageSlider.setIndicatorAnimation(IndicatorAnimationType.NONE); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        imageSlider.setIndicatorSelectedColor(Color.BLACK);
        imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        imageSlider.setScrollTimeInSec(9000); //set scroll delay in seconds :


                    } else
                        Helper.showToast(DetailsActivity.this, cateringDetailsDM.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.e("error", retrofitError.toString());

                }
            });
        } else
            Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));

    }




    public void BindingService()
   {

                        heading.setText(CategoryName);
                        priceTxt.setText(item.getPriceKWD());
                        outSideFoodPolicyTxt.setText(item.getOutsideFoodPolicy());
                        refundPolicyTxt.setText(item.getRefundPolicy());
                        descriptionTxt.setText(Html.fromHtml(item.getDescription(),Html.FROM_HTML_MODE_COMPACT));
                        termsAndConditionTxt.setText(item.getTerms());



                         img.setImageResource(R.drawable.serving_4);
                         heading.setText("Cook");
                         recycleViewLLWithText.setVisibility(View.GONE);
                         colorLL.setVisibility(View.GONE);
                         measureLL.setVisibility(View.GONE);
                         descriptionRecycleLL.setVisibility(View.GONE);







       ArrayList<SliderItem> imgSli = new ArrayList<>();
       if(item.getImageList()!=null && !item.getImageList().isEmpty())
           for (ImageList il:item.getImageList())
           {
               imgSli.add(new SliderItem(il.getImage()));
           }



       SliderAdapterExample adapter = new SliderAdapterExample(this,imgSli);

        imageSlider.setSliderAdapter(adapter);

        imageSlider.setIndicatorAnimation(IndicatorAnimationType.NONE); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        imageSlider.setIndicatorSelectedColor(Color.BLACK);
        imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        imageSlider.setScrollTimeInSec(9000); //set scroll delay in seconds :


    }





    public void BindingParking()
    {

        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));
            appController.paServices.ParkingDetails(VendorID, new Callback<ParkingDetailsDM>() {
                @Override
                public void success(ParkingDetailsDM parkingDetailsDM, Response response) {
                    dialog.dismiss();
                    if (parkingDetailsDM.getStatus().equalsIgnoreCase("1")) {

                        ParkingID = parkingDetailsDM.getItem().getParkingID();

                        heading.setText(parkingDetailsDM.getItem().getVendorName());
                        priceTxt.setText(parkingDetailsDM.getItem().getPriceKWD());
                        outSideFoodPolicyTxt.setText(parkingDetailsDM.getItem().getOutsideFoodPolicy());
                        refundPolicyTxt.setText(parkingDetailsDM.getItem().getRefundPolicy());
                        descriptionTxt.setText(Html.fromHtml(parkingDetailsDM.getItem().getDescription(),Html.FROM_HTML_MODE_COMPACT));
                        termsAndConditionTxt.setText(parkingDetailsDM.getItem().getTerms());






                         img.setImageResource(R.drawable.parking_4);
                          heading.setText("Smart Parking Limited");
                          recycleViewLLWithText.setVisibility(View.GONE);
                            colorLL.setVisibility(View.GONE);
                             measureLL.setVisibility(View.GONE);
                            descriptionRecycleLL.setVisibility(View.GONE);



//        ArrayList<SliderItem> imgSli=new ArrayList<>();
//        imgSli.add(new SliderItem(R.drawable.parking_4,""));
//        imgSli.add(new SliderItem(R.drawable.parking_4,""));
//        imgSli.add(new SliderItem(R.drawable.parking_4,""));



                        ArrayList<SliderItem> imgSli = new ArrayList<>();
                        if(parkingDetailsDM.getItem().getImageList()!=null && !parkingDetailsDM.getItem().getImageList().isEmpty())
                            for (ImageList il:parkingDetailsDM.getItem().getImageList()
                            ) {
                                imgSli.add(new SliderItem(il.getImage()));
                            }


        SliderAdapterExample adapter = new SliderAdapterExample(DetailsActivity.this,imgSli);

        imageSlider.setSliderAdapter(adapter);

        imageSlider.setIndicatorAnimation(IndicatorAnimationType.NONE); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        imageSlider.setIndicatorSelectedColor(Color.BLACK);
        imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        imageSlider.setScrollTimeInSec(9000); //set scroll delay in seconds :



                     } else
                   Helper.showToast(DetailsActivity.this, parkingDetailsDM.getMessage());

           }

                @Override
               public void failure(RetrofitError retrofitError) {
                   Log.e("error", retrofitError.toString());

               }
                });
                  } else
               Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
    }
public String AmenityIDList="";


    public void HallAddToCart()
              {
                  if (connectionDetector.isConnectingToInternet()) {
                      String refreshedToken = FirebaseInstanceId.getInstance().getToken();

                      if (AmenityIDList.equalsIgnoreCase("")) {
                          Helper.showToast(DetailsActivity.this, "Kindly select Amenity..");
                      } else {
                          dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));
                          appController.paServices.HallAddToCart(String.valueOf(user.getId()), refreshedToken, BookingRequestDate, HallID, String.valueOf(quantity), AmenityIDList, VendorID, new Callback<HallAddToCartDM>() {
                              @Override
                              public void success(HallAddToCartDM hallAddToCartDM, Response response) {
                                  dialog.dismiss();
                                  if (hallAddToCartDM.getStatus().equalsIgnoreCase("1")) {
                                      startActivity(new Intent(DetailsActivity.this,AddToCart.class));
                                      Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());

                                  } else
                                      Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());
                              }

                              @Override
                              public void failure(RetrofitError retrofitError) {
                                  Log.e("error", retrofitError.toString());
                              }
                          });
                      }
                  }
                         else
                                    Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
              }




    public void HotalAddToCart()
    {
        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();


            if (AmenityIDList.equalsIgnoreCase("")) {
                Helper.showToast(DetailsActivity.this, "Kindly select Amenity..");
            } else {
                dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));
                appController.paServices.HotelAddToCart(String.valueOf(user.getId()), refreshedToken, BookingRequestDate, HotelID, String.valueOf(quantity), AmenityIDList , VendorID, new Callback<HallAddToCartDM>() {
                    @Override
                    public void success(HallAddToCartDM hallAddToCartDM, Response response) {
                        dialog.dismiss();
                        if (hallAddToCartDM.getStatus().equalsIgnoreCase("1")) {

                            Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());

                        } else
                            Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        Log.e("error", retrofitError.toString());
                    }
                });
            }
        }
        else
            Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
    }




   public void  ServicingServiceAddToCart()
    {

        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));



                appController.paServices.ServingServicesAddToCart(String.valueOf(user.getId()), refreshedToken, BookingRequestDate, item.getServingID(), String.valueOf(quantity), VendorID, new Callback<HallAddToCartDM>() {
                    @Override
                    public void success(HallAddToCartDM hallAddToCartDM, Response response) {
                        dialog.dismiss();
                        if (hallAddToCartDM.getStatus().equalsIgnoreCase("1")) {

                            Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());

                        } else
                            Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());
                       }

                    @Override
                      public void failure(RetrofitError retrofitError) {
                        dialog.dismiss();
                        Log.e("error", retrofitError.toString());
                    }
                });

        }
        else
            Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
    }





    public void  ParkingAddToCart() {

        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));


             appController.paServices.ParkingAddToCart(String.valueOf(user.getId()), refreshedToken, BookingRequestDate, ParkingID, String.valueOf(quantity), VendorID, new Callback<HallAddToCartDM>() {
                    @Override
                    public void success(HallAddToCartDM hallAddToCartDM, Response response) {
                        dialog.dismiss();
                        if (hallAddToCartDM.getStatus().equalsIgnoreCase("1")) {
                            Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());

                        } else
                            Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        dialog.dismiss();
                        Log.e("error", retrofitError.toString());
                    }
                });

        } else
            Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
    }







    public void RestaurentAddToCart()
    {
        if (connectionDetector.isConnectingToInternet()) {
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));


            appController.paServices.RestaurantAddToCart(String.valueOf(user.getId()), refreshedToken, BookingRequestDate, RestProductID, String.valueOf(quantity), RestCombinationID , VendorID, new Callback<HallAddToCartDM>() {
                    @Override
                    public void success(HallAddToCartDM hallAddToCartDM, Response response) {
                        dialog.dismiss();
                        if (hallAddToCartDM.getStatus().equalsIgnoreCase("1")) {
                            Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());

                        } else
                            Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        dialog.dismiss();

                        Log.e("error", retrofitError.toString());
                    }
                });

        }
        else
            Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
    }





    public void   EcommerceAddToCart()
            {
                if (connectionDetector.isConnectingToInternet()) {
                        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                        dialog = dialogUtil.showProgressDialog(DetailsActivity.this, getString(R.string.please_wait));


                        appController.paServices.ECommerceAddToCart(String.valueOf(user.getId()), refreshedToken, EComProductID, EComCombinationID, String.valueOf(quantity), VendorID, new Callback<HallAddToCartDM>() {
                            @Override
                            public void success(HallAddToCartDM hallAddToCartDM, Response response) {
                                dialog.dismiss();
                                if (hallAddToCartDM.getStatus().equalsIgnoreCase("1")) {

                                    Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());
                                } else
                                    Helper.showToast(DetailsActivity.this, hallAddToCartDM.getMessage());
                            }

                            @Override
                            public void failure(RetrofitError retrofitError) {
                                dialog.dismiss();

                                Log.e("error", retrofitError.toString());
                            }
                        });
                        }
                    else
                        Helper.showToast(DetailsActivity.this, getString(R.string.no_internet_connection));
                }





    @Override
    public void response(Object object) {

    }
}
