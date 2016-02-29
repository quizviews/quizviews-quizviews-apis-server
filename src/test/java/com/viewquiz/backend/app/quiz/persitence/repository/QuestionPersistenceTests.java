package com.viewquiz.backend.app.quiz.persitence.repository;

//import javax.validation.constraints.AssertTrue; 

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.viewquiz.backend.app.ViewQuizBackEndApplication;
import com.viewquiz.backend.app.quiz.persistence.model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ViewQuizBackEndApplication.class)
@WebAppConfiguration
public class QuestionPersistenceTests {
	
	@Autowired
	private QuestionJpaRepository questionJpaRepository;


	@Test
	public void testGetAllQuestion() {
		
		int allQuestionsSize = questionJpaRepository.findAll().size();
		System.out.println(allQuestionsSize);
		assertNotEquals(allQuestionsSize, 1);
	}
	
}
