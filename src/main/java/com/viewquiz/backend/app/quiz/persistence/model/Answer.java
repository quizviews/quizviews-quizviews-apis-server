package com.viewquiz.backend.app.quiz.persistence.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.viewquiz.backend.app.quiz.persistence.model.media.Audio;
import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persistence.model.media.Text;
import com.viewquiz.backend.app.quiz.persistence.model.media.Video;
import com.viewquiz.backend.app.quiz.persistence.model.util.CustomDateDerializer;

/**
 * The persistent class for the answers database table.
 * 
 */
@Entity
@Table(name = "answers")
@NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_answer")
	private int idAnswer;

	@JsonDeserialize(using = CustomDateDerializer.class)
	@Column(name = "horodatage_creation")
	private Timestamp horodatageCreation;

	// @Lob
	// @Column(name="answer_text")
	// private String answerText;

	@Column(name = "is_right_answer")
	private boolean isRightAnswer;

	@Column(name = "ordre_answer")
	private int ordreAnswer;

	@JsonIgnore
	// @JsonBackReference
	// @JsonManagedReference
	// bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question;

	// @JsonManagedReference
	// bi-directional many-to-one association to Text
	@ManyToOne
	@JoinColumn(name = "id_text")
	private Text text;

	// @JsonManagedReference
	// bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name = "id_image")
	private Image image;

	// @JsonManagedReference
	// bi-directional many-to-one association to Audio
	@ManyToOne
	@JoinColumn(name = "id_audio")
	private Audio audio;

	// @JsonManagedReference
	// bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name = "id_video")
	private Video video;

	/*constructors*/
	
	public Answer() {
	}

	/*fields getters and setters*/
	
	public Timestamp getHorodatageCreation() {
		return this.horodatageCreation;
	}

	public void setHorodatageCreation(Timestamp horodatageCreation) {
		this.horodatageCreation = horodatageCreation;
	}

	
	public int getIdAnswer() {
		return this.idAnswer;
	}

	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}


	public boolean getIsRightAnswer() {
		return this.isRightAnswer;
	}

	public void setIsRightAnswer(boolean isRightAnswer) {
		this.isRightAnswer = isRightAnswer;
	}

	public int getOrdreAnswer() {
		return this.ordreAnswer;
	}

	public void setOrdreAnswer(int ordreAnswer) {
		this.ordreAnswer = ordreAnswer;
	}

	/*Relations*/
	
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Text getText() {
		return this.text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Audio getAudio() {
		return this.audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Answer [idAnswer=" + idAnswer + ", horodatageCreation=" + horodatageCreation + ", isRightAnswer=" + isRightAnswer + ", ordreAnswer=" + ordreAnswer + ", video=" + video + ", image=" + image + ", audio=" + audio + "]";
	}

}