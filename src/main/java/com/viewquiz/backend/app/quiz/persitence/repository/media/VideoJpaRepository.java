package com.viewquiz.backend.app.quiz.persitence.repository.media;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.media.Video;

@Repository
public interface VideoJpaRepository extends JpaRepository<Video, Integer> {

}
