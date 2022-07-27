package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class OccasionSlidesDM {

    private String Status;

    private String Message;

    private ArrayList<OccasionSlides> List;

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

    public ArrayList<OccasionSlides> getList ()
    {
        return List;
    }

    public void setList (ArrayList<OccasionSlides> List)
    {
        this.List = List;
    }
}
