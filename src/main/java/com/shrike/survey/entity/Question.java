package com.shrike.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
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

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionId=" + questionId + ", title=" + title + ", type=" + type
				+ ", optionalValues=" + optionalValues + ", surveyId=" + surveyId + "]";
	}

}
