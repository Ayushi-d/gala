package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class ServingServicesListDM {

    private String Status;

    private String Message;

    private ArrayList<ServingServicesList> List;

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

    public ArrayList<ServingServicesList>getList ()
    {
        return List;
    }

    public void setList (ArrayList<ServingServicesList>List)
    {
        this.List = List;
    }
}
