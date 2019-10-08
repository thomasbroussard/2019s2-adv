package fr.epita.quiz.services;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.quiz.datamodel.Question;

public class DAO<T> {

	@Inject
	SessionFactory sf;

	public void create(T t) {
		Session session = getSession();
		session.save(t);
	

	}

	private Session getSession() {
		Session session = null;
		try {
			session = sf.getCurrentSession();
		} catch (Exception e) {
			session = sf.openSession();
		}
		return session;
	}

}
