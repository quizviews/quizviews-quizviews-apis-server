package com.viewquiz.backend.app.quiz.service.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.viewquiz.backend.app.quiz.persitence.repository.generic.AbstractRepository;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class AbstractService<T extends AbstractRepository, Entity, ID extends Serializable> {

	protected abstract T getRepository();

	public Entity create(Entity entity) {
		return (Entity) getRepository().create(entity);
	}

	public Entity read(ID id) {
		return (Entity) getRepository().read(id);
	}

	public List<Entity> list() {
		return getRepository().list();
	}

	public Entity update(ID id, Entity entity) {
		Entity entityToUpdate = (Entity) getRepository().read(id);
		if (entityToUpdate != null) {
			BeanUtils.copyProperties(entity, entityToUpdate);
		}
		return (Entity) getRepository().update(entityToUpdate);
	}

	public long count() {
		return getRepository().count();
	}

	public void delete(ID id) {
		getRepository().delete(id);
	}

}
