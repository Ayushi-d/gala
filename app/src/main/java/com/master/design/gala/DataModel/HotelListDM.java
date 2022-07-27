package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class HotelListDM {
    private String Status;

    private String Message;

    private ArrayList<HotelList> List;

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

    public ArrayList<HotelList> getList ()
    {
        return List;
    }

    public void setList (ArrayList<HotelList> List)
    {
        this.List = List;
    }

}
