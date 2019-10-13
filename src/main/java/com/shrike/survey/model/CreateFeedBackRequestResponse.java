package com.shrike.survey.model;

import java.util.List;

public interface CreateFeedBackRequestResponse {

	public class CreateFeedBackRequest {

		private String surveyId;

		private String surveyedBy;

		private String author;

		private String surveyName;

		private List<Answer> answers;

		public String getSurveyId() {
			return surveyId;
		}

		public void setSurveyId(String surveyId) {
			this.surveyId = surveyId;
		}

		public String getSurveyedBy() {
			return surveyedBy;
		}

		public void setSurveyedBy(String surveyedBy) {
			this.surveyedBy = surveyedBy;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public List<Answer> getAnswers() {
			return answers;
		}

		public void setAnswers(List<Answer> answers) {
			this.answers = answers;
		}

		public String getSurveyName() {
			return surveyName;
		}

		public void setSurveyName(String surveyName) {
			this.surveyName = surveyName;
		}

		@Override
		public String toString() {
			return "CreateFeedBackRequest [surveyId=" + surveyId + ", surveyedBy=" + surveyedBy + ", author=" + author
					+ ", surveyName=" + surveyName + ", answers=" + answers + "]";
		}

	}

	public class CreateFeedBackResponse {

	}

	public class Answer {

		private Integer questionNo;

		private String question;

		private String value;

		private String questionType;

		public Integer getQuestionNo() {
			return questionNo;
		}

		public void setQuestionNo(Integer questionNo) {
			this.questionNo = questionNo;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getQuestionType() {
			return questionType;
		}

		public void setQuestionType(String questionType) {
			this.questionType = questionType;
		}

		@Override
		public String toString() {
			return "Answer [questionNo=" + questionNo + ", question=" + question + ", value=" + value
					+ ", questionType=" + questionType + "]";
		}

	}
}
