package com.viewquiz.backend.app.quiz.web.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viewquiz.backend.app.quiz.persistence.model.Answer;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.Test;
import com.viewquiz.backend.app.quiz.service.AnswerService;
import com.viewquiz.backend.app.quiz.service.QuestionService;
import com.viewquiz.backend.app.quiz.service.TestService;
import com.viewquiz.backend.app.quiz.web.controller.exception.ResourceNotFoundException;

@RequestMapping(value = "api/tests/{idTest}/questions/{idQuestion}/answers")
@RestController
public class AnswerController {

	private TestService testService;
	private QuestionService questionService;
	private AnswerService answerService;

	@Autowired
	public AnswerController(TestService testService, QuestionService questionService, AnswerService answerService) {
		this.testService = testService;
		this.questionService = questionService;

		this.answerService = answerService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@PathVariable int idTest, @PathVariable int idQuestion, @RequestBody Answer answer  ) {
		verifyTestExist(idTest);
		verifyQuestionExist(idTest, idQuestion);

		Question question = questionService.read(idQuestion);
		answer.setQuestion(question);
		answer = answerService.create(answer);

		HttpHeaders responseHeaders = new HttpHeaders();
		URI newAnswerUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(answer.getIdAnswer ()).toUri();
		responseHeaders.setLocation(newAnswerUri);
		return new ResponseEntity<>(null,responseHeaders , HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{idAnswer}", method = RequestMethod.GET)
	public ResponseEntity<?> read(@PathVariable int idTest, @PathVariable int idQuestion, @PathVariable int idAnswer) {
		verifyTestExist(idTest);
		verifyQuestionExist(idTest, idQuestion);
		verifyAnswerExist(idQuestion, idAnswer);

		Test test = testService.read(idTest);
		List<Question> questions = test.getQuestions();
		// if (questions == null) {
		// throw new ResourceNotFoundException(idQuestion);
		// }
		Optional<Question> question = questions.stream().filter(q -> {
			return q.getIdQuestion() == idQuestion;
		}).findFirst();

		List<Answer> answers = question.get().getAnswers();

		Optional<Answer> answer = answers.stream().filter(a -> {
			return a.getIdAnswer() == idAnswer;
		}).findFirst();

		// if (!question.isPresent())
		// throw new ResourceNotFoundException(idQuestion);
		return new ResponseEntity<>(answer.get(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Answer>> list(@PathVariable int idTest, @PathVariable int idQuestion) {
		verifyTestExist(idTest);
		verifyQuestionExist(idTest, idQuestion);

		Test test = testService.read(idTest);
		List<Question> questions = test.getQuestions();
		Optional<Question> question = questions.stream().filter(q -> {
			return q.getIdQuestion() == idQuestion;
		}).findFirst();

		return new ResponseEntity<>(question.get().getAnswers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idAnswer}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable int idTest, @PathVariable int idQuestion, @PathVariable int idAnswer, @RequestBody Answer newAnswer) {
		verifyTestExist(idTest);
		verifyQuestionExist(idTest, idQuestion);
		verifyAnswerExist(idQuestion, idAnswer);

		Test test = testService.read(idTest);
		List<Question> questions = test.getQuestions();

		Question questionToUpdate = questions.stream().filter(q -> {
			return q.getIdQuestion() == idQuestion;
		}).findFirst().get();

		List<Answer> answers = questionToUpdate.getAnswers();
		Answer answer =answers.stream().filter(q -> {
			return q.getIdAnswer() == idAnswer;
		}).findFirst().get();
		// Question questionUpdated =
		// questionService.update(questionToUpdate.get(), newQuestion);

		Answer answerUpdated = answerService.update(answer , newAnswer);

		 
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/{idAnswer}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable int idTest, @PathVariable int idQuestion, @PathVariable int idAnswer) {
		verifyTestExist(idTest);
		verifyQuestionExist(idTest, idQuestion);
		verifyAnswerExist(idQuestion, idAnswer);

		answerService.delete(idAnswer);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	public void verifyTestExist(int idTest) {
		Test test = testService.read(idTest);
		if (test == null) {
			// throw new TestNotFoundException(idTest);
			throw new ResourceNotFoundException(idTest);
		}
	}

	public void verifyQuestionExist(int idTest, int idQuestion) {
		Test test = testService.read(idTest);
		List<Question> questions = test.getQuestions();
		if (questions == null) {
			throw new ResourceNotFoundException(idQuestion);
		}
		Optional<Question> question = questions.stream().filter(q -> {
			return q.getIdQuestion() == idQuestion;
		}).findFirst();
		if (!question.isPresent())
			throw new ResourceNotFoundException(idQuestion);
	}

	public void verifyAnswerExist(int idQuestion, int idAnswer) {

		Question question = questionService.read(idQuestion);
		List<Answer> answers = question.getAnswers();
		if (answers == null) {
			throw new ResourceNotFoundException(idAnswer);
		}
		Optional<Answer> answer = answers.stream().filter(a -> {
			return a.getIdAnswer() == idAnswer;
		}).findFirst();
		if (!answer.isPresent()) {
			throw new ResourceNotFoundException(idQuestion);
		}

	}

}
