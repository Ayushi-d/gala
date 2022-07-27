package com.master.design.gala.Models;

public class SliderItem {
    private String description="";
    private String imageUrl;
    private int ImgId;

    public SliderItem(int imgId,String description) {
        this.description = description;
        ImgId = imgId;
    }

    public SliderItem(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
