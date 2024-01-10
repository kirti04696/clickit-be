package com.blinkit.clone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShopAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String shopNo;

    private String streetNo;

    private String area;

    private String pincode;

    public ShopAddress() {
    }

    public ShopAddress(int addressId, String shopNo, String streetNo, String area, String pincode) {
        this.addressId = addressId;
        this.shopNo = shopNo;
        this.streetNo = streetNo;
        this.area = area;
        this.pincode = pincode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "ShopAddress{" +
                "addressId=" + addressId +
                ", shopNo='" + shopNo + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", area='" + area + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
