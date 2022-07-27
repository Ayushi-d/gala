package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class CategoryListDM {
    private String Status;

    private String Message;

    private ArrayList<CategoryList> List;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public ArrayList<CategoryList> getList ()
    {
        return List;
    }

    public void setList (ArrayList<CategoryList> List)
    {
        this.List = List;
    }
}
