package com.shrike.survey.model;

import java.util.List;

public interface CreateSurveyRequestResponse {

	public class CreateSurveyRequest {

		private String emailId;

		private String surveyName;

		private List<Question> questionnaire;

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getSurveyName() {
			return surveyName;
		}

		public void setSurveyName(String surveyName) {
			this.surveyName = surveyName;
		}

		public List<Question> getQuestionnaire() {
			return questionnaire;
		}

		public void setQuestionnaire(List<Question> questionnaire) {
			this.questionnaire = questionnaire;
		}

		@Override
		public String toString() {
			return "CreateSurveyRequest [emailId=" + emailId + ", surveyName=" + surveyName + ", questionnaire="
					+ questionnaire + "]";
		}

	}

	public class CreateSurveyResponse {

		private String surveyId;

		public String getSurveyId() {
			return surveyId;
		}

		public void setSurveyId(String surveyId) {
			this.surveyId = surveyId;
		}

		@Override
		public String toString() {
			return "CreateSurveyResponse [surveyId=" + surveyId + "]";
		}

	}

	public class Question {

		private Integer questionNo;

		private String title;

		private String type;

		private List<String> optionalValues;

		public Integer getQuestionNo() {
			return questionNo;
		}

		public void setQuestionNo(Integer questionNo) {
			this.questionNo = questionNo;
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

		public List<String> getOptionalValues() {
			return optionalValues;
		}

		public void setOptionalValues(List<String> optionalValues) {
			this.optionalValues = optionalValues;
		}

		@Override
		public String toString() {
			return "Question [questionNo=" + questionNo + ", title=" + title + ", type=" + type + ", optionalValues="
					+ optionalValues + "]";
		}

	}
}
