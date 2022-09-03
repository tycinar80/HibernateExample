package com.tyc.hibernateexample.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tyc.hibernateexample.entity.Post;
import com.tyc.hibernateexample.entity.User;
import com.tyc.hibernateexample.entity.UserDetail;

public class HibernateUtils {
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();
			// Entity classlarýmýzý buraya ekliyoruz
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Post.class);
			configuration.addAnnotatedClass(UserDetail.class);
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
