package com.master.design.gala.Services;


//import io.opencensus.stats.Stats;

import com.master.design.gala.DataModel.CategoryListDM;
import com.master.design.gala.DataModel.CateringDetailsDM;
import com.master.design.gala.DataModel.CateringListDM;
import com.master.design.gala.DataModel.CheckoutDM;
import com.master.design.gala.DataModel.CustomerAddressAddDM;
import com.master.design.gala.DataModel.CustomerAddressListDM;
import com.master.design.gala.DataModel.CustomerAddressRemoveDM;
import com.master.design.gala.DataModel.CustomerAddressUpdateDM;
import com.master.design.gala.DataModel.CustomerAreaCityListDM;
import com.master.design.gala.DataModel.CustomerDetailsDM;
import com.master.design.gala.DataModel.CustomerGovStateListDM;
import com.master.design.gala.DataModel.CustomerRegisterDM;
import com.master.design.gala.DataModel.CustomerResendOtpDM;
import com.master.design.gala.DataModel.CustomerUpdateProfileDM;
import com.master.design.gala.DataModel.DataPrivacyPolicyDM;
import com.master.design.gala.DataModel.ECommerceCategoryListDM;
import com.master.design.gala.DataModel.ECommerceCategoryProductListDM;
import com.master.design.gala.DataModel.ECommerceListDM;
import com.master.design.gala.DataModel.ECommerceProductDetailsDM;
import com.master.design.gala.DataModel.HallAddToCartDM;
import com.master.design.gala.DataModel.HallCartListDM;
import com.master.design.gala.DataModel.HallDeleteCartDM;
import com.master.design.gala.DataModel.HallDetailsDM;
import com.master.design.gala.DataModel.HallListDM;
import com.master.design.gala.DataModel.HotelCartListDM;
import com.master.design.gala.DataModel.HotelDetailsDM;
import com.master.design.gala.DataModel.HotelListDM;
import com.master.design.gala.DataModel.OccasionListDM;
import com.master.design.gala.DataModel.OccasionSlidesDM;
import com.master.design.gala.DataModel.ParkingCartListDM;
import com.master.design.gala.DataModel.ParkingDetailsDM;
import com.master.design.gala.DataModel.RestaurantCartListDM;
import com.master.design.gala.DataModel.RestaurantDetailsDM;
import com.master.design.gala.DataModel.RestaurantListDM;
import com.master.design.gala.DataModel.ServingServicesCartListDM;
import com.master.design.gala.DataModel.ServingServicesListDM;
import com.master.design.gala.DataModel.VendorListDM;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface PAServices {

    // 1
    @FormUrlEncoded
    @POST("/api/Customer/Register")
    public void CustomerRegister(@Field("CustomerName") String CustomerName,
                                 @Field("EmailID") String EmailID,
                                 @Field("CallingCode") String CallingCode,
                                 @Field("Phone") String Phone,
                                 @Field("Password") String Password,
                                 @Field("ConfirmPassword") String ConfirmPassword,
                                 @Field("AppType") String AppType,
                                 @Field("DeviceTokenID") String DeviceTokenID,

                                 Callback<CustomerRegisterDM> customerRegisterDMCallback);

    //2
    @FormUrlEncoded
    @POST("/api/Customer/Verify")
    public void CustomerVerify(@Field("CustomerID") String CustomerID,
                               @Field("VerifyPin") String VerifyPin,
                        Callback<CustomerRegisterDM> customerVerifyDMCallback);

    //3
    @FormUrlEncoded
    @POST("/api/Customer/ResendOtp")
    public void CustomerResendOtp(@Field("CustomerID") String CustomerID,
                                  Callback<CustomerResendOtpDM> customerResendOtpDMCallback);

    //4
    @FormUrlEncoded
    @POST("/api/Customer/Login")
    public void CustomerLogin(@Field("EmailID") String EmailID,
                              @Field("Password") String Password,
                              @Field("AppType") String AppType,
                              @Field("DeviceTokenID") String DeviceTokenID,
                            Callback<CustomerRegisterDM> customerVerifyDMCallback);

    //5
    @FormUrlEncoded
    @POST("/api/Customer/ForgotPassword")
    public void CustomerForgetPassword(@Field("EmailID") String EmailID,
                                       Callback<CustomerResendOtpDM> customerVerifyDMCallback);

    //6
    @FormUrlEncoded
    @POST("/api/Customer/ChangePassword")
    public void CustomerChangePassword(@Field("CustomerID") String CustomerID,
                                       @Field("CurrentPassword") String CurrentPassword,
                                       @Field("NewPassword") String NewPassword,
                                       @Field("ConfirmPassword") String ConfirmPassword,
                                       Callback<CustomerResendOtpDM> customerRegisterDMCallback);

    //7
    @FormUrlEncoded
    @POST("/api/Customer/Details")
    public void CustomerDetails(@Field("CustomerID") String CustomerID,
                                Callback<CustomerDetailsDM> customerRegisterDMCallback);

    //8
    @FormUrlEncoded
    @POST("/api/Customer/UpdateProfile")
    public void CustomerUpdateProfile(@Field("CustomerID") String CustomerID,
                                      @Field("CustomerName") String CustomerName,
                                      Callback<CustomerUpdateProfileDM> customerRegisterDMCallback);

    //9
    @POST("/api/Data/PrivacyPolicy")
    public void DataPrivacyPolicy(Callback<DataPrivacyPolicyDM> customerRegisterDMCallback);

    //10
    @POST("/api/Data/Terms")
    public void DataTerm(Callback<DataPrivacyPolicyDM> customerRegisterDMCallback);

    //11
    @POST("/api/Category/List")
    public void CategoryList(Callback<CategoryListDM> customerRegisterDMCallback);

    //12
    @POST("/api/Occasion/Slides")
    public void OccasionSlides(Callback<OccasionSlidesDM> customerRegisterDMCallback);

    //13
    @POST("/api/Occasion/List")
    public void OccasionList(Callback<OccasionListDM> customerRegisterDMCallback);

    //14
    @FormUrlEncoded
    @POST("/api/Vendor/List")
    public void VendorList(@Field("CategoryID") String CategoryID,
                           Callback<VendorListDM> customerRegisterDMCallback);

    //15
    @POST("/api/Customer/GovStateList")
    public void CustomerGovStateList(Callback<CustomerGovStateListDM> customerRegisterDMCallback);

    //16
    @FormUrlEncoded
    @POST("/api/Customer/AreaCityList")
    public void CustomerAreaStateList(@Field("GovStateID") String GovStateID,
                                      Callback<CustomerAreaCityListDM> customerRegisterDMCallback);

    //17
    @FormUrlEncoded
    @POST("/api/Customer/AddressList")
    public void CustomerAddressList(@Field("CustomerID") String CustomerID,
                                    Callback<CustomerAddressListDM> customerRegisterDMCallback);

   // 18
   @FormUrlEncoded
    @POST("/api/Customer/AddressAdd")
    public void CustomerAddressAdd(@Field("CustomerID") String CustomerID,
                                   @Field("GovStateID") String GovStateID,
                                   @Field("AreaCityID") String AreaCityID,
                                   @Field("AddressType") String AddressType,
                                   @Field("Block") String Block,
                                   @Field("Building") String Building,
                                   @Field("Street") String Street,
                                   @Field("Floor") String Floor,
                                   @Field("FlatNo") String FlatNo,
                                   @Field("HouseNo") String HouseNo,
                                   @Field("Latitude") String Latitude,
                                   @Field("Longitude") String Longitude,
                                   Callback<CustomerAddressAddDM> customerRegisterDMCallback);

    //19
    @FormUrlEncoded
    @POST("/api/Customer/AddressUpdate")
    public void CustomerAddressUpdate(@Field("CustomerAddressID") String CustomerAddressID,
                                      @Field("CustomerID") String CustomerID,
                                      @Field("GovStateID") String GovStateID,
                                      @Field("AreaCityID") String AreaCityID,
                                      @Field("AddressType") String AddressType,
                                      @Field("Block") String Block,
                                      @Field("Building") String Building,
                                      @Field("Street") String Street,
                                      @Field("Floor") String Floor,
                                      @Field("FlatNo") String FlatNo,
                                      @Field("HouseNo") String HouseNo,
                                      @Field("Latitude") String Latitude,
                                      @Field("Longitude") String Longitude,
                           Callback<CustomerAddressUpdateDM> customerRegisterDMCallback);

    //20
    @FormUrlEncoded
    @POST("/api/Customer/AddressRemove")
    public void CustomerAddressRemove(@Field("CustomerAddressID") String CustomerAddressID,
                                      @Field("CustomerID") String CustomerID,
                             Callback<CustomerAddressRemoveDM> customerRegisterDMCallback);

     //21
    @POST("/api/ECommerce/List")
    public void ECommerceList(Callback<ECommerceListDM> customerRegisterDMCallback);

    //22
    @FormUrlEncoded
    @POST("/api/ECommerce/CategoryList")
    public void ECommerceCategoryList(@Field("VendorID") String VendorID,
                                      Callback<ECommerceCategoryListDM> customerRegisterDMCallback);

    //23
    @FormUrlEncoded
    @POST("/api/ECommerce/CategoryProductList")
    public void ECommerceCategoryProductList(@Field("VendorID") String VendorID,
                                      Callback<ECommerceCategoryProductListDM> customerRegisterDMCallback);

    //24
    @FormUrlEncoded
    @POST("/api/ECommerce/ProductDetails")
    public void ECommerceProductDetails(@Field("VendorID") String VendorID,
                                             @Field("ProductID") String ProductID,
                                             Callback<ECommerceProductDetailsDM> customerRegisterDMCallback);

    //25
    @FormUrlEncoded
    @POST("/api/Hall/List")
    public void HallList(@Field("VendorID") String VendorID,
                                             Callback<HallListDM> customerRegisterDMCallback);


    //26
    @FormUrlEncoded
    @POST("/api/Hall/Details")
    public void HallDetails(@Field("VendorID") String VendorID,
                            @Field("HallID") String HallID,
                            @Field("BookingRequestDate") String BookingRequestDate,
                         Callback<HallDetailsDM> customerRegisterDMCallback);



    //27
    @FormUrlEncoded
    @POST("/api/Hall/AddToCart")
    public void HallAddToCart(@Field("CustomerID") String CustomerID,
                             @Field("DeviceTokenID") String DeviceTokenID,
                             @Field("BookingRequestDate") String BookingRequestDate,
                             @Field("HallID") String HallID,
                             @Field("NumberOfPeople") String NumberOfPeople,
                             @Field("AmenityIDList") String AmenityIDList,
                             @Field("VendorID") String VendorID,
                             Callback<HallAddToCartDM> hallAddToCartDMCallback);


    //28
    @FormUrlEncoded
    @POST("/api/Hall/DeleteCart")
    public void HallDeleteCart(@Field("HallCartID") String HallCartID,
                               Callback<HallDeleteCartDM> customerRegisterDMCallback);

    //29
    @FormUrlEncoded
    @POST("/api/Hall/UpdateCartQuantity")
    public void HallUpdateCartQuantity(@Field("HallCartID") String HallCartID,
                                       @Field("NumberOfPeople") String NumberOfPeople,
                                    Callback<HallAddToCartDM> customerRegisterDMCallback);



    //30
    @FormUrlEncoded
    @POST("/api/Hotel/List")
    public void HotelList(@Field("VendorID") String VendorID,
                         Callback<HotelListDM> customerRegisterDMCallback);


    //31
    @FormUrlEncoded
    @POST("/api/Hotel/Details")
    public void HotelDetails(@Field("VendorID") String VendorID,
                            @Field("HotelID") String HallID,
                            @Field("BookingRequestDate") String BookingRequestDate,
                            Callback<HotelDetailsDM> customerRegisterDMCallback);

    //32
    @FormUrlEncoded
    @POST("/api/Restaurant/List")
    public void RestaurantList(@Field("VendorID") String VendorID,
                          Callback<RestaurantListDM> customerRegisterDMCallback);


    //33
    @FormUrlEncoded
    @POST("/api/Restaurant/Details")
    public void RestaurantDetails(@Field("VendorID") String VendorID,
                             @Field("RestProductID") String RestProductID,
                             @Field("BookingRequestDate") String BookingRequestDate,
                             Callback<RestaurantDetailsDM> customerRegisterDMCallback);



    //34
    @FormUrlEncoded
    @POST("/api/ServingServices/List")
    public void ServingServicesList(@Field("VendorID") String VendorID,
                               Callback<ServingServicesListDM> customerRegisterDMCallback);

    //35
    @FormUrlEncoded
    @POST("/api/Parking/Details")
    public void ParkingDetails(@Field("VendorID") String VendorID,
                                    Callback<ParkingDetailsDM> customerRegisterDMCallback);




    //36
    @FormUrlEncoded
    @POST("/api/Catering/List")
    public void CateringList(@Field("VendorID") String VendorID,
                               Callback<CateringListDM> customerRegisterDMCallback);


    //37
    @FormUrlEncoded
    @POST("/api/Catering/Details")
    public void CateringDetails(@Field("VendorID") String VendorID,
                                  @Field("CateringProductID") String CateringProductID,
                                  @Field("BookingRequestDate") String BookingRequestDate,
                                  Callback<CateringDetailsDM> customerRegisterDMCallback);





    //38
    @FormUrlEncoded
    @POST("/api/Hotel/AddToCart")
    public void HotelAddToCart(@Field("CustomerID") String CustomerID,
                               @Field("DeviceTokenID") String DeviceTokenID,
                               @Field("BookingRequestDate") String BookingRequestDate,
                               @Field("HotelID") String HallID,
                               @Field("NumberOfPeople") String NumberOfPeople,
                               @Field("AmenityIDList") String AmenityIDList,
                               @Field("VendorID") String VendorID,
                               Callback<HallAddToCartDM> hallAddToCartDMCallback);


    //39
    @FormUrlEncoded
    @POST("/api/Restaurant/AddToCart")
    public void RestaurantAddToCart(@Field("CustomerID") String CustomerID,
                               @Field("DeviceTokenID") String DeviceTokenID,
                               @Field("BookingRequestDate") String BookingRequestDate,
                               @Field("RestProductID") String RestProductID,
                               @Field("RestCombinationID") String RestCombinationID,
                               @Field("Quantity") String Quantity,
                               @Field("VendorID") String VendorID,
                               Callback<HallAddToCartDM> hallAddToCartDMCallback);



    //40
    @FormUrlEncoded
    @POST("/api/ServingServices/AddToCart")
    public void ServingServicesAddToCart(@Field("CustomerID") String CustomerID,
                               @Field("DeviceTokenID") String DeviceTokenID,
                               @Field("BookingRequestDate") String BookingRequestDate,
                               @Field("ServingID") String ServingID,
                               @Field("NumberOfPeople") String NumberOfPeople,
                               @Field("VendorID") String VendorID,
                               Callback<HallAddToCartDM> hallAddToCartDMCallback);



    //41
    @FormUrlEncoded
    @POST("/api/Parking/AddToCart")
    public void ParkingAddToCart(@Field("CustomerID") String CustomerID,
                                         @Field("DeviceTokenID") String DeviceTokenID,
                                         @Field("BookingRequestDate") String BookingRequestDate,
                                         @Field("ParkingID") String ServingID,
                                         @Field("NumberOfPeople") String NumberOfPeople,
                                         @Field("VendorID") String VendorID,
                                         Callback<HallAddToCartDM> hallAddToCartDMCallback);

    //42
    @FormUrlEncoded
    @POST("/api/ECommerce/AddToCart")
    public void ECommerceAddToCart(@Field("CustomerID") String CustomerID,
                                  @Field("DeviceTokenID") String DeviceTokenID,
                                  @Field("EComProductID") String EComProductID,
                                  @Field("EComCombinationID") String EComCombinationID,
                                  @Field("Quantity") String Quantity,
                                  @Field("VendorID") String VendorID,
                                  Callback<HallAddToCartDM> hallAddToCartDMCallback);


    //43
    @FormUrlEncoded
    @POST("/api/Parking/CartList")
    public void ParkingCartList(@Field("CustomerID") String CustomerID,
                                @Field("DeviceTokenID") String DeviceTokenID,
                                @Field("Coupon") String Coupon,
                             Callback<ParkingCartListDM> customerRegisterDMCallback);


    //44
    @FormUrlEncoded
    @POST("/api/ServingServices/CartList")
    public void ServingServicesCartList(@Field("CustomerID") String CustomerID,
                                        @Field("DeviceTokenID") String DeviceTokenID,
                                        @Field("Coupon") String Coupon,
                                Callback<ServingServicesCartListDM> customerRegisterDMCallback);


    //45
    @FormUrlEncoded
    @POST("/api/Restaurant/CartList")
    public void RestaurantCartList(@Field("CustomerID") String CustomerID,
                                        @Field("DeviceTokenID") String DeviceTokenID,
                                        @Field("Coupon") String Coupon,
                                        Callback<RestaurantCartListDM> customerRegisterDMCallback);


    //46
    @FormUrlEncoded
    @POST("/api/Hotel/CartList")
    public void HotelCartList(@Field("CustomerID") String CustomerID,
                                   @Field("DeviceTokenID") String DeviceTokenID,
                                   @Field("Coupon") String Coupon,
                                   Callback<HotelCartListDM> customerRegisterDMCallback);




    //47
    @FormUrlEncoded
    @POST("/api/Hall/CartList")
    public void HallCartList(@Field("CustomerID") String CustomerID,
                              @Field("DeviceTokenID") String DeviceTokenID,
                             Callback<HallCartListDM> hallCartListDMCallback);

    //48
    @FormUrlEncoded
    @POST("/api/Hall/Checkout")
    public void HallCheckout(@Field("CustomerID") String CustomerID,
                             @Field("CustomerAddressID") String CustomerAddressID,
                             @Field("PaymentMode") String PaymentMode,
                             @Field("SubTotalAmount") String SubTotalAmount,
                             @Field("TotalAmount") String TotalAmount,
                             @Field("ApplicationType") String ApplicationType,
                             Callback<CheckoutDM> checkoutDMCallback);



}
