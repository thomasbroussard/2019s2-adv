package fr.epita.quiz.tests.jpa;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJPAFromDAO {
	
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	SessionFactory sf;
	
	@Test
	public void testCreate() {
		
		//test
		//given
		Question question = new Question("What is Dependency Injection ?");
		
		//QuestionDAO questionDAO = new QuestionDAO();
		//when
		questionDAO.create(question);
		
		
		//then
		Session session = sf.openSession();
		Assert.assertNotNull(session.get(Question.class, question.getId()));
		
		
		
	}
	
	

}
