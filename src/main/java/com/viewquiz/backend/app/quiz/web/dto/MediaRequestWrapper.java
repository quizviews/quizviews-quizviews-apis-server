package com.viewquiz.backend.app.quiz.web.dto;

import java.util.List;

import com.viewquiz.backend.app.quiz.persistence.model.media.Audio;
import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persistence.model.media.Text;
import com.viewquiz.backend.app.quiz.persistence.model.media.Video;

public class MediaRequestWrapper {

	List<Text> texts;
	List<Image> images;
	List<Audio> audios;
	List<Video> videos;

	public List<Text> getTexts() {
		return texts;
	}

	public void setTexts(List<Text> texts) {
		this.texts = texts;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Audio> getAudios() {
		return audios;
	}

	public void setAudios(List<Audio> audios) {
		this.audios = audios;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

}
