package com.tyc.hibernateexample.entity;

import javax.persistence.Embeddable;

/*
 * streetName
 * city
 * country
 */
@Embeddable
public class Address {
	private String streetName;
	private String city;
	private String country;

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", city=" + city + ", country=" + country + "]";
	}

	public Address() {
	}

	public Address(String streetName, String city, String country) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
