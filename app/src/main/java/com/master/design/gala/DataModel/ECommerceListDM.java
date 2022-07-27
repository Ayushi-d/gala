package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class ECommerceListDM {
    private String Status;

    private String Message;

    private ArrayList<ECommerceList> List;

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

    public ArrayList<ECommerceList> getList ()
    {
        return List;
    }

    public void setList (ArrayList<ECommerceList> List)
    {
        this.List = List;
    }

}
