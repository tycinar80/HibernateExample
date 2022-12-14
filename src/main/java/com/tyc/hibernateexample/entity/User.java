package com.tyc.hibernateexample.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * username
 * password
 * gender
 * 
 * crud metotlar? yaz?lacak
 * UserDao class? olu?turup buraya implement edelim
 */

@Entity
@Table(name = "tblusers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(length = 32)
	private String password;
	@Enumerated(EnumType.STRING)
	private EGender gender;
	@Embedded
	private Name name;
	@ElementCollection
	Map<EAddressType, Address> address;

	@OneToOne()
	private UserDetail userDetail;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> post;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender + "]";
	}

	public User() {
	}

	public User(String username, String password, UserDetail userDetail) {
		super();
		this.username = username;
		this.password = password;
		this.userDetail = userDetail;
	}

	public User(String username, String password, EGender gender, Name name, Map<EAddressType, Address> address) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.name = name;
		this.address = address;
	}

	public User(String username, String password, EGender gender, Name name) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.name = name;
	}

	public User(String username, String password, EGender gender) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EGender getGender() {
		return gender;
	}

	public void setGender(EGender gender) {
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}
