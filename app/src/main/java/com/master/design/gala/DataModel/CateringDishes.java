package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class CateringDishes {

    private String DishTypeAr;

    private String DishType;

    private ArrayList<Dishes> Dishes;

    public String getDishTypeAr ()
    {
        return DishTypeAr;
    }

    public void setDishTypeAr (String DishTypeAr)
    {
        this.DishTypeAr = DishTypeAr;
    }

    public String getDishType ()
    {
        return DishType;
    }

    public void setDishType (String DishType)
    {
        this.DishType = DishType;
    }

    public ArrayList<Dishes> getDishes ()
    {
        return Dishes;
    }

    public void setDishes (ArrayList<Dishes> Dishes)
    {
        this.Dishes = Dishes;
    }


}
