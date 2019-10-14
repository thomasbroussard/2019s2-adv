package fr.epita.quiz.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class DAO<T> {

	@Inject
	SessionFactory sf;

	public void create(T t) {
		Session session = getSession();
		session.save(t);

	}

	protected Session getSession() {
		Session session = null;
		try {
			session = sf.getCurrentSession();
		} catch (Exception e) {
			session = sf.openSession();
		}
		return session;
	}

	public T getById(Serializable id, Class<T> clazz) {

		return getSession().get(clazz, id);
	}

	public void update(T t) {
		Session session = getSession();
		session.update(t);

	}

	public void delete(T t) {
		Session session = getSession();
		session.delete(t);
	}
	
	public abstract List<T> search(T criteria);
	
	
}
