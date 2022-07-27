package com.master.design.gala.DataModel;

public class ServingServicesList {
    private Item Item;

    private String CategoryNameAr;

    private String CategoryName;

    private String ServingCategoryID;

    public Item getItem ()
    {
        return Item;
    }

    public void setItem (Item Item)
    {
        this.Item = Item;
    }

    public String getCategoryNameAr ()
    {
        return CategoryNameAr;
    }

    public void setCategoryNameAr (String CategoryNameAr)
    {
        this.CategoryNameAr = CategoryNameAr;
    }

    public String getCategoryName ()
    {
        return CategoryName;
    }

    public void setCategoryName (String CategoryName)
    {
        this.CategoryName = CategoryName;
    }

    public String getServingCategoryID ()
    {
        return ServingCategoryID;
    }

    public void setServingCategoryID (String ServingCategoryID)
    {
        this.ServingCategoryID = ServingCategoryID;
    }

}
