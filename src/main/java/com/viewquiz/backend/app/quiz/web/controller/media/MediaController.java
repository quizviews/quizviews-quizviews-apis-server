package com.viewquiz.backend.app.quiz.web.controller.media;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viewquiz.backend.app.Log;
import com.viewquiz.backend.app.quiz.persistence.model.Answer;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.Test;
import com.viewquiz.backend.app.quiz.service.AnswerService;
import com.viewquiz.backend.app.quiz.service.QuestionService;
import com.viewquiz.backend.app.quiz.service.TestService;
import com.viewquiz.backend.app.quiz.web.controller.exception.ResourceNotFoundException;

@RequestMapping("/tests/{idTest}/{questions-answers}/{id-questions-answers}/{medias}")
@RestController
public class MediaController {
	/**
	 * this media controller should have the CRUD interface for every media type
	 * from any question/answers under a lesson given
	 */
	// http://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/

	private TestService testService;
	private AnswerService answerService;
	private QuestionService questionService;

	@Autowired
	public MediaController(TestService testService, QuestionService questionService, AnswerService answerService) {
		this.testService = testService;
		this.questionService = questionService;
		this.answerService = answerService;
	}

	void create() {

	}

	void read() {

	}

	@RequestMapping(method = RequestMethod.GET)
	void list(@PathVariable("idTest") int idTest, @PathVariable("questions-answers") String questions_answers, @PathVariable("id-questions-answers") int id_questions_answers) {
		Log.I(idTest + " " + questions_answers + " " + id_questions_answers);
		Test test = testService.read(idTest);
		if (test == null) {
			throw new ResourceNotFoundException(idTest);
		}
		switch (questions_answers) {
		case "questions":
			Question question = questionService.read(id_questions_answers);

			break;
		case "answers":
			Answer answer = answerService.read(id_questions_answers);

			break;

		default:
			throw new ResourceNotFoundException(idTest);
		}

	}

	void update() {

	}

	void delete() {

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public void handleTestNotFound(ResourceNotFoundException exception, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}
}
