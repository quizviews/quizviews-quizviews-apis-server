package com.viewquiz.backend.app.quiz.persitence.repository.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractRepository<T, ID extends Serializable> {

	protected abstract JpaRepository<T, ID> getJpaRepository();

	public T create(T entity) {
		return getJpaRepository().saveAndFlush(entity);
	}

	public T read(ID id) {
		return getJpaRepository().findOne(id);
	}

	public List<T> list() {
		return getJpaRepository().findAll();
	}

	public long count() {
		return getJpaRepository().count();
	}

	public T update(T entity) {
		return getJpaRepository().saveAndFlush(entity);
	}

	public void delete(ID id) {
		getJpaRepository().delete(id);
	}

}
