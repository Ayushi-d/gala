package com.master.design.gala.DataModel;

public class CustomerDetailsDM
{
    private String Status;

    private String Message;

    private Customer Customer;

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

    public Customer getCustomer ()
    {
        return Customer;
    }

    public void setCustomer (Customer Customer)
    {
        this.Customer = Customer;
    }

}
