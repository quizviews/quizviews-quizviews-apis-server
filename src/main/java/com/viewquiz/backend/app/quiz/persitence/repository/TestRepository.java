package com.viewquiz.backend.app.quiz.persitence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.Test;

@Repository
public class TestRepository {

	@Autowired
	TestJpaRepository testJpaRepository;

	public Test read(int id) {
		// return entityManager.find(Image.class, id);
		return testJpaRepository.findOne(id);
	}

	public void delete(Test test) {
		testJpaRepository.delete(test);
	}

	public List<Test> getAll(Pageable pageable) {
//		return testJpaRepository.findAll();
//		return testJpaRepository.findAll();
		return testJpaRepository.queryAllTestsByPage(pageable);
	}

	public Test create(Test test) {
		// entityManager.persist(image);
		// entityManager.flush();
		testJpaRepository.saveAndFlush(test);
		return test;
	}

	public Test update(Test test) {
		// image = entityManager.merge(image);
		// entityManager.flush();
		testJpaRepository.saveAndFlush(test);
		return test;
	}

}
