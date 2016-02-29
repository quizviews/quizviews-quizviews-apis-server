//package com.viewquiz.backend.app.quiz.web.controller.media;
//
//import java.net.URI;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
//import com.viewquiz.backend.app.quiz.persistence.model.media.Video;
//import com.viewquiz.backend.app.quiz.service.media.VideoService;
//
//@RestController
//public class VideoController {
//
//	@Autowired
//	private VideoService videoService;
//
//	// http://localhost:8080/videos
//	@RequestMapping("/videos")
//	public ResponseEntity<List<Video>> listAll() {
//
//		List<Video> videos = videoService.list();
//
//		return new ResponseEntity<>(videos, HttpStatus.OK);
//	}
//
//	// http://localhost:8080/videos/1
//	@RequestMapping("/videos/{idVideo}")
//	public ResponseEntity<Video> listVideoById(@PathVariable int idVideo) {
//		Video video = videoService.read(idVideo);
//		return new ResponseEntity<>(video, HttpStatus.OK);
//	}
//
//	// HttpClient HeadRequest should add Content-Type:application/json
//	// the body should have a Question json parsed
//	@RequestMapping(value = "/videos", method = RequestMethod.POST)
//	public ResponseEntity<?> createImage(@RequestBody Video video) {
//		video = videoService.create(video);
//		HttpHeaders responseHeaders = new HttpHeaders();
//		URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(video.getIdVideo()).toUri();
//		responseHeaders.setLocation(newPollUri);
//		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
//	}
//
//	// HttpClient HeadRequest should add Content-Type:application/json
//	// the body should have a Question json parsed
//	@RequestMapping(value = "/videos/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> updateVideo(@RequestBody Video video, @PathVariable int id) {
//		videoService.update(id,video);
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/videos/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<?> deleteQuestion(@PathVariable int id) {
//		videoService.delete(id);
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}
//}
