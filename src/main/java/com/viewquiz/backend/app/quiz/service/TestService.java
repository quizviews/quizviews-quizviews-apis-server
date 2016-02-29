package com.viewquiz.backend.app.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viewquiz.backend.app.Log;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.Test;
import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persitence.repository.TestRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.ImageRepository;

@Service
public class TestService {

	private TestRepository testRepository;
	private QuestionService questionService;
	private ImageRepository imageRepository;

	@Autowired
	public TestService(TestRepository testRepository, QuestionService questionService,ImageRepository imageRepository) {
		this.testRepository = testRepository;
		this.questionService = questionService;
		this.imageRepository= imageRepository;
	}

	public Test create(Test test) {
//		imageRepository
		Image image = test.getImage();
		if (image!=null) {
			imageRepository.create(image);
		}
		List<Question> questions = test.getQuestions();
		// Log.E(questions);//null because @jsonIgnore List<Question>Questions
		if (questions != null) {
			questions.stream().forEach(q -> {
				questionService.create(q);
			});

		}
		// questions.stream().filter(q-> q!= null).forEach(q ->
		// questionService.create(q));
		test = testRepository.create(test);
		return test;
	}

	public Test read(int idTest) {
		Test test = testRepository.read(idTest);
		return test;
	}

	public List<Test> list(Pageable pageable) {
		return testRepository.getAll(pageable);
	}

	public Test update(Test testToUpdate, Test newTest) {
		if (newTest.getTitleTest()!= null) {
			testToUpdate.setTitleTest(newTest.getTitleTest());
		}
		return testRepository.update(testToUpdate);
	}

	public void delete(int id) {
		Test test = testRepository.read(id);
		testRepository.delete(test);
	}

}
