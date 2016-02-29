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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.viewquiz.backend.app.quiz.persistence.model.Answer;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.util.CustomDateDerializer;

/**
 * The persistent class for the audios database table.
 * 
 */
@Entity
@Table(name = "audios")
@NamedQuery(name = "Audio.findAll", query = "SELECT a FROM Audio a")
public class Audio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_audio")
	private int idAudio;

	@JsonDeserialize(using = CustomDateDerializer.class)
	@Column(name = "horodatage_audio")
	private Timestamp horodatageAudio;
	
	@Column(name = "name_audio")
	private String nameAudio;

	@Lob
	@Column(name = "uri_audio")
	private String uriAudio;

	@Lob
	@Column(name = "url_audio")
	private String urlAudio;

	@Column(name = "length_audio")
	private int lengthAudio;


	@JsonIgnore
	// @JsonBackReference
	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "audio")
	private List<Answer> answers;

	@JsonIgnore
	// @JsonBackReference
	// bi-directional many-to-one association to Question
	@OneToMany(mappedBy = "audio")
	private List<Question> questions;
	
	/*constructor */
	
	public Audio() {
	}

	/*fields getters and setters*/
	
	public Timestamp getHorodatageAudio() {
		return this.horodatageAudio;
	}

	public void setHorodatageAudio(Timestamp horodatageAudio) {
		this.horodatageAudio = horodatageAudio;
	}

	
	public int getIdAudio() {
		return this.idAudio;
	}

	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
	}

		
	public String getNameAudio() {
		return this.nameAudio;
	}

	public void setNameAudio(String nameAudio) {
		this.nameAudio = nameAudio;
	}
	public int getLengthAudio() {
		return this.lengthAudio;
	}

	public void setLengthAudio(int lengthAudio) {
		this.lengthAudio = lengthAudio;
	}



	public String getUriAudio() {
		return this.uriAudio;
	}

	public void setUriAudio(String uriAudio) {
		this.uriAudio = uriAudio;
	}

	public String getUrlAudio() {
		return this.urlAudio;
	}

	public void setUrlAudio(String urlAudio) {
		this.urlAudio = urlAudio;
	}

	/*Relations*/
	
	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setAudio(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setAudio(null);

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
		question.setAudio(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setAudio(null);

		return question;
	}
	

}