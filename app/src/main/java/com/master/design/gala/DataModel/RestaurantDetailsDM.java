package com.master.design.gala.DataModel;

public class RestaurantDetailsDM {
    private String Status;

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
