package com.viewquiz.backend.app.quiz.persistence.model.media;

import java.io.Serializable;
import java.util.Date;
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
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.viewquiz.backend.app.quiz.persistence.model.Answer;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.Test;
import com.viewquiz.backend.app.quiz.persistence.model.util.CustomDateDerializer;
import com.viewquiz.backend.app.quiz.web.dto.View;

/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name = "images")
@NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonView(View.Summary.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_image")
	private int idImage;

	@JsonView(View.Summary.class)
	@Column(name = "height_image")
	private int heightImage;

	@JsonDeserialize(using = CustomDateDerializer.class)
	@JsonView(View.Summary.class)
	@Column(name = "horodatage_creation")
//	private Timestamp horodatageCreation;
	private Date horodatageCreation;
	
	@Column(name = "name_image")
	private String nameImage;

	@Lob
	@Column(name = "uri_image")
	private String uriImage;

	@Lob
	@Column(name = "url_image")
	private String urlImage;

	@Column(name = "width_image")
	private int widthImage;

	@JsonIgnore
	// @JsonBackReference
	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "image")
	private List<Test> tests;
	@JsonIgnore
	// @JsonBackReference
	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "image")
	private List<Answer> answers;
	@JsonIgnore
	// @JsonBackReference
	// bi-directional many-to-one association to Question
	@OneToMany(mappedBy = "image")
	private List<Question> questions;

	/* Constructors */
	public Image() {
	}

	/* fields getters and setters */

	public int getIdImage() {
		return this.idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public int getHeightImage() {
		return this.heightImage;
	}

	public void setHeightImage(int heightImage) {
		this.heightImage = heightImage;
	}

	public Date getHorodatageCreation() {
		return this.horodatageCreation;
	}

	public void setHorodatageCreation(Date horodatageCreation) {
		this.horodatageCreation = horodatageCreation;
	}

	public String getNameImage() {
		return this.nameImage;
	}

	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
	}

	public String getUriImage() {
		return this.uriImage;
	}

	public void setUriImage(String uriImage) {
		this.uriImage = uriImage;
	}

	public String getUrlImage() {
		return this.urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getWidthImage() {
		return this.widthImage;
	}

	public void setWidthImage(int widthImage) {
		this.widthImage = widthImage;
	}

	/* Relations */
	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setImage(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setImage(null);

		return test;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setImage(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setImage(null);

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
		question.setImage(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setImage(null);

		return question;
	}

	@Override
	public String toString() {
		return "Image [idImage=" + idImage + ", heightImage=" + heightImage + ", horodatageCreation=" + horodatageCreation + ", nomImage=" + nameImage + ", uriImage=" + uriImage + ", urlImage=" + urlImage + ", widthImage=" + widthImage + "]";
	}

}