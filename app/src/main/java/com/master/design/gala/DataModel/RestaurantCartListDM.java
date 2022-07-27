package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class RestaurantCartListDM {

    private String Status;

    private String Total_Main;

    private String TotalKWD_Main;

    private String Message;

    private ArrayList<CartList> CartList;

    private String SubTotalKWD_Main;

    private String TotalKWDAr_Main;

    private String SubTotal_Main;

    private String SubTotalKWDAr_Main;

    private String CouponDiscountKWD;

    private String CouponDiscountKWDAr;

    private String CouponDiscount;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getTotal_Main ()
    {
        return Total_Main;
    }

    public void setTotal_Main (String Total_Main)
    {
        this.Total_Main = Total_Main;
    }

    public String getTotalKWD_Main ()
    {
        return TotalKWD_Main;
    }

    public void setTotalKWD_Main (String TotalKWD_Main)
    {
        this.TotalKWD_Main = TotalKWD_Main;
    }

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public ArrayList<CartList> getCartList ()
    {
        return CartList;
    }

    public void setCartList (ArrayList<CartList> CartList)
    {
        this.CartList = CartList;
    }

    public String getSubTotalKWD_Main ()
    {
        return SubTotalKWD_Main;
    }

    public void setSubTotalKWD_Main (String SubTotalKWD_Main)
    {
        this.SubTotalKWD_Main = SubTotalKWD_Main;
    }

    public String getTotalKWDAr_Main ()
    {
        return TotalKWDAr_Main;
    }

    public void setTotalKWDAr_Main (String TotalKWDAr_Main)
    {
        this.TotalKWDAr_Main = TotalKWDAr_Main;
    }

    public String getSubTotal_Main ()
    {
        return SubTotal_Main;
    }

    public void setSubTotal_Main (String SubTotal_Main)
    {
        this.SubTotal_Main = SubTotal_Main;
    }

    public String getSubTotalKWDAr_Main ()
    {
        return SubTotalKWDAr_Main;
    }

    public void setSubTotalKWDAr_Main (String SubTotalKWDAr_Main)
    {
        this.SubTotalKWDAr_Main = SubTotalKWDAr_Main;
    }

    public String getCouponDiscountKWD ()
    {
        return CouponDiscountKWD;
    }

    public void setCouponDiscountKWD (String CouponDiscountKWD)
    {
        this.CouponDiscountKWD = CouponDiscountKWD;
    }

    public String getCouponDiscountKWDAr ()
    {
        return CouponDiscountKWDAr;
    }

    public void setCouponDiscountKWDAr (String CouponDiscountKWDAr)
    {
        this.CouponDiscountKWDAr = CouponDiscountKWDAr;
    }

    public String getCouponDiscount ()
    {
        return CouponDiscount;
    }

    public void setCouponDiscount (String CouponDiscount)
    {
        this.CouponDiscount = CouponDiscount;
    }

}
