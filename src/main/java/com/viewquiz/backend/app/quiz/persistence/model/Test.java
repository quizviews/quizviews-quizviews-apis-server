package com.viewquiz.backend.app.quiz.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Version;
//import org.springframework.data.annotation.CreatedDate;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persistence.model.util.CustomDateDerializer;

/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name = "tests")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Test implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_test")
	private int idTest;

	// @JsonProperty("label")
	// @JsonFormat(shape=JsonFormat.Shape.STRING,
	// pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone="America/Phoenix")
	@JsonDeserialize(using = CustomDateDerializer.class)
	@Column(name = "created_at")
	public Date createdAt;

	@JsonDeserialize(using = CustomDateDerializer.class)
	@Column(name = "updated_at")
	public Date updatedAt;
	
	@NotEmpty
	@Column(name = "title_test")
	private String titleTest;

	
	@ManyToOne
	@JoinColumn(name = "id_image")
	private Image image;
	
	 @JsonIgnore
	// @JsonManagedReference
	// @JsonView(View.Summary.class)
	@OneToMany(mappedBy = "test")
	private List<Question> questions;

	public Test() {
	}

	@PrePersist
	private void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	@PreUpdate
	private void updatedAt() {
		this.updatedAt = new Date();
	}

	public int getIdTest() {
		return this.idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public String getTitleTest() {
		return titleTest;
	}

	public void setTitleTest(String titleTest) {
		this.titleTest = titleTest;
	}
	
	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setTest(this);
		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setTest(null);
		return question;
	}

	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", questions=" + questions + ", titleTest=" + titleTest + "]";
	}

}
