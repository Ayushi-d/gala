package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class OccasionList {
    private String Description;

    private ArrayList<CategoryList> CategoryList;

    private String OccasionID;

    private String Image;

    private String DescriptionAr;

    private String Name;

    private String NameAr;

    public String getDescription ()
    {
        return Description;
    }

    public void setDescription (String Description)
    {
        this.Description = Description;
    }

    public ArrayList<CategoryList> getCategoryList ()
    {
        return CategoryList;
    }

    public void setCategoryList (ArrayList<CategoryList> CategoryList)
    {
        this.CategoryList = CategoryList;
    }

    public String getOccasionID ()
    {
        return OccasionID;
    }

    public void setOccasionID (String OccasionID)
    {
        this.OccasionID = OccasionID;
    }

    public String getImage ()
    {
        return Image;
    }

    public void setImage (String Image)
    {
        this.Image = Image;
    }

    public String getDescriptionAr ()
    {
        return DescriptionAr;
    }

    public void setDescriptionAr (String DescriptionAr)
    {
        this.DescriptionAr = DescriptionAr;
    }

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    public String getNameAr ()
    {
        return NameAr;
    }

    public void setNameAr (String NameAr)
    {
        this.NameAr = NameAr;
    }
}
