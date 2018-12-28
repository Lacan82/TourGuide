package com.example.dmorgan.tourguideapp;

public class Places {

    private String mPlace;
    private int mPlaceImage;
    private String mPlaceAddress;
    private String mPlacePhone;


    public Places(String Place, int Image, String Address, String Phone) {
        mPlace= Place;
        mPlaceImage = Image;
        mPlaceAddress = Address;
        mPlacePhone = Phone;
    }

    public String getPlace() {
        return mPlace;
    }

    public int getPlaceImage() {
        return mPlaceImage;
    }

    public String getPlaceAddress() {
        return mPlaceAddress;
    }

    public String getPlacePhone() {
        return mPlacePhone;
    }
}
