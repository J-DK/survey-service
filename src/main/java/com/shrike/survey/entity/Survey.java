package com.shrike.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "public", name = "survey")
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String surveyName;

	private String userId;

	private String surveyId;

	@Override
	public String toString() {
		return "Survey [id=" + id + ", surveyName=" + surveyName + ", userId=" + userId + ", surveyId=" + surveyId
				+ "]";
	}

}
