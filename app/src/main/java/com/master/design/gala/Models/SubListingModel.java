package com.master.design.gala.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class SubListingModel implements Parcelable {
    String id;
    String Type;
    int img;
    String heading;
    String description;
    String price;

    String ImgUrl;

    String StartsFromAr;
    String StartsFrom;
    String VendorID;

    String DescriptionAr;
    String headingAr;

    String CategoryID;

    String Item;


    String   Terms;
    String   TermsAr;
    String   RefundPolicy;
    String   RefundPolicyAr ;
    String   OutsideFoodPolicy;
    String   OutsideFoodPolicyAr ;
    String  ServingCategoryID;
    String RestProductID;

    public String getRestProductID() {
        return RestProductID;
    }

    public void setRestProductID(String restProductID) {
        RestProductID = restProductID;
    }

    public String getServingCategoryID() {
        return ServingCategoryID;
    }

    public void setServingCategoryID(String servingCategoryID) {
        ServingCategoryID = servingCategoryID;
    }

    public String getTerms() {
        return Terms;
    }

    public void setTerms(String terms) {
        Terms = terms;
    }

    public String getTermsAr() {
        return TermsAr;
    }

    public void setTermsAr(String termsAr) {
        TermsAr = termsAr;
    }

    public String getRefundPolicy() {
        return RefundPolicy;
    }

    public void setRefundPolicy(String refundPolicy) {
        RefundPolicy = refundPolicy;
    }

    public String getRefundPolicyAr() {
        return RefundPolicyAr;
    }

    public void setRefundPolicyAr(String refundPolicyAr) {
        RefundPolicyAr = refundPolicyAr;
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

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String vendorID) {
        VendorID = vendorID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }


    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getStartsFromAr() {
        return StartsFromAr;
    }

    public void setStartsFromAr(String startsFromAr) {
        StartsFromAr = startsFromAr;
    }

    public String getStartsFrom() {
        return StartsFrom;
    }

    public void setStartsFrom(String startsFrom) {
        StartsFrom = startsFrom;
    }

    public String getDescriptionAr() {
        return DescriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        DescriptionAr = descriptionAr;
    }

    public String getHeadingAr() {
        return headingAr;
    }

    public void setHeadingAr(String headingAr) {
        this.headingAr = headingAr;
    }

    public SubListingModel() {
    }

    public SubListingModel(int img, String heading, String description, String price) {
        this.img = img;
        this.heading = heading;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.Type);
        dest.writeInt(this.img);
        dest.writeString(this.heading);
        dest.writeString(this.description);
        dest.writeString(this.price);
    }

    protected SubListingModel(Parcel in) {
        this.id = in.readString();
        this.Type = in.readString();
        this.img = in.readInt();
        this.heading = in.readString();
        this.description = in.readString();
        this.price = in.readString();
    }

    public static final Parcelable.Creator<SubListingModel> CREATOR = new Parcelable.Creator<SubListingModel>() {
        @Override
        public SubListingModel createFromParcel(Parcel source) {
            return new SubListingModel(source);
        }

        @Override
        public SubListingModel[] newArray(int size) {
            return new SubListingModel[size];
        }
    };
}
