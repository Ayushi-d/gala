package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class ECommerceCategoryProductListDM {
    private String Status;

    private String VendorName;

    private ArrayList<CategoryList> CategoryList;

    private String Message;

    private String VendorID;

    private String VendorNameAr;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getVendorName ()
    {
        return VendorName;
    }

    public void setVendorName (String VendorName)
    {
        this.VendorName = VendorName;
    }

    public ArrayList<CategoryList> getCategoryList ()
    {
        return CategoryList;
    }

    public void setCategoryList (ArrayList<CategoryList> CategoryList)
    {
        this.CategoryList = CategoryList;
    }

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public String getVendorID ()
    {
        return VendorID;
    }

    public void setVendorID (String VendorID)
    {
        this.VendorID = VendorID;
    }

    public String getVendorNameAr ()
    {
        return VendorNameAr;
    }

    public void setVendorNameAr (String VendorNameAr)
    {
        this.VendorNameAr = VendorNameAr;
    }


}
