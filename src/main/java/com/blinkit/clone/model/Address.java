package com.blinkit.clone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	private int userId;
	private String receiverName;
	private String houseNo;
	private String streetNo;
	private String area;
	private String pincode;
	
	
	public Address() {
		super();
	}


	public Address(int addressId, int userId, String receiverName, String houseNo, String streetNo, String area,
			String pincode) {
		super();
		this.addressId = addressId;
		this.userId = userId;
		this.receiverName = receiverName;
		this.houseNo = houseNo;
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


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getReceiverName() {
		return receiverName;
	}


	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}


	public String getHouseNo() {
		return houseNo;
	}


	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
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
		return "Address [addressId=" + addressId + ", userId=" + userId + ", receiverName=" + receiverName
				+ ", houseNo=" + houseNo + ", streetNo=" + streetNo + ", area=" + area + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
