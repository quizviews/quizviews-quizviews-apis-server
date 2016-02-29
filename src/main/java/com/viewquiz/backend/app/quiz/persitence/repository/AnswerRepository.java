package com.viewquiz.backend.app.quiz.persitence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.Answer;

@Repository
public class AnswerRepository   {

	
	@Autowired
	AnswerJpaRepository answerJpaRepository;
	
	public Answer create(Answer answer) {
		answerJpaRepository.saveAndFlush(answer);
		return answer;
	}
	
	public Answer read(int id) {
		return answerJpaRepository.findOne(id);
	}
	
	public List<Answer> list() {
		return answerJpaRepository.findAll();
	}

	public Answer update(Answer answer) {
		answerJpaRepository.saveAndFlush(answer);
		return answer;
	}
	
	public void delete(Answer answer) {
		answerJpaRepository.delete(answer);;
	}
	 
}
