package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class CustomerAddressListDM
{

    private String Status;

    private String Message;

    private ArrayList<AddressList> AddressList;

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

    public ArrayList<AddressList> getAddressList ()
    {
        return AddressList;
    }

    public void setAddressList (ArrayList<AddressList> AddressList)
    {
        this.AddressList = AddressList;
    }
}
