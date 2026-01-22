package com.wipro.oers.entity;
public class Question {
private String questionId;
private String examId;
private String text;
private String optionA;
private String optionB;
private String optionC;
private String optionD;
private String correctAnswer;
public Question(String questionId, String examId, String text, String optionA, String optionB, String optionC,String optionD, String correctAnswer) {
	this.questionId = questionId;
	this.examId = examId;
	this.text = text;
	this.optionA = optionA;
	this.optionB = optionB;
	this.optionC = optionC;
	this.optionD = optionD;
	this.correctAnswer = correctAnswer;
	}
	public String getQuestionId() {
	return questionId;
	}
	public void setQuestionId(String questionId) {
	this.questionId = questionId;
	}
	public String getExamId() {
	return examId;
	}
	public void setExamId(String examId) {
	this.examId = examId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
	this.text = text;
	}
	public String getOptionA() {
	return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
		}
		public String getOptionB() {
		return optionB;
		}
		public void setOptionB(String optionB) {
		this.optionB = optionB;
		}
		public String getOptionC() {
		return optionC;
		}
		public void setOptionC(String optionC) {
		this.optionC = optionC;
		}
		public String getOptionD() {
		return optionD;
		}
		public void setOptionD(String optionD) {
		this.optionD = optionD;
		}
		public String getCorrectAnswer() {
			return correctAnswer;
			}
			public void setCorrectAnswer(String correctAnswer) {
			this.correctAnswer = correctAnswer;
			}
			}