package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class HallListDM {
    private String Status;

    private String Message;

    private ArrayList<HallList> List;

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

    public ArrayList<HallList> getList ()
    {
        return List;
    }

    public void setList (ArrayList<HallList> List)
    {
        this.List = List;
    }
}
