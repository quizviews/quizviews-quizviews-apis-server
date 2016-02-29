package com.viewquiz.backend.app.quiz.persitence.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

//import javax.validation.constraints.AssertTrue; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.viewquiz.backend.app.ViewQuizBackEndApplication;
import com.viewquiz.backend.app.quiz.persistence.model.Answer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ViewQuizBackEndApplication.class)
@WebAppConfiguration
public class AnswerPersistenceTests {

	@Autowired
	private AnswerJpaRepository answerJpaRepository;
	@Autowired
	private AnswerRepository answerRepository;


 	@Test
	public void testGetAnswers() {
		List<Answer> answers = answerRepository.list();
		System.out.println(answers);
		assertTrue("list not empty " + answers.toString(), answers.size() > 0);
	}



}
