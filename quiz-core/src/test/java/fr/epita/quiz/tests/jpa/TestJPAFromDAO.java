package fr.epita.quiz.tests.jpa;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.DAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJPAFromDAO {
	
	
	@Inject
	DAO questionDAO;
	
	@Test
	public void testCreate() {
		
		Question question = new Question("What is Dependency Injection ?");
		
		//QuestionDAO questionDAO = new QuestionDAO();
		questionDAO.create(question);
		
		
		
		
		
	}
	
	

}
