package com.viewquiz.backend.app.quiz.persistence.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.viewquiz.backend.app.quiz.persistence.model.media.Audio;
import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persistence.model.media.Text;
import com.viewquiz.backend.app.quiz.persistence.model.media.Video;
import com.viewquiz.backend.app.quiz.persistence.model.util.CustomDateDerializer;
import com.viewquiz.backend.app.quiz.web.dto.View;

/**
 * The persistent class for the questions database table.
 * 
 */
// @JsonInclude(Include.ALWAYS)
@Entity
@Table(name = "questions")
@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Question Choix Unique
	 */
	@Transient
	public static final String QuestionChoixUnique_TYPE = "qcu";

	/**
	 * Question Choix Multiple
	 */
	@Transient
	public static final String QuestionChoixMultiple_TYPE = "qcm";

	/**
	 * Input Text Based
	 */
	@Transient
	public static final String InputTextBased_TYPE = "itb";

	/**
	 * Fill In The Blanks
	 */
	@Transient
	public static final String FillInTheBlanks_TYPE = "fitb";

	/**
	 * Put In The Right Order
	 */
	@Transient
	public static final String PutInTheRightOrder_TYPE = "pitro";

	// @JsonView(View.Summary.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_question")
	private int idQuestion;

	@JsonDeserialize(using = CustomDateDerializer.class)
	// @JsonView(View.Summary.class)
	@Column(name = "horodatage_creation")
	private Timestamp horodatageCreation;

	// @JsonView(View.Summary.class)
	@Column(name = "tag_question")
	private String tagQuestion;

	// @JsonView(View.Summary.class)
	@Lob
	@Column(name = "text_question")
	private String textQuestion;

	// @JsonView(View.Summary.class)
	@Column(name = "timer_question")
	private int timerQuestion;

	// @JsonView(View.Summary.class)
	@Lob
	@Column(name = "title_question")
	private String titleQuestion;

	// @JsonView(View.Summary.class)
	@Column(name = "type_question")
	private String typeQuestion;

	@JsonIgnore
	// @JsonManagedReference
	// bi-directional many-to-one association to Answer
	// @JsonView(View.Summary.class)
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	// @JsonIgnore
	// @JsonManagedReference
	// @JsonView(View.Summary.class)
	// bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name = "id_text")
	private Text text;

//	@JsonIgnore
	// @JsonManagedReference
	// bi-directional many-to-one association to Image
//	@JsonView(View.Summary.class)
	@ManyToOne
	@JoinColumn(name = "id_image")
	private Image image;

//	@JsonIgnore
	// @JsonManagedReference
	// bi-directional many-to-one association to Audio
//	@JsonView(View.Summary.class)
	@ManyToOne
	@JoinColumn(name = "id_audio")
	private Audio audio;

//	@JsonIgnore
	// @JsonManagedReference
	// @JsonView(View.Summary.class)
	// bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name = "id_video")
	private Video video;

	@JsonIgnore
	// @JsonBackReference
	@JoinColumn(name = "id_test")
	@ManyToOne(cascade = CascadeType.ALL)
	private Test test;

	/* Constructors */

	public Question() {
	}

	/* Fields Getters Setters */

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public Timestamp getHorodatageCreation() {
		return this.horodatageCreation;
	}

	public void setHorodatageCreation(Timestamp horodatageCreation) {
		this.horodatageCreation = horodatageCreation;
	}

	public String getTagQuestion() {
		return this.tagQuestion;
	}

	public void setTagQuestion(String tagQuestion) {
		this.tagQuestion = tagQuestion;
	}

	public String getTextQuestion() {
		return this.textQuestion;
	}

	public void setTextQuestion(String textQuestion) {
		this.textQuestion = textQuestion;
	}

	public int getTimerQuestion() {
		return this.timerQuestion;
	}

	public void setTimerQuestion(int timerQuestion) {
		this.timerQuestion = timerQuestion;
	}

	public String getTitleQuestion() {
		return this.titleQuestion;
	}

	public void setTitleQuestion(String titleQuestion) {
		this.titleQuestion = titleQuestion;
	}

	public String getTypeQuestion() {
		return this.typeQuestion;
	}

	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

	/* Relations */

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

	public void setTest(Test test) {
		this.test = test;
	}

	public Test getTest() {
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
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
	}

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", horodatageCreation=" + horodatageCreation + ", tagQuestion=" + tagQuestion + ", textQuestion=" + textQuestion + ", timerQuestion=" + timerQuestion + ", titleQuestion=" + titleQuestion + ", typeQuestion=" + typeQuestion + ", answers=" + answers + ", text=" + text + ", video=" + video + ", image=" + image + ", audio=" + audio + "]";
	}

}