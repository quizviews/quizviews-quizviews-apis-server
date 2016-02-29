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

import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.Test;
import com.viewquiz.backend.app.quiz.service.QuestionService;
import com.viewquiz.backend.app.quiz.service.TestService;
import com.viewquiz.backend.app.quiz.web.controller.exception.ResourceNotFoundException;

@RequestMapping(value = "api/tests/{idTest}/questions")
@RestController
public class QuestionController {

	private QuestionService questionService;
	private TestService testService;
	
	@Autowired
	public QuestionController(TestService testService, QuestionService questionService) {
		this.testService = testService;
		this.questionService = questionService;
	}
	// @Autowired
	// private AnswerService answerService;

	// the body should have a Question json parsed
	// , consumes = MediaType.APPLICATION_JSON_VALUE
	// @RequestMapping(value = "/questions", method = RequestMethod.POST,
	// consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	//
//	http://stackoverflow.com/questions/29266971/mixed-post-submit-from-angularjs-to-spring-restcontroller
//	http://javahonk.com/angularjs-form-post-spring-mvc-json/
//	http://stackoverflow.com/questions/29793022/return-json-from-spring-controller-after-uploading-file-via-angularjs
//	http://websystique.com/spring-4-mvc-tutorial/
//	http://stackoverflow.com/questions/29793022/return-json-from-spring-controller-after-uploading-file-via-angularjs
//	http://uncorkedstudios.com/blog/multipartformdata-file-upload-with-angularjs
//	http://websystique.com/springmvc/spring-mvc-4-angularjs-example/
//	http://websystique.com/category/springmvc/
//	https://murygin.wordpress.com/2014/10/13/rest-web-service-file-uploads-spring-boot/
//	http://g00glen00b.be/prototyping-spring-boot-angularjs/
//	http://www.concretepage.com/spring-4/spring-4-mvc-single-multiple-file-upload-example-with-tomcat
//	http://websystique.com/springmvc/spring-mvc-4-file-upload-example-using-commons-fileupload/
//	https://spring.io/blog/2015/08/19/migrating-a-spring-web-mvc-application-from-jsp-to-angularjs
//	https://spring.io/blog/2015/01/12/spring-and-angular-js-a-secure-single-page-application
//	https://www.youtube.com/watch?v=fE2Bg55i8AI
//	https://egghead.io/lessons/angularjs-file-uploads
//http://stackoverflow.com/questions/27294838/how-to-process-a-multipart-request-consisting-of-a-file-and-a-json-object-in-spr
//	http://shazwazza.com/post/uploading-files-and-json-data-in-the-same-request-with-angular-js/
//	http://www.devbattles.com/en/sand/post-1123-Uploading+files+and+JSON+data+in+the+same+request+with+Angular+JS
//	, @RequestParam(value="file", required=false) MultipartFile file
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@PathVariable int idTest, @RequestBody Question question) {
		verifyTestExist(idTest);
		
		Test test = testService.read(idTest);
		question.setTest(test);
		question = questionService.create(question);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newQuestionUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getIdQuestion()).toUri();
		responseHeaders.setLocation(newQuestionUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	/**
	 * qcu /questions/1?idAnswer=2&answerText=choose%20the%20right%20answer
	 * 
	 * @param idQuestion
	 * @param questionJson
	 * @return
	 */
	@RequestMapping(value = "/{idQuestion}", method = RequestMethod.GET)
	public ResponseEntity<?> read(@PathVariable int idTest, @PathVariable int idQuestion) {
		verifyTestExist(idTest);
		verifyQuestionExist(idTest, idQuestion);
	
		Test test = testService.read(idTest);
		List<Question> questions = test.getQuestions();
		// if (questions == null) {
		// throw new ResourceNotFoundException(idQuestion);
		// }
		Optional<Question> question = questions.stream().filter(q -> {
			return q.getIdQuestion() == idQuestion;
		}).findFirst();
		// if (!question.isPresent())
		// throw new ResourceNotFoundException(idQuestion);
		return new ResponseEntity<>(question.get(), HttpStatus.OK);
	}

	

	// @JsonView(View.Summary.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Question>> list(@PathVariable int idTest) {
		verifyTestExist(idTest);
	
		Test test = testService.read(idTest);
		List<Question> questions = test.getQuestions();
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@RequestMapping(value = "/{idQuestion}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable int idTest, @PathVariable int idQuestion, @RequestBody Question newQuestion) {
		verifyTestExist(idTest);
		verifyQuestionExist(idTest, idQuestion);
		Test test = testService.read(idTest);
		List<Question> questions = test.getQuestions();
	 
		Optional<Question> questionToUpdate = questions.stream().filter(q -> {
			return q.getIdQuestion() == idQuestion;
		}).findFirst();

		Question questionUpdated = questionService.update(questionToUpdate.get(), newQuestion);

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/{idQuestion}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable int idTest, @PathVariable int idQuestion) {
		verifyTestExist(idTest);
		verifyQuestionExist(idTest, idQuestion);
//		Test test = testService.read(idTest);

//		List<Question> questions = test.getQuestions();
//		Optional<Question> questionToUpdate = questions.stream().filter(q -> {
//			return q.getIdQuestion() == idQuestion;
//		}).findFirst();

		questionService.delete(idQuestion);
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
	

	// @RequestMapping(value = "/questions", method = RequestMethod.POST)
	// public ResponseEntity<?> correctAnswer(@RequestBody Question question) {
	// String typeQuestion = question.getTypeQuestion();
	// if (answer != null) {
	// switch (typeQuestion) {
	// // /questions/1?idAnswer=3
	// case QuestionType.QuestionChoixUnique_TYPE:
	// boolean isRighAnswer = answerService.isCorrectAnswer_QCU(answer);
	// ResultQuestion body = new ResultQuestion(isRighAnswer);
	// return new ResponseEntity<ResultQuestion>(body, HttpStatus.OK);
	//
	// // /questions/1?idAnswer=8?typeAnswer=qcm
	// case QuestionType.QuestionChoixMultiple_TYPE:
	// System.out.println("QuestionChoixMultiple_TYPE");
	// break;
	// case QuestionType.InputTextBased_TYPE:
	// System.out.println("InputTextBased_TYPE");
	// break;
	// case QuestionType.FillInTheBlanks_TYPE:
	// System.out.println("FillInTheBlanks_TYPE");
	// break;
	// case QuestionType.PutInTheRightOrder_TYPE:
	// System.out.println("PutInTheRightOrder_TYPE");
	// break;
	//
	// default:
	// System.out.println("!!!");
	// break;
	// }
	// return new ResponseEntity<>(question, HttpStatus.OK);
	// }
	//
	// }

	// @ExceptionHandler(ResourceNotFoundException.class)
	// public void handleTestNotFound(ResourceNotFoundException exception,
	// HttpServletResponse response) throws IOException {
	// response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	// }
}
