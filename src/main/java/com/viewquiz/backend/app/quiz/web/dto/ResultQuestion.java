package com.viewquiz.backend.app.quiz.web.dto;

public class ResultQuestion {

	public ResultQuestion(boolean isRightAnswer) {
		this.isRightAnswer = isRightAnswer;
	}

	public ResultQuestion(boolean isRightAnswer, String remarks) {
		this.isRightAnswer = isRightAnswer;
		this.remarks = remarks;
	}

	private boolean isRightAnswer;
	private String remarks;
	public boolean isRightAnswer() {
		return isRightAnswer;
	}

	public void setRightAnswer(boolean isRightAnswer) {
		this.isRightAnswer = isRightAnswer;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
