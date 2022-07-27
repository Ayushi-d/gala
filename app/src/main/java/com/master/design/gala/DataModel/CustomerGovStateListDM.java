package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class CustomerGovStateListDM {

    private String Status;

    private String CountryID;

    private ArrayList<GovStateList> GovStateList;

    private String Message;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getCountryID ()
    {
        return CountryID;
    }

    public void setCountryID (String CountryID)
    {
        this.CountryID = CountryID;
    }

    public ArrayList<GovStateList> getGovStateList ()
    {
        return GovStateList;
    }

    public void setGovStateList (ArrayList<GovStateList> GovStateList)
    {
        this.GovStateList = GovStateList;
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
