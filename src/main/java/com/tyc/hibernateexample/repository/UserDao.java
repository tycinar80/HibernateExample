package com.tyc.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.tyc.hibernateexample.entity.User;
import com.tyc.hibernateexample.utility.HibernateUtils;

public class UserDao implements ICrud<User> {

	public boolean save(User user) {
		Session session = null;
		try {
			session = databaseConnectionHibernate();
			session.getTransaction().begin();
			// Kayýt iþlemi
			session.save(user);
			// Transaction sonlandýrma
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Baðlantý hatasý");
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			// Baðlantý kapanýyor
			session.close();
		}
	}

	public boolean update(User t, long id) {
		User user = null;
		Session session = null;

		try {
			if ((user = findById(id)) != null) {
				user.setUsername(t.getUsername());
				user.setPassword(t.getPassword());
				user.setGender(t.getGender());

				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(user);
//				session.update(user);
				session.getTransaction().commit();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

	}

	public boolean delete(long id) {
		Session session = null;
		User user = null;
		try {
			session = databaseConnectionHibernate();
			session.getTransaction().begin();
			if ((user = findById(id)) != null) {
				session.remove(user);
//				session.delete(user);
				System.out.println(user + " kullanýcýsý silindi");
			}
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public List<User> findAll() {
		Session session = null;
		try {
			session = databaseConnectionHibernate();
			String query = "select users from User as users";
			TypedQuery<User> typedQuery = session.createQuery(query, User.class);
			List<User> userList = typedQuery.getResultList();
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public User findById(long id) {
		User user;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			user = session.find(User.class, id);
			if (user != null) {
				System.out.println("User bulundu. " + user.toString());
				return user;
			} else {
				System.out.println("User bulunamadý. " + user);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Session databaseConnectionHibernate() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	@Override
	public Optional<User> FindById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
