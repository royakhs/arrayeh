package com.arayeh.hampa.models;

public class Consultant {
    private String name;
    private String address;
    private String phoneNumbedr;
    private int profileIcon;
    public Consultant(String name, String address, String phoneNumbedr
    ,int profileIcon) {
        this.name=name;
        this.address=address;
        this.phoneNumbedr=phoneNumbedr;
        this.profileIcon=profileIcon;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumbedr() {
        return phoneNumbedr;
    }

    public void setPhoneNumbedr(String phoneNumbedr) {
        this.phoneNumbedr = phoneNumbedr;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(int profileIcon) {
        this.profileIcon = profileIcon;
    }
}
