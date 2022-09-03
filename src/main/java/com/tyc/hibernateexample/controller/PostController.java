package com.tyc.hibernateexample.controller;

import java.util.HashMap;
import java.util.Map;

import com.tyc.hibernateexample.entity.Address;
import com.tyc.hibernateexample.entity.EAddressType;
import com.tyc.hibernateexample.entity.EGender;
import com.tyc.hibernateexample.entity.Name;
import com.tyc.hibernateexample.entity.User;
import com.tyc.hibernateexample.entity.UserDetail;
import com.tyc.hibernateexample.repository.UserRepository;

public class PostController {
	public static void main(String[] args) {
//		PostRepository postRepository = new PostRepository();
//		postRepository.save(new Post("Ýcerik - 1", new Date()));
		UserRepository userRepository = new UserRepository();
		Map<EAddressType, Address> address = new HashMap<EAddressType, Address>();
		address.put(EAddressType.HOME, new Address("Kepez", "Antalya", "Turkiye"));
		address.put(EAddressType.BUSINESS, new Address("Muratpasa", "Antalya", "Turkiye"));
		UserDetail userDetail = new UserDetail(EGender.MAN, new Name("Taha", "Yasin", "ÇINAR"), address, 20);
		User user = new User("tyc42", "10359", userDetail);
		userRepository.save(user);
	}
}
