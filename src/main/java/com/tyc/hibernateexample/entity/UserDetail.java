package com.tyc.hibernateexample.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Enumerated(EnumType.STRING)
	private EGender gender;

	@Embedded
	private Name name;

	@ElementCollection
	Map<EAddressType, Address> address;

	@ElementCollection
	List<String> areasOfInterest;

	@Column(nullable = true)
	private int postNumber;

	@OneToOne(mappedBy = "userDetail")
	private User user;

	public UserDetail(EGender gender, Name name, Map<EAddressType, Address> address, // List<String> areasOfInterest,
			int postNumber) {
		super();
		this.gender = gender;
		this.name = name;
		this.address = address;
//		this.areasOfInterest = areasOfInterest;
		this.postNumber = postNumber;
	}

	public UserDetail() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EGender getGender() {
		return gender;
	}

	public void setGender(EGender gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Map<EAddressType, Address> getAddress() {
		return address;
	}

	public void setAddress(Map<EAddressType, Address> address) {
		this.address = address;
	}

	public List<String> getAreasOfInterest() {
		return areasOfInterest;
	}

	public void setAreasOfInterest(List<String> areasOfInterest) {
		this.areasOfInterest = areasOfInterest;
	}

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", gender=" + gender + ", name=" + name + ", address=" + address
				+ ", areasOfInterest=" + areasOfInterest + ", postNumber=" + postNumber + "]";
	}

}
