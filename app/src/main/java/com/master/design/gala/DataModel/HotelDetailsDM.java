package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class HotelDetailsDM {

    private String Status;

    private ArrayList<AmenityList> AmenityList;

    private Details Details;

    private String Message;

    private String SlotAvailableStatusMessage;

    private String SlotAvailableStatus;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public ArrayList<AmenityList> getAmenityList ()
    {
        return AmenityList;
    }

    public void setAmenityList (ArrayList<AmenityList> AmenityList)
    {
        this.AmenityList = AmenityList;
    }

    public Details getDetails ()
    {
        return Details;
    }

    public void setDetails (Details Details)
    {
        this.Details = Details;
    }

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public String getSlotAvailableStatusMessage ()
    {
        return SlotAvailableStatusMessage;
    }

    public void setSlotAvailableStatusMessage (String SlotAvailableStatusMessage)
    {
        this.SlotAvailableStatusMessage = SlotAvailableStatusMessage;
    }

    public String getSlotAvailableStatus ()
    {
        return SlotAvailableStatus;
    }

    public void setSlotAvailableStatus (String SlotAvailableStatus)
    {
        this.SlotAvailableStatus = SlotAvailableStatus;
    }

}
