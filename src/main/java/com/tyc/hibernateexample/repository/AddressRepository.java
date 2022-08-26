package com.tyc.hibernateexample.repository;

import com.tyc.hibernateexample.entity.Address;
import com.tyc.hibernateexample.utility.MyFactoryRepository;

public class AddressRepository extends MyFactoryRepository<Address, Long> {

	public AddressRepository() {
		super(new Address());
	}

}
