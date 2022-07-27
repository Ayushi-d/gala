package com.master.design.gala.Models;

public class AddressDM {
    String home;
    String address;
    String direction;
    String phoneNumber;

    public AddressDM(String home, String address, String direction, String phoneNumber) {
        this.home = home;
        this.address = address;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}



