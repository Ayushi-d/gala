package com.master.design.gala.DataModel;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageList implements Parcelable {

    private String Image;

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
        dest.writeString(this.Image);
    }

    public void readFromParcel(Parcel source) {
        this.Image = source.readString();
    }

    public ImageList() {
    }

    protected ImageList(Parcel in) {
        this.Image = in.readString();
    }

    public static final Parcelable.Creator<ImageList> CREATOR = new Parcelable.Creator<ImageList>() {
        @Override
        public ImageList createFromParcel(Parcel source) {
            return new ImageList(source);
        }

        @Override
        public ImageList[] newArray(int size) {
            return new ImageList[size];
        }
    };
}
