package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class CateringListDM {

    private String Status;

    private String Message;

    private ArrayList<CateringList> List;

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

    public ArrayList<CateringList>getList ()
    {
        return List;
    }

    public void setList (ArrayList<CateringList>List)
    {
        this.List = List;
    }


}
