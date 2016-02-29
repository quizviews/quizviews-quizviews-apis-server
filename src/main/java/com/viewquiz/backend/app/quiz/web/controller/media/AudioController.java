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
//import com.viewquiz.backend.app.quiz.persistence.model.media.Audio;
//import com.viewquiz.backend.app.quiz.service.media.AudioService;
//
//@RestController
//public class AudioController {
//
//	@Autowired
//	private AudioService audioService;
//
//	// http://localhost:8080/audios
//	@RequestMapping("/audios")
//	public ResponseEntity<List<Audio>> listAll() {
//
//		List<Audio> audios = audioService.list();
//
//		return new ResponseEntity<>(audios, HttpStatus.OK);
//	}
//
//	// http://localhost:8080/images/1
//	@RequestMapping("/audios/{idAudio}")
//	public ResponseEntity<Audio> listAudiosById(@PathVariable int idAudio) {
//		Audio audio = audioService.read(idAudio);
//		return new ResponseEntity<>(audio, HttpStatus.OK);
//	}
//
//	// HttpClient HeadRequest should add Content-Type:application/json
//	// the body should have a Question json parsed
//	@RequestMapping(value = "/audios", method = RequestMethod.POST)
//	public ResponseEntity<?> createAudio(@RequestBody Audio audio) {
//		audio = audioService.create(audio);
//		HttpHeaders responseHeaders = new HttpHeaders();
//		URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(audio.getIdAudio()).toUri();
//		responseHeaders.setLocation(newPollUri);
//		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
//	}
//
//	// HttpClient HeadRequest should add Content-Type:application/json
//	// the body should have a Question json parsed
//	@RequestMapping(value = "/audios/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> updateAudio(@RequestBody Audio audio, @PathVariable int id) {
//		audioService.create(audio);
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/audios/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<?> deleteAudio(@PathVariable int id) {
//		audioService.delete(id);
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}
//}
