package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class CustomerAreaCityListDM
{
    private String Status;

    private String CountryID;

    private ArrayList<AreaCityList> AreaCityList;

    private String Message;

    private String GovStateID;

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

    public ArrayList<AreaCityList> getAreaCityList ()
    {
        return AreaCityList;
    }

    public void setAreaCityList (ArrayList<AreaCityList> AreaCityList)
    {
        this.AreaCityList = AreaCityList;
    }

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public String getGovStateID ()
    {
        return GovStateID;
    }

    public void setGovStateID (String GovStateID)
    {
        this.GovStateID = GovStateID;
    }

}
