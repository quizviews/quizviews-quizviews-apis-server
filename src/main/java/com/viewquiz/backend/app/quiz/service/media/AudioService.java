//package com.viewquiz.backend.app.quiz.service.media;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.viewquiz.backend.app.quiz.persistence.model.media.Audio;
//import com.viewquiz.backend.app.quiz.persitence.repository.media.AudioRepository;
//import com.viewquiz.backend.app.quiz.service.generic.AbstractService;
//
//@Service
//public class AudioService extends AbstractService<AudioRepository, Audio, Integer> {
//
//	private AudioRepository audioRepository;
//
//	@Autowired
//	public AudioService(AudioRepository audioRepository) {
//		this.audioRepository = audioRepository;
//	}
//
//	@Override
//	protected AudioRepository getRepository() {
//		return this.audioRepository;
//	}
//
////	public Audio saveAudio(Audio audio) {
////		return audioRepository.create(audio);
////	}
//
////	public Audio getAudiosById(int idAudio) {
////		return audioRepository.read(idAudio);
////	}
////
////	public List<Audio> getAllAudio() {
////		return audioRepository.list();
////	}
//
////	public Audio uppdateAudio(int idAudio, Audio audio) {
////		Audio audioToUpdate = audioRepository.read(idAudio);
////		if (audioToUpdate != null) {
////			audioToUpdate.setNameAudio(audio.getNameAudio());
////		}
////		return audioRepository.update(audio);
////	}
////
////	public void deleteAudio(int id) {
////		audioRepository.delete(id);
////	}
//
//}
