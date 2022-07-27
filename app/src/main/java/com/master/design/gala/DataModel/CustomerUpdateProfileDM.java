package com.master.design.gala.DataModel;

public class CustomerUpdateProfileDM
{
    private String Status;

    private String Message;

    private String CustomerID;

    private String CustomerName;

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

    public String getCustomerID ()
    {
        return CustomerID;
    }

    public void setCustomerID (String CustomerID)
    {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName ()
    {
        return CustomerName;
    }

    public void setCustomerName (String CustomerName)
    {
        this.CustomerName = CustomerName;
    }
}
