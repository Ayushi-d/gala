package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class RestaurantListDM {


    private String Status;

    private ArrayList<CategoryList> CategoryList;

    private String Message;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
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

}
