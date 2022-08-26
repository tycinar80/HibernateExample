package com.tyc.hibernateexample.entity;

import javax.persistence.Embeddable;

/*
 * firstname
 * middlename
 * lastname
 * bir entity olmasýn
 * user'da kullanýlacak
 */
@Embeddable
public class Name {
	private String firstname;
	private String middlename;
	private String lastname;

	@Override
	public String toString() {
		return "Name [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + "]";
	}

	public Name() {
	}

	public Name(String firstname, String middlename, String lastname) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
	}

}
