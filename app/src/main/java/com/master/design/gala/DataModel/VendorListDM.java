package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class VendorListDM
{
    private String Status;

    private String CategoryID;

    private String Message;

    private String CategoryNameAr;

    private String CategoryName;

    private ArrayList<VendorList> List;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getCategoryID ()
    {
        return CategoryID;
    }

    public void setCategoryID (String CategoryID)
    {
        this.CategoryID = CategoryID;
    }

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public String getCategoryNameAr ()
    {
        return CategoryNameAr;
    }

    public void setCategoryNameAr (String CategoryNameAr)
    {
        this.CategoryNameAr = CategoryNameAr;
    }

    public String getCategoryName ()
    {
        return CategoryName;
    }

    public void setCategoryName (String CategoryName)
    {
        this.CategoryName = CategoryName;
    }

    public ArrayList<VendorList> getList ()
    {
        return List;
    }

    public void setList (ArrayList<VendorList> List)
    {
        this.List = List;
    }

}
