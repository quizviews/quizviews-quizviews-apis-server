package com.viewquiz.backend.app.quiz.persitence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.Answer;

@Repository
public interface AnswerJpaRepository extends JpaRepository<Answer, Integer> {

	 

}
