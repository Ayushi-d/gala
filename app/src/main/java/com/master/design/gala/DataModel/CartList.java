package com.master.design.gala.DataModel;

import java.util.ArrayList;

public class CartList {
    private String BookingRequestDate;
    private String HallCartID;
    private String SubTotalKWDAr_Item;
    private String SubTotal_Item;
    private String SlotStatus;
    private String VendorID;
    private String SlotStatusTextAr;
    private String HallNameAr;
    private String ThumbImage;
    private String SlotStatusText;
    private String SubTotalKWD_Item;
    private String HallID;
    private ArrayList<AmenityList> AmenityList;
    private String HallName;
    private String SelectedNumberOfPeople;
    private String PricePerPerson;


    public String getBookingRequestDate() {
        return BookingRequestDate;
    }

    public void setBookingRequestDate(String bookingRequestDate) {
        BookingRequestDate = bookingRequestDate;
    }

    public String getHallCartID() {
        return HallCartID;
    }

    public void setHallCartID(String hallCartID) {
        HallCartID = hallCartID;
    }

    public String getSubTotalKWDAr_Item() {
        return SubTotalKWDAr_Item;
    }

    public void setSubTotalKWDAr_Item(String subTotalKWDAr_Item) {
        SubTotalKWDAr_Item = subTotalKWDAr_Item;
    }

    public String getSubTotal_Item() {
        return SubTotal_Item;
    }

    public void setSubTotal_Item(String subTotal_Item) {
        SubTotal_Item = subTotal_Item;
    }

    public String getSlotStatus() {
        return SlotStatus;
    }

    public void setSlotStatus(String slotStatus) {
        SlotStatus = slotStatus;
    }

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String vendorID) {
        VendorID = vendorID;
    }

    public String getSlotStatusTextAr() {
        return SlotStatusTextAr;
    }

    public void setSlotStatusTextAr(String slotStatusTextAr) {
        SlotStatusTextAr = slotStatusTextAr;
    }

    public String getHallNameAr() {
        return HallNameAr;
    }

    public void setHallNameAr(String hallNameAr) {
        HallNameAr = hallNameAr;
    }

    public String getThumbImage() {
        return ThumbImage;
    }

    public void setThumbImage(String thumbImage) {
        ThumbImage = thumbImage;
    }

    public String getSlotStatusText() {
        return SlotStatusText;
    }

    public void setSlotStatusText(String slotStatusText) {
        SlotStatusText = slotStatusText;
    }

    public String getSubTotalKWD_Item() {
        return SubTotalKWD_Item;
    }

    public void setSubTotalKWD_Item(String subTotalKWD_Item) {
        SubTotalKWD_Item = subTotalKWD_Item;
    }

    public String getHallID() {
        return HallID;
    }

    public void setHallID(String hallID) {
        HallID = hallID;
    }

    public ArrayList<com.master.design.gala.DataModel.AmenityList> getAmenityList() {
        return AmenityList;
    }

    public void setAmenityList(ArrayList<com.master.design.gala.DataModel.AmenityList> amenityList) {
        AmenityList = amenityList;
    }

    public String getHallName() {
        return HallName;
    }

    public void setHallName(String hallName) {
        HallName = hallName;
    }

    public String getSelectedNumberOfPeople() {
        return SelectedNumberOfPeople;
    }

    public void setSelectedNumberOfPeople(String selectedNumberOfPeople) {
        SelectedNumberOfPeople = selectedNumberOfPeople;
    }

    public String getPricePerPerson() {
        return PricePerPerson;
    }

    public void setPricePerPerson(String pricePerPerson) {
        PricePerPerson = pricePerPerson;
    }
}