package com.tyc.hibernateexample.service;

import com.tyc.hibernateexample.entity.Address;
import com.tyc.hibernateexample.repository.AddressRepository;
import com.tyc.hibernateexample.utility.MyFactoryService;

public class AddressService extends MyFactoryService<AddressRepository, Address, Long> {

	public AddressService() {
		super(new AddressRepository());
		// TODO Auto-generated constructor stub
	}

}
