package com.master.design.gala.DataModel;

public class CustomerRegisterDM

    {
        private String Status;

        private String Message;

        private String CustomerID;

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

    }