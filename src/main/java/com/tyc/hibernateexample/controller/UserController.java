package com.tyc.hibernateexample.controller;

import java.util.HashMap;
import java.util.Map;

import com.tyc.hibernateexample.entity.Address;
import com.tyc.hibernateexample.entity.EAddressType;
import com.tyc.hibernateexample.repository.UserRepository;

public class UserController {
	public static void main(String[] args) {
//		User user = new User("ccctycccc", "123456", "Erkek");
//		UserDao userDao = new UserDao();
//		userDao.save(user);
//		userDao.findById(0);
//		System.out.println(userDao.delete(3));
//		userDao.update(new User("tyc080", "2444", "Kadýn"), 2);
//		userDao.findAll().forEach(System.out::println);
		UserRepository userRepository = new UserRepository();
//		userRepository.save(new User("usman1", "12355", "E"));
//		userRepository.save(new User("uswman1", "12*58", "K"));
//		System.out.println(userRepository.FindById(4));
//		userRepository.findAll().forEach(System.out::println);
//		userRepository.update(new User("tyc_", "9876", "E"), 4);
//		userRepository.delete(4);
//		userRepository.save(new User("654tyc654", "0246311", EGender.MAN, new Name("Taha", "Yasin", "ÇINAR")));
		Map<EAddressType, Address> address = new HashMap<EAddressType, Address>();
		address.put(EAddressType.HOME, new Address("Kepez", "Antalya", "Turkiye"));
		address.put(EAddressType.BUSINESS, new Address("Muratpasa", "Antalya", "Turkiye"));
//		userRepository.save(new User("helen", "123321", EGender.WOMAN, new Name("Ýpek", "Helen", "ÇINAR")));
		System.out.println(userRepository.delete(1));
	}

}
