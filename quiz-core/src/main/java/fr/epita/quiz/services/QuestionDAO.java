package fr.epita.quiz.services;

import java.util.List;

import org.hibernate.Session;

import fr.epita.quiz.datamodel.Question;

public class QuestionDAO extends DAO<Question>{

	@Override
	public List<Question> search(Question criteria) {
		Session session = getSession();
	}

}
