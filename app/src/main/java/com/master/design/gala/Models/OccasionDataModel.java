package com.master.design.gala.Models;

public class OccasionDataModel {
    int img;
    String Heading;

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    String description;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OccasionDataModel(int img, String heading, String description) {
        this.img = img;
        Heading = heading;
        this.description = description;
    }

    public OccasionDataModel(int img, String heading) {
        this.img = img;
        Heading = heading;
    }
}
