package com.viewquiz.backend.app.quiz.persitence.repository.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.media.Video;
import com.viewquiz.backend.app.quiz.persitence.repository.generic.AbstractRepository;

@Repository
//public class VideoRepository extends AbstractRepository<Video, Integer> {
public class VideoRepository  {

	private VideoJpaRepository videoJpaRepository;

	@Autowired
	public VideoRepository(VideoJpaRepository videoJpaRepository) {
		this.videoJpaRepository = videoJpaRepository;
	}

//	 @Override
//	protected JpaRepository<Video, Integer> getJpaRepository() {
//		return videoJpaRepository;
//	}
	public Video create(Video video) {
		videoJpaRepository.saveAndFlush(video);
		return video;
	}

	public Video read(int id) {
		return videoJpaRepository.findOne(id);
	}


	public List<Video> getAll() {
		return videoJpaRepository.findAll();
	}


	public Video update(Video video) {
		videoJpaRepository.saveAndFlush(video);
		return video;
	}
	public void delete(int idVideo) {
		videoJpaRepository.delete(idVideo);
	}

}
