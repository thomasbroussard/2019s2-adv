package fr.epita.quiz.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionDAO;

@Path("/questions/")

public class QuestionResource {
	
	
	@Inject
	QuestionDAO dao;
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody Question question) throws URISyntaxException {
		//create a question 
		dao.create(question);
		System.out.println("received creation order for question : " +  question);
		return Response.created(new URI("questions/"  + String.valueOf(question.getId()))).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById(@PathParam("id") int id) {
		//create a question 
		
		Question question = dao.getById(id, Question.class);
		
		return Response.ok(question).build();
	}

	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuestions(@QueryParam("qContent") String questionContent) {
		//create a question 
		List<Question> searchList = dao.search(new Question(questionContent));
		return Response.ok(searchList).build();
	}
	

}
