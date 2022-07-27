package com.master.design.gala.DataModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Item implements Parcelable {
    private String Description;

    private String DescriptionAr;

    private String ServingID;

    private String MinPeople;

    private String RefundPolicy;

    private String TermsAr;

    private String VendorID;

    private String Terms;

    private ArrayList<ImageList> ImageList;

    private String OutsideFoodPolicy;

    private String OutsideFoodPolicyAr;

    private String PriceKWDAr;

    private String Price;

    private String ServingCategoryID;

    private String PriceKWD;

    private String RefundPolicyAr;

    private String PricePerPerson;


    private String VendorName;

    private String VendorNameAr;

    private String ParkingID;

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getVendorNameAr() {
        return VendorNameAr;
    }

    public void setVendorNameAr(String vendorNameAr) {
        VendorNameAr = vendorNameAr;
    }

    public String getParkingID() {
        return ParkingID;
    }

    public void setParkingID(String parkingID) {
        ParkingID = parkingID;
    }

    public String getServingID() {
        return ServingID;
    }

    public void setServingID(String servingID) {
        ServingID = servingID;
    }

    public String getMinPeople() {
        return MinPeople;
    }

    public void setMinPeople(String minPeople) {
        MinPeople = minPeople;
    }

    public String getRefundPolicy() {
        return RefundPolicy;
    }

    public void setRefundPolicy(String refundPolicy) {
        RefundPolicy = refundPolicy;
    }

    public String getTermsAr() {
        return TermsAr;
    }

    public void setTermsAr(String termsAr) {
        TermsAr = termsAr;
    }

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String vendorID) {
        VendorID = vendorID;
    }

    public String getTerms() {
        return Terms;
    }

    public void setTerms(String terms) {
        Terms = terms;
    }

    public ArrayList<com.master.design.gala.DataModel.ImageList> getImageList() {
        return ImageList;
    }

    public void setImageList(ArrayList<com.master.design.gala.DataModel.ImageList> imageList) {
        ImageList = imageList;
    }

    public String getOutsideFoodPolicy() {
        return OutsideFoodPolicy;
    }

    public void setOutsideFoodPolicy(String outsideFoodPolicy) {
        OutsideFoodPolicy = outsideFoodPolicy;
    }

    public String getOutsideFoodPolicyAr() {
        return OutsideFoodPolicyAr;
    }

    public void setOutsideFoodPolicyAr(String outsideFoodPolicyAr) {
        OutsideFoodPolicyAr = outsideFoodPolicyAr;
    }

    public String getPriceKWDAr() {
        return PriceKWDAr;
    }

    public void setPriceKWDAr(String priceKWDAr) {
        PriceKWDAr = priceKWDAr;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getServingCategoryID() {
        return ServingCategoryID;
    }

    public void setServingCategoryID(String servingCategoryID) {
        ServingCategoryID = servingCategoryID;
    }

    public String getPriceKWD() {
        return PriceKWD;
    }

    public void setPriceKWD(String priceKWD) {
        PriceKWD = priceKWD;
    }

    public String getRefundPolicyAr() {
        return RefundPolicyAr;
    }

    public void setRefundPolicyAr(String refundPolicyAr) {
        RefundPolicyAr = refundPolicyAr;
    }

    public String getPricePerPerson() {
        return PricePerPerson;
    }

    public void setPricePerPerson(String pricePerPerson) {
        PricePerPerson = pricePerPerson;
    }

    public String getDescription ()
    {
        return Description;
    }

    public void setDescription (String Description)
    {
        this.Description = Description;
    }

    public String getDescriptionAr ()
    {
        return DescriptionAr;
    }

    public void setDescriptionAr (String DescriptionAr)
    {
        this.DescriptionAr = DescriptionAr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Description);
        dest.writeString(this.DescriptionAr);
        dest.writeString(this.ServingID);
        dest.writeString(this.MinPeople);
        dest.writeString(this.RefundPolicy);
        dest.writeString(this.TermsAr);
        dest.writeString(this.VendorID);
        dest.writeString(this.Terms);
        dest.writeList(this.ImageList);
        dest.writeString(this.OutsideFoodPolicy);
        dest.writeString(this.OutsideFoodPolicyAr);
        dest.writeString(this.PriceKWDAr);
        dest.writeString(this.Price);
        dest.writeString(this.ServingCategoryID);
        dest.writeString(this.PriceKWD);
        dest.writeString(this.RefundPolicyAr);
        dest.writeString(this.PricePerPerson);
    }

    public void readFromParcel(Parcel source) {
        this.Description = source.readString();
        this.DescriptionAr = source.readString();
        this.ServingID = source.readString();
        this.MinPeople = source.readString();
        this.RefundPolicy = source.readString();
        this.TermsAr = source.readString();
        this.VendorID = source.readString();
        this.Terms = source.readString();
        this.ImageList = new ArrayList<com.master.design.gala.DataModel.ImageList>();
        source.readList(this.ImageList, com.master.design.gala.DataModel.ImageList.class.getClassLoader());
        this.OutsideFoodPolicy = source.readString();
        this.OutsideFoodPolicyAr = source.readString();
        this.PriceKWDAr = source.readString();
        this.Price = source.readString();
        this.ServingCategoryID = source.readString();
        this.PriceKWD = source.readString();
        this.RefundPolicyAr = source.readString();
        this.PricePerPerson = source.readString();
    }

    public Item() {
    }

    protected Item(Parcel in) {
        this.Description = in.readString();
        this.DescriptionAr = in.readString();
        this.ServingID = in.readString();
        this.MinPeople = in.readString();
        this.RefundPolicy = in.readString();
        this.TermsAr = in.readString();
        this.VendorID = in.readString();
        this.Terms = in.readString();
        this.ImageList = new ArrayList<com.master.design.gala.DataModel.ImageList>();
        in.readList(this.ImageList, com.master.design.gala.DataModel.ImageList.class.getClassLoader());
        this.OutsideFoodPolicy = in.readString();
        this.OutsideFoodPolicyAr = in.readString();
        this.PriceKWDAr = in.readString();
        this.Price = in.readString();
        this.ServingCategoryID = in.readString();
        this.PriceKWD = in.readString();
        this.RefundPolicyAr = in.readString();
        this.PricePerPerson = in.readString();
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
