package com.viewquiz.backend.app.quiz.web.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.viewquiz.backend.app.Log;
import com.viewquiz.backend.app.ViewQuizBackEndApplication;
import com.viewquiz.backend.app.quiz.persitence.repository.TestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ViewQuizBackEndApplication.class)
@WebAppConfiguration
// @TransactionConfiguration(transactionManager = "transactionManager",
// defaultRollback = true)
@Transactional
public class TestControllerTest {

	@Autowired
	private TestRepository testRepository;
	private final int ID = 1;
	private final String URL = "http://localhost:8080";

	@Test
	public void testListAllTests() {
		com.viewquiz.backend.app.quiz.persistence.model.Test storedTest = testRepository.read(ID);
		RestTemplate restTemplate = new RestTemplate();
		com.viewquiz.backend.app.quiz.persistence.model.Test parsedTest = restTemplate.getForObject(URL + "/tests/" + ID, com.viewquiz.backend.app.quiz.persistence.model.Test.class);
		// ResponseEntity<com.viewquiz.backend.app.quiz.persistence.model.Test>
		// parsedTestResponseEntity = restTemplate
		// .getForEntity(URL + "/tests/" + ID,
		// com.viewquiz.backend.app.quiz.persistence.model.Test.class);
		Log.I(parsedTest);
		Log.W(parsedTest);
		Log.E(parsedTest);
		assertEquals(parsedTest.getTitleTest(), storedTest.getTitleTest());
		// Log.I(parsedTestResponseEntity.getBody());
		// Log.W(parsedTestResponseEntity.getBody());
		// Log.E(parsedTestResponseEntity.getBody());
		// assertEquals(parsedTestResponseEntity.getBody(),
		// storedTest.getTitleTest());
	}
}
