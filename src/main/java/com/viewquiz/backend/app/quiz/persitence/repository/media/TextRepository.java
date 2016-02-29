package com.viewquiz.backend.app.quiz.persitence.repository.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.media.Text;

@Repository
public class TextRepository {

	private TextJpaRepository textJpaRepository;

	@Autowired
	public TextRepository(TextJpaRepository textJpaRepository) {
		this.textJpaRepository = textJpaRepository;
	}

	public Text create(Text text) {
		// entityManager.persist(image);
		// entityManager.flush();
		textJpaRepository.saveAndFlush(text);
		return text;
	}

	public Text read(int id) {
		// return entityManager.find(Image.class, id);
		return textJpaRepository.findOne(id);
	}

	public List<Text> list() {
		return textJpaRepository.findAll();
		// return new ArrayList<Answer>();
	}

	public Text update(Text text) {
		// image = entityManager.merge(image);
		// entityManager.flush();
		textJpaRepository.saveAndFlush(text);
		return text;
	}

	public void delete(Text text) {
		textJpaRepository.delete(text);
	}

}
