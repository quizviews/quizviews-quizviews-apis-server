package com.viewquiz.backend.app.quiz.persistence.model.media;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.viewquiz.backend.app.quiz.persistence.model.Answer;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.util.CustomDateDerializer;

/**
 * The persistent class for the texts database table.
 * 
 */

@Entity
@Table(name = "texts")

public class Text implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_text")
	private int idText;

	@JsonDeserialize(using = CustomDateDerializer.class)
	@Column(name = "created_at")
	public Date createdAt;

	@JsonDeserialize(using = CustomDateDerializer.class)
	@Column(name = "updated_at")
	public Date updatedAt;

	@Lob
	@Column(name = "simple_text", columnDefinition = "LONGTEXT")
	private String simpleText;

	@Lob
	@Column(name = "html_text", columnDefinition = "LONGTEXT")
	private String htmlText;

	@JsonIgnore
	// @JsonBackReference
	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "text")
	private List<Answer> answers;

	@JsonIgnore
	// @JsonBackReference
	// bi-directional many-to-one association to Question
	@OneToMany(mappedBy = "text")
	private List<Question> questions;

	/* constructor */

	public Text() {
	}

	public Text(Text newText) {
		if (newText.getHtmlText() != null) {
			setHtmlText(newText.getHtmlText());
		}
		if (newText.getSimpleText() != null) {
			setSimpleText(newText.getSimpleText());
		}
	}

	/* fields getters and setters */

	@PrePersist
	private void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	@PreUpdate
	private void updatedAt() {
		this.updatedAt = new Date();
	}

	public int getIdText() {
		return idText;
	}

	public void setIdText(int idText) {
		this.idText = idText;
	}

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

	public String getSimpleText() {
		return simpleText;
	}

	public void setSimpleText(String simpleText) {
		this.simpleText = simpleText;
	}

	/* Relations */

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setText(this);

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
		question.setText(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setVideo(null);
		return question;
	}

}
