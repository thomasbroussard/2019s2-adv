package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Question;

public class QuestionDAO extends DAO<Question>{

	@Override
	protected String getQueryString() {
		return "from Question q where q.questionContent like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String,Object> map, Question question) {
		map.put("pContent", question.getQuestionContent());

	}



}
