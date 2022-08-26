package com.tyc.hibernateexample.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

public interface ICrud<T> {

	public boolean save(T t);

	public boolean update(T t, long id);

	public boolean delete(long id);

	public List<T> findAll();

	public Optional<T> FindById(long id);

	public T findById(long id);

	public Session databaseConnectionHibernate();
// JRE 1.8' de kullanýlabiliyor	
//	default Session databaseConnectionHibernate() { 
//		return HibernateUtils.getSessionFactory().openSession();
//	}
}
