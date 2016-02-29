package com.viewquiz.backend.app.quiz.service.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {
	@Autowired
	private JpaRepository<T, ID> repository;

	protected Class<T> entityClass;

	public List<T> findAll() {
		return repository.findAll();
	}
}
