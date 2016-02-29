package com.viewquiz.backend.app.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.media.Audio;
import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persistence.model.media.Text;
import com.viewquiz.backend.app.quiz.persistence.model.media.Video;
import com.viewquiz.backend.app.quiz.persitence.repository.QuestionRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.AudioRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.ImageRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.TextRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.VideoRepository;

@Service
public class QuestionService {

	private QuestionRepository questionRepository;
	private TextRepository textRepository;
	private ImageRepository imageRepository;
	private AudioRepository audioRepository;
	private VideoRepository videoRepository;

	@Autowired
	public QuestionService(QuestionRepository questionRepository, TextRepository textRepository, ImageRepository imageRepository, AudioRepository audioRepository, VideoRepository videoRepository) {
		this.questionRepository = questionRepository;
		this.textRepository = textRepository;
		this.imageRepository = imageRepository;
		this.audioRepository = audioRepository;
		this.videoRepository = videoRepository;
	}

	public Question create(Question question) {
		// List<Answer> answers = question.getAnswers();
		Text text = question.getText();
		if (text != null) {
			textRepository.create(text);
		}
		Image image = question.getImage();
		if (image != null) {
			imageRepository.create(image);
		}
		Audio audio = question.getAudio();
		if (audio != null) {
			audioRepository.create(audio);
		}

		Video video = question.getVideo();
		if (video != null) {
			videoRepository.create(video);
		}
		return questionRepository.create(question);
	}

	public Question read(int idQuestion) {
		return questionRepository.read(idQuestion);
	}

	public List<Question> list() {
		return questionRepository.list();
	}

	public Question update(Question questionToUpdate, Question newQuestion) {
		Text newText = newQuestion.getText();
		Text textToUpdate = questionToUpdate.getText();

		if (newText != null) {
			textToUpdate = updateText(textToUpdate, newText);
			textToUpdate = textRepository.update(textToUpdate);
		}

		Image newImage = newQuestion.getImage();
		Image imageToUpdate = newQuestion.getImage();
		if (newImage != null) {
			imageToUpdate = updateImage(imageToUpdate, newImage);
			imageToUpdate = imageRepository.update(imageToUpdate);
		}

		Audio newAudio = newQuestion.getAudio();
		Audio audioToUpdate = questionToUpdate.getAudio();
		if (newAudio != null) {
			audioToUpdate = updateAudio(audioToUpdate, newAudio);
			audioToUpdate = audioRepository.update(audioToUpdate);
		}

		Video newVideo = newQuestion.getVideo();
		Video videoToUpdate = questionToUpdate.getVideo();
		if (newVideo != null) {
			videoToUpdate = updateVideo(videoToUpdate, newVideo);
			videoToUpdate = videoRepository.update(videoToUpdate);
		}

		questionToUpdate = updateQuestion(questionToUpdate, newQuestion);
		questionToUpdate = questionRepository.update(questionToUpdate);

		return questionToUpdate;
	}

	public void delete(int idQuestion) {
		questionRepository.delete(idQuestion);
	}

	private Question updateQuestion(Question questionToUpdate, Question newQuestion) {
		if (newQuestion.getTitleQuestion() != null) {
			questionToUpdate.setTitleQuestion(newQuestion.getTitleQuestion());
		}
		if (newQuestion.getTypeQuestion() != null) {
			questionToUpdate.setTypeQuestion(newQuestion.getTypeQuestion());
		}
		if (newQuestion.getTagQuestion() != null) {
			questionToUpdate.setTagQuestion(newQuestion.getTagQuestion());
		}
		if (newQuestion.getTextQuestion() != null) {
			questionToUpdate.setTextQuestion(newQuestion.getTextQuestion());
		}
		if (newQuestion.getTimerQuestion() != 0) {
			questionToUpdate.setTimerQuestion(newQuestion.getTimerQuestion());
		}
		return questionToUpdate;
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

	// public List<Answer> getAnswersOfQuestionId(int id) {
	// return questionRepository.getAnswersOfQuestionId(id);
	// }
}
