package com.viewquiz.backend.app.quiz.persitence.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.Test;

@Repository
public interface TestJpaRepository extends JpaRepository<Test, Integer> {


	@Query(value = "select t from Test t ", nativeQuery = false)
	List<Test> queryAllTestsByPage(Pageable pageable);

}
