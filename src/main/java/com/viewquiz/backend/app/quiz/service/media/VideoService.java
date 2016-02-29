//package com.viewquiz.backend.app.quiz.service.media;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.viewquiz.backend.app.quiz.persistence.model.media.Video;
//import com.viewquiz.backend.app.quiz.persitence.repository.media.VideoRepository;
//import com.viewquiz.backend.app.quiz.service.generic.AbstractService;
//
//@Service
//public class VideoService extends AbstractService<VideoRepository, Video, Integer> {
//
//	private VideoRepository videoRepository;
//
//	@Autowired
//	public VideoService(VideoRepository videoRepository) {
//		this.videoRepository = videoRepository;
//	}
//
//	@Override
//	protected VideoRepository getRepository() {
//		return videoRepository;
//	}
//
//	// public List<Video> getAllVideo() {
//	//
//	// return videoRepository.getAll();
//	// }
//	//
//	// public Video saveVideo(Video video) {
//	//
//	// video = videoRepository.update(video);
//	// return video;
//	// }
//	//
//	// public void deleteVideo(int id) {
//	// Video video = videoRepository.find(id);
//	// videoRepository.delete(video);
//	// }
//	//
//	// public Video getVideosById(int idvideo) {
//	// Video video = videoRepository.find(idvideo);
//	// return video;
//	// }
//
//}
