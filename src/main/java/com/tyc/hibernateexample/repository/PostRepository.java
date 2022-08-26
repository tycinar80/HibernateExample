package com.tyc.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tyc.hibernateexample.entity.Post;
import com.tyc.hibernateexample.utility.HibernateUtils;

public class PostRepository implements ICrud<Post> {
	private Session session;
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private Transaction transaction;

	public PostRepository() {
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
	public boolean save(Post t) {
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
	public boolean update(Post t, long id) {
		Optional<Post> post = FindById(id);
		try {
			if (post.isPresent()) {
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
			} else {
				System.out.println(id + "'li veri bulunamadý");
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean delete(long id) {
//		Optional<Post> post = 
		try {
			openSession();
			session.delete(FindById(id));
			closeSucces();
			return true;
		} catch (Exception e) {
			closeError();
			return false;
		}
	}

	@Override
	public List<Post> findAll() {
		CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
		Root<Post> root = criteriaQuery.from(Post.class);
		criteriaQuery.select(root);

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Optional<Post> FindById(long id) {
		CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
		Root<Post> root = criteriaQuery.from(Post.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));

		try {
			return Optional.ofNullable(entityManager.createQuery(criteriaQuery).getSingleResult());
		} catch (Exception e) {
			System.out.println(id + " nolu veri bulunamadý");
			return null;
		}
	}

	@Override
	public Session databaseConnectionHibernate() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	@Override
	public Post findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
