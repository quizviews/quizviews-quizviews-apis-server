package com.viewquiz.backend.app.quiz.persitence.repository;

import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.Answer;
import com.viewquiz.backend.app.quiz.persistence.model.Question;

@Repository
public class QuestionRepository {

	@Autowired
	QuestionJpaRepository questionJpaRepository;

	public Question create(Question question) {

		return questionJpaRepository.saveAndFlush(question);
	}

	public Question read(int id) {
		Question findOne = questionJpaRepository.findOne(id);
		return findOne;
	}

	public List<Question> list() {
		return questionJpaRepository.findAll();
	}

	// public List<Answer> getAnswersOfQuestionId(int id) {
	// Question question = questionJpaRepository.findOne(id);
	// return question.getAnswers();
	// }

	public Question update(Question question) {

		return questionJpaRepository.saveAndFlush(question);
	}

	public void delete(int idQuestion) {
		questionJpaRepository.delete(idQuestion);
	}
}
