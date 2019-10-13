package com.shrike.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer questionId;

	private String title;

	private String type;

	private String optionalValues;

	private Integer surveyId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOptionalValues() {
		return optionalValues;
	}

	public void setOptionalValues(String optionalValues) {
		this.optionalValues = optionalValues;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionId=" + questionId + ", title=" + title + ", type=" + type
				+ ", optionalValues=" + optionalValues + ", surveyId=" + surveyId + "]";
	}

}
