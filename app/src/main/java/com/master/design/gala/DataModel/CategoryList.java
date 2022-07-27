package com.master.design.gala.DataModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CategoryList implements Parcelable {
    private String CategoryID;

    private String CategoryNameAr;

    private String CategoryName;

    private String Image;

    private String RestCatID;

    private ArrayList<ProductList> ProductList;

    public String getRestCatID() {
        return RestCatID;
    }

    public void setRestCatID(String restCatID) {
        RestCatID = restCatID;
    }

    public ArrayList<ProductList> getProductList() {
        return ProductList;
    }

    public void setProductList(ArrayList<ProductList> productList) {
        ProductList = productList;
    }

    public String getCategoryID ()
    {
        return CategoryID;
    }

    public void setCategoryID (String CategoryID)
    {
        this.CategoryID = CategoryID;
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

    public String getImage ()
    {
        return Image;
    }

    public void setImage (String Image)
    {
        this.Image = Image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.CategoryID);
        dest.writeString(this.CategoryNameAr);
        dest.writeString(this.CategoryName);
        dest.writeString(this.Image);
    }

    public void readFromParcel(Parcel source) {
        this.CategoryID = source.readString();
        this.CategoryNameAr = source.readString();
        this.CategoryName = source.readString();
        this.Image = source.readString();
    }

    public CategoryList() {
    }

    protected CategoryList(Parcel in) {
        this.CategoryID = in.readString();
        this.CategoryNameAr = in.readString();
        this.CategoryName = in.readString();
        this.Image = in.readString();
    }

    public static final Parcelable.Creator<CategoryList> CREATOR = new Parcelable.Creator<CategoryList>() {
        @Override
        public CategoryList createFromParcel(Parcel source) {
            return new CategoryList(source);
        }

        @Override
        public CategoryList[] newArray(int size) {
            return new CategoryList[size];
        }
    };
}
