package com.viewquiz.backend.app.quiz.persitence.repository.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.media.Audio;
import com.viewquiz.backend.app.quiz.persitence.repository.generic.AbstractRepository;

@Repository
// public class AudioRepository extends AbstractRepository<Audio, Integer> {
public class AudioRepository {

	private AudioJpaRepository audioJpaRepository;

	@Autowired
	public AudioRepository(AudioJpaRepository audioJpaRepository) {
		this.audioJpaRepository = audioJpaRepository;
	}

	// @Override
	// protected JpaRepository<Audio, Integer> getJpaRepository() {
	// return audioJpaRepository;
	// }
	public Audio create(Audio audio) {
		audioJpaRepository.saveAndFlush(audio);
		return audio;
	}

	public Audio read(int id) {
		return audioJpaRepository.findOne(id);
	}

	public List<Audio> list() {
		return audioJpaRepository.findAll();
	}

	public Audio update(Audio audio) {
		audioJpaRepository.saveAndFlush(audio);
		return audio;
	}

	public void delete(int idAudio) {
		audioJpaRepository.delete(idAudio);
	}
}
