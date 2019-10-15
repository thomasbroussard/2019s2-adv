package fr.epita.quiz.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionDAO;

@Path("/questions")
public class QuestionResource {
	
	
	@Inject
	QuestionDAO dao;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestion(Question question) {
		//create a question 
		dao.create(question);
		
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById(int id) {
		//create a question 
		
		Question question = dao.getById(id, Question.class);
		
		return Response.ok(question).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuestions(@QueryParam("qContent") String questionContent) {
		//create a question 
	
		List<Question> searchList = dao.search(new Question(questionContent));
		
		return Response.ok(searchList).build();
	}
	
	
	

}
