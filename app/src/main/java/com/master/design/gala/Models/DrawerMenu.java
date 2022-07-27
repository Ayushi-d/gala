package com.master.design.gala.Models;

public class DrawerMenu {
    public static final int Langauge = 0,Notification=1,Terms=2,Privacy=3,Contact_us=4,My_Address=5,My_Wishlist=6,My_Order=7,Privacy_Policy=8;
    private int id;
    private int icon;
    private String name;
    private int badge;
    private boolean Selected=false;
    public DrawerMenu(int id, int icon, String name) {
        this.id = id;
        this.icon = icon;
        this.name = name;
    }

    public DrawerMenu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public boolean isSelected() {

        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }
}

