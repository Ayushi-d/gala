package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class OccasionListDM
{
    private String Status;

    private String Message;

    private ArrayList<OccasionList> OccasionList;

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

    public ArrayList<OccasionList> getOccasionList ()
    {
        return OccasionList;
    }

    public void setOccasionList (ArrayList<OccasionList> OccasionList)
    {
        this.OccasionList = OccasionList;
    }

}
