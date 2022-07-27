package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class CateringDetailsDM {

    private String Status;

    private Details Details;

    private ArrayList<Description> Description;

    private String Message;

    private String SlotAvailableStatusMessage;

    private String SlotAvailableStatus;

    private ArrayList<CateringDishes> CateringDishes;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public Details getDetails ()
    {
        return Details;
    }

    public void setDetails (Details Details)
    {
        this.Details = Details;
    }

    public ArrayList<Description> getDescription ()
    {
        return Description;
    }

    public void setDescription (ArrayList<Description> Description)
    {
        this.Description = Description;
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

    public ArrayList<CateringDishes> getCateringDishes ()
    {
        return CateringDishes;
    }

    public void setCateringDishes (ArrayList<CateringDishes> CateringDishes)
    {
        this.CateringDishes = CateringDishes;
    }

}
