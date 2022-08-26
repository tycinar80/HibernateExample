package com.tyc.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tyc.hibernateexample.entity.User;
import com.tyc.hibernateexample.utility.HibernateUtils;

public class UserRepository implements ICrud<User> {
	private Session session;
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private Transaction transaction;

	public UserRepository() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		criteriaBuilder = entityManager.getCriteriaBuilder();
	}

	public void openSession() {
		session = databaseConnectionHibernate();
		transaction = session.beginTransaction();
	}

	public void closeSucces() {
		transaction.commit();
		session.close();
	}

	public void closeError() {
		transaction.rollback();
		session.close();
	}

	@Override
	public boolean save(User t) {
		try {
			openSession();
			session.save(t);
			closeSucces();
			return true;
		} catch (Exception e) {
			closeError();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User t, long id) {
		try {
			openSession();
			t.setId(id);
			session.update(t);
			closeSucces();
			return true;
		} catch (Exception e) {
			closeError();
			return false;
		}
	}

	@Override
	public boolean delete(long id) {
		Optional<User> user = FindById(id);
		if (user.isPresent()) {
			try {
				openSession();
				session.delete(user.get());
				closeSucces();
				return true;
			} catch (Exception e) {
				closeError();
				e.printStackTrace();
				System.out.println("Silinmedi");
				return false;
			}
		} else {
			System.out.println(id + " id'li veri bulunamadý");
			return false;
		}

	}

	@Override
	public List<User> findAll() {
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Optional<User> FindById(long id) {
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));

		try {
			return Optional.ofNullable(entityManager.createQuery(criteriaQuery).getSingleResult());
		} catch (Exception e) {
			System.out.println(id + " nolu veri bulunamadý");
			return Optional.ofNullable(null);
		}
	}

	@Override
	public Session databaseConnectionHibernate() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
