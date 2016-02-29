package com.viewquiz.backend.app.quiz.persistence.model.media;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.viewquiz.backend.app.quiz.persistence.model.Answer;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.util.CustomDateDerializer;

/**
 * The persistent class for the videos database table.
 * 
 */
@Entity
@Table(name = "videos")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_video")
	private int idVideo;
	@JsonDeserialize(using = CustomDateDerializer.class)
	@Column(name = "horodatage_creation")
	private Timestamp horodatageCreation;

	@Column(name = "length_video")
	private int lengthVideo;

	@Column(name = "name_video")
	private String nameVideo;

	@Lob
	@Column(name = "uri_video")
	private String uriVideo;

	@Lob
	@Column(name = "url_video")
	private String urlVideo;
	@JsonIgnore
	// @JsonBackReference
	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "video")
	private List<Answer> answers;

	@JsonIgnore
	@JsonBackReference
	// bi-directional many-to-one association to Question
	@OneToMany(mappedBy = "video")
	private List<Question> questions;

	/* constructors */
	public Video() {
	}

	/* fields getters setters */
	public int getIdVideo() {
		return this.idVideo;
	}

	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}

	public Timestamp getHorodatageCreation() {
		return this.horodatageCreation;
	}

	public void setHorodatageCreation(Timestamp horodatageCreation) {
		this.horodatageCreation = horodatageCreation;
	}

	public int getLengthVideo() {
		return this.lengthVideo;
	}

	public void setLengthVideo(int lengthVideo) {
		this.lengthVideo = lengthVideo;
	}

	public String getNameVideo() {
		return this.nameVideo;
	}

	public void setNameVideo(String nameVideo) {
		this.nameVideo = nameVideo;
	}

	public String getUriVideo() {
		return this.uriVideo;
	}

	public void setUriVideo(String uriVideo) {
		this.uriVideo = uriVideo;
	}

	public String getUrlVideo() {
		return this.urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	/* relations */
	
	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setVideo(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setVideo(null);

		return answer;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setVideo(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setVideo(null);

		return question;
	}

}