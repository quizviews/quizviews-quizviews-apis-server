package com.viewquiz.backend.app.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewquiz.backend.app.quiz.persistence.model.Answer;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.media.Audio;
import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persistence.model.media.Text;
import com.viewquiz.backend.app.quiz.persistence.model.media.Video;
import com.viewquiz.backend.app.quiz.persitence.repository.AnswerRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.QuestionRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.AudioRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.ImageRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.TextRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.VideoRepository;

@Service
public class AnswerService {

	private AnswerRepository answerRepository;
	private TextRepository textRepository;
	private ImageRepository imageRepository;
	private AudioRepository audioRepository;
	private VideoRepository videoRepository;

	@Autowired
	public AnswerService(AnswerRepository answerRepository, TextRepository textRepository, ImageRepository imageRepository, AudioRepository audioRepository, VideoRepository videoRepository) {
		this.answerRepository = answerRepository;
		this.textRepository = textRepository;
		this.imageRepository = imageRepository;
		this.audioRepository = audioRepository;
		this.videoRepository = videoRepository;
	}

	public Answer create(Answer answer) {
		Text text = answer.getText();
		if (text != null) {
			textRepository.create(text);
		}
		Image image = answer.getImage();
		if (image != null) {
			imageRepository.create(image);
		}
		Audio audio = answer.getAudio();
		if (audio != null) {
			audioRepository.create(audio);
		}

		Video video = answer.getVideo();
		if (video != null) {
			videoRepository.create(video);
		}

		return answerRepository.create(answer);
	}

	public Answer read(int answerId) {
		return answerRepository.read(answerId);
	}

	public List<Answer> list() {
		return answerRepository.list();
	}

	public Answer update(Answer answerToUpdate, Answer newAnswer) {
		Text newText = newAnswer.getText();
		Text textToUpdate = answerToUpdate.getText();

		if (newText != null) {
			textToUpdate = updateText(textToUpdate, newText);
			textToUpdate = textRepository.update(textToUpdate);
		}

		Image newImage = newAnswer.getImage();
		Image imageToUpdate = newAnswer.getImage();
		if (newImage != null) {
			imageToUpdate = updateImage(imageToUpdate, newImage);
			imageToUpdate = imageRepository.update(imageToUpdate);
		}

		Audio newAudio = newAnswer.getAudio();
		Audio audioToUpdate = answerToUpdate.getAudio();
		if (newAudio != null) {
			audioToUpdate = updateAudio(audioToUpdate, newAudio);
			audioToUpdate = audioRepository.update(audioToUpdate);
		}

		Video newVideo = newAnswer.getVideo();
		Video videoToUpdate = answerToUpdate.getVideo();
		if (newVideo != null) {
			videoToUpdate = updateVideo(videoToUpdate, newVideo);
			videoToUpdate = videoRepository.update(videoToUpdate);
		}

		answerToUpdate = updateAnswer(answerToUpdate, newAnswer);
		answerToUpdate = answerRepository.update(answerToUpdate);

		return answerToUpdate;
	}

	public void delete(int idAnswer) {
		Answer answer = answerRepository.read(idAnswer);
		answerRepository.delete(answer);
	}

	private Answer updateAnswer(Answer answerToUpdate, Answer newAnswer) {
		if (newAnswer.getIdAnswer() != 0) {
			answerToUpdate.setIdAnswer(newAnswer.getIdAnswer());
		}
		if (newAnswer.getIsRightAnswer() != false) {
			answerToUpdate.setIsRightAnswer(newAnswer.getIsRightAnswer());
		}

		return answerToUpdate;
	}

	private Text updateText(Text textToUpdate, Text newText) {
		if (newText.getSimpleText() != null) {
			textToUpdate.setSimpleText(newText.getSimpleText());
		}
		if (newText.getHtmlText() != null) {
			textToUpdate.setHtmlText(newText.getHtmlText());
		}
		return textToUpdate;
	}

	private Image updateImage(Image imageToUpdate, Image newImage) {
		if (imageToUpdate.getNameImage() != null) {
			imageToUpdate.setNameImage(newImage.getNameImage());
		}
		if (imageToUpdate.getUriImage() != null) {
			imageToUpdate.setUriImage(newImage.getUriImage());
		}
		if (imageToUpdate.getUrlImage() != null) {
			imageToUpdate.setUrlImage(newImage.getUrlImage());
		}

		return imageToUpdate;
	}

	private Audio updateAudio(Audio audioToUpdate, Audio newAudio) {
		if (audioToUpdate.getNameAudio() != null) {
			audioToUpdate.setNameAudio(newAudio.getNameAudio());
		}
		if (audioToUpdate.getUriAudio() != null) {
			audioToUpdate.setUriAudio(newAudio.getUriAudio());
		}
		if (audioToUpdate.getUrlAudio() != null) {
			audioToUpdate.setUrlAudio(newAudio.getUrlAudio());
		}

		return audioToUpdate;
	}

	private Video updateVideo(Video videoToUpdate, Video newVideo) {
		if (videoToUpdate.getNameVideo() != null) {
			videoToUpdate.setNameVideo(newVideo.getNameVideo());
		}
		if (videoToUpdate.getUriVideo() != null) {
			videoToUpdate.setUriVideo(newVideo.getUriVideo());
		}
		if (videoToUpdate.getUrlVideo() != null) {
			videoToUpdate.setUrlVideo(newVideo.getUrlVideo());
		}
		return videoToUpdate;
	}

	// public List<Answer> getAnswersOfQuestion(int questionId) {
	// return questionRepository.getAnswersOfQuestionId(questionId);
	// }

	// public boolean isCorrectAnswer_QCU(Answer answer) {
	// Answer answerById = this.read(answer.getIdAnswer());
	// // if (answerById != null) {
	// // if (answerById.getIsRightAnswer() == 1) {
	// // return true;
	// // }
	// // }
	// return false;
	// }

}