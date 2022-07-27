package com.master.design.gala.DataModel;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductList implements Parcelable {
    private String ProductNameAr;

    private String UnitPrice;

    private String ProductName;

    private String ProductID;

    private String ThumbImage;

    private String UnitPriceAr;

    private String RestaurantNameAr;

    private String Description;

    private String RestProductID;

    private String RestaurantName;

    private String DescriptionAr;

    private String RestProductName;

    private String RestProductNameAr;

    public String getRestProductName() {
        return RestProductName;
    }

    public void setRestProductName(String restProductName) {
        RestProductName = restProductName;
    }

    public String getRestProductNameAr() {
        return RestProductNameAr;
    }

    public void setRestProductNameAr(String restProductNameAr) {
        RestProductNameAr = restProductNameAr;
    }

    public String getRestaurantNameAr() {
        return RestaurantNameAr;
    }

    public void setRestaurantNameAr(String restaurantNameAr) {
        RestaurantNameAr = restaurantNameAr;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRestProductID() {
        return RestProductID;
    }

    public void setRestProductID(String restProductID) {
        RestProductID = restProductID;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getDescriptionAr() {
        return DescriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        DescriptionAr = descriptionAr;
    }

    public String getProductNameAr ()
    {
        return ProductNameAr;
    }

    public void setProductNameAr (String ProductNameAr)
    {
        this.ProductNameAr = ProductNameAr;
    }

    public String getUnitPrice ()
    {
        return UnitPrice;
    }

    public void setUnitPrice (String UnitPrice)
    {
        this.UnitPrice = UnitPrice;
    }

    public String getProductName ()
    {
        return ProductName;
    }

    public void setProductName (String ProductName)
    {
        this.ProductName = ProductName;
    }

    public String getProductID ()
    {
        return ProductID;
    }

    public void setProductID (String ProductID)
    {
        this.ProductID = ProductID;
    }

    public String getThumbImage ()
    {
        return ThumbImage;
    }

    public void setThumbImage (String ThumbImage)
    {
        this.ThumbImage = ThumbImage;
    }

    public String getUnitPriceAr ()
    {
        return UnitPriceAr;
    }

    public void setUnitPriceAr (String UnitPriceAr)
    {
        this.UnitPriceAr = UnitPriceAr;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ProductNameAr);
        dest.writeString(this.UnitPrice);
        dest.writeString(this.ProductName);
        dest.writeString(this.ProductID);
        dest.writeString(this.ThumbImage);
        dest.writeString(this.UnitPriceAr);
        dest.writeString(this.RestaurantNameAr);
        dest.writeString(this.Description);
        dest.writeString(this.RestProductID);
        dest.writeString(this.RestaurantName);
        dest.writeString(this.DescriptionAr);
        dest.writeString(this.RestProductName);
        dest.writeString(this.RestProductNameAr);
    }

    public void readFromParcel(Parcel source) {
        this.ProductNameAr = source.readString();
        this.UnitPrice = source.readString();
        this.ProductName = source.readString();
        this.ProductID = source.readString();
        this.ThumbImage = source.readString();
        this.UnitPriceAr = source.readString();
        this.RestaurantNameAr = source.readString();
        this.Description = source.readString();
        this.RestProductID = source.readString();
        this.RestaurantName = source.readString();
        this.DescriptionAr = source.readString();
        this.RestProductName = source.readString();
        this.RestProductNameAr = source.readString();
    }

    public ProductList() {
    }

    protected ProductList(Parcel in) {
        this.ProductNameAr = in.readString();
        this.UnitPrice = in.readString();
        this.ProductName = in.readString();
        this.ProductID = in.readString();
        this.ThumbImage = in.readString();
        this.UnitPriceAr = in.readString();
        this.RestaurantNameAr = in.readString();
        this.Description = in.readString();
        this.RestProductID = in.readString();
        this.RestaurantName = in.readString();
        this.DescriptionAr = in.readString();
        this.RestProductName = in.readString();
        this.RestProductNameAr = in.readString();
    }

    public static final Parcelable.Creator<ProductList> CREATOR = new Parcelable.Creator<ProductList>() {
        @Override
        public ProductList createFromParcel(Parcel source) {
            return new ProductList(source);
        }

        @Override
        public ProductList[] newArray(int size) {
            return new ProductList[size];
        }
    };
}
