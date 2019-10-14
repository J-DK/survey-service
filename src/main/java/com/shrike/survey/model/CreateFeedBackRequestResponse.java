package com.shrike.survey.model;

import java.util.List;

import lombok.Data;

public interface CreateFeedBackRequestResponse {

	@Data
	public class CreateFeedBackRequest {

		private String surveyId;

		private String surveyedBy;

		private String author;

		private String surveyName;

		private List<Answer> answers;

		@Override
		public String toString() {
			return "CreateFeedBackRequest [surveyId=" + surveyId + ", surveyedBy=" + surveyedBy + ", author=" + author
					+ ", surveyName=" + surveyName + ", answers=" + answers + "]";
		}

	}

	public class CreateFeedBackResponse {

	}

	@Data
	public class Answer {

		private Integer questionNo;

		private String question;

		private String value;

		private String questionType;

		@Override
		public String toString() {
			return "Answer [questionNo=" + questionNo + ", question=" + question + ", value=" + value
					+ ", questionType=" + questionType + "]";
		}

	}
}
