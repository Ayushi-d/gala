package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class HallDetailsDM {
    private String Status;

    private ArrayList<AmenityList> AmenityList;

    private String SlotAvailableStatus;

    private String SlotAvailableStatusMessage;

    private Details Details;

    private String Message;

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


    public String getSlotAvailableStatus() {
        return SlotAvailableStatus;
    }

    public void setSlotAvailableStatus(String slotAvailableStatus) {
        SlotAvailableStatus = slotAvailableStatus;
    }

    public String getSlotAvailableStatusMessage() {
        return SlotAvailableStatusMessage;
    }

    public void setSlotAvailableStatusMessage(String slotAvailableStatusMessage) {
        SlotAvailableStatusMessage = slotAvailableStatusMessage;
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


}
