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




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJPA {
	
	@Inject
	SessionFactory sessionFactory;
	
	@Test
	public void testHibernateSession() {
		//given sessionFactory
		
		//when
		Session session = sessionFactory.openSession();
		
		
		//then
		Assert.assertEquals(true,session.isConnected());
	}
	
	@Test
	public void testCreate() {
		//given sessionFactory
		String questionContent = "How to define a property in a maven pom file?";
		Question question = new Question(questionContent);
		
		//when
		Session session = sessionFactory.openSession();
		session.save(question);
		
		
		//then
		Question retrievedQuestion = session.get(Question.class, question.getId());
		Assert.assertEquals(questionContent,retrievedQuestion.getQuestionContent());
	}
	
	
	@Test
	public void testUpdate() {
		//given sessionFactory
		String questionContent = "How to define a property in a maven pom file?";
		String questionContentModified = "How to define a parent pom in maven?";
		Question question = new Question(questionContent);
		Session session = sessionFactory.openSession();
		session.save(question);
		
		//when
		question.setQuestionContent(questionContentModified);
		session.update(question);
		
		
		//then
		Question retrievedQuestion = session.get(Question.class, question.getId());
		Assert.assertEquals(questionContentModified,retrievedQuestion.getQuestionContent());
	}

}
