package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class HallCartListDM {


    private String Status;
    private String Total_Main;
    private String TotalKWD_Main;
    private String Message;
    private String SubTotalKWD_Main;
    private String TotalKWDAr_Main;
    private String SubTotal_Main;
    private String SubTotalKWDAr_Main;
    private String CouponDiscountKWD;
    private String CouponDiscountKWDAr;
    private String CouponDiscount;
    private ArrayList<CartList> CartList ;


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTotal_Main() {
        return Total_Main;
    }

    public void setTotal_Main(String total_Main) {
        Total_Main = total_Main;
    }

    public String getTotalKWD_Main() {
        return TotalKWD_Main;
    }

    public void setTotalKWD_Main(String totalKWD_Main) {
        TotalKWD_Main = totalKWD_Main;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSubTotalKWD_Main() {
        return SubTotalKWD_Main;
    }

    public void setSubTotalKWD_Main(String subTotalKWD_Main) {
        SubTotalKWD_Main = subTotalKWD_Main;
    }

    public String getTotalKWDAr_Main() {
        return TotalKWDAr_Main;
    }

    public void setTotalKWDAr_Main(String totalKWDAr_Main) {
        TotalKWDAr_Main = totalKWDAr_Main;
    }

    public String getSubTotal_Main() {
        return SubTotal_Main;
    }

    public void setSubTotal_Main(String subTotal_Main) {
        SubTotal_Main = subTotal_Main;
    }

    public String getSubTotalKWDAr_Main() {
        return SubTotalKWDAr_Main;
    }

    public void setSubTotalKWDAr_Main(String subTotalKWDAr_Main) {
        SubTotalKWDAr_Main = subTotalKWDAr_Main;
    }

    public String getCouponDiscountKWD() {
        return CouponDiscountKWD;
    }

    public void setCouponDiscountKWD(String couponDiscountKWD) {
        CouponDiscountKWD = couponDiscountKWD;
    }

    public String getCouponDiscountKWDAr() {
        return CouponDiscountKWDAr;
    }

    public void setCouponDiscountKWDAr(String couponDiscountKWDAr) {
        CouponDiscountKWDAr = couponDiscountKWDAr;
    }

    public String getCouponDiscount() {
        return CouponDiscount;
    }

    public void setCouponDiscount(String couponDiscount) {
        CouponDiscount = couponDiscount;
    }

    public ArrayList<com.master.design.gala.DataModel.CartList> getCartList() {
        return CartList;
    }

    public void setCartList(ArrayList<com.master.design.gala.DataModel.CartList> cartList) {
        CartList = cartList;
    }
}
