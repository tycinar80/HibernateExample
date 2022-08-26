package com.tyc.hibernateexample.hql;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.tyc.hibernateexample.entity.User;
import com.tyc.hibernateexample.utility.HibernateUtils;

public class HqlTest {
	public static void findAll() {
		String hql = "select u from User as u";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		List<User> users = typedQuery.getResultList();
		users.forEach(System.out::println);

	}

	public static void startLike(String value) {

		String hql = "select u from User as u  where  u.name.firstname   like  'T%'  ";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		List<User> users = typedQuery.getResultList();
		users.forEach(System.out::println);
	}

	public static void main(String[] args) {

//		findAll();
		startLike("T");

	}
}
