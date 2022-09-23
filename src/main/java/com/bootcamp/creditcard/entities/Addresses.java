package com.bootcamp.creditcard.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Addresses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	
	@NotEmpty(message="doorNo Should Not Be Empty")
	private String doorNo;
	
	@NotEmpty(message="street Should Not Be Empty")
	private String street;
	
	@NotEmpty(message="area Should Not Be Empty")
	private String area;
	
	@NotEmpty(message="city Should Not Be Empty")
	private String city;
	
	@NotEmpty(message="state Should Not Be Empty")
	private String state;
	
	@Min(value=10,message="pincode should be minimum 10")
	private int pincode;
	
	@OneToOne(mappedBy = "addresses")
	@JsonIgnore
	private Customer customer;
	
	public int getAddressId() {
		return addressId;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}