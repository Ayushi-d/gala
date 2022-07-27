package com.master.design.gala.DataModel;

public class DataPrivacyPolicyDM {

    private String Status;

    private Item Item;

    private String Message;

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public Item getItem ()
    {
        return Item;
    }

    public void setItem (Item Item)
    {
        this.Item = Item;
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
