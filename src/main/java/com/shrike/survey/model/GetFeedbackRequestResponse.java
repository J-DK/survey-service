package com.shrike.survey.model;

import java.util.List;

import lombok.Data;

public interface GetFeedbackRequestResponse {

	public class GetFeedbackRequest {

	}

	@Data
	public class GetFeedbackResponse {

		private List<FeedbackResponse> feedbacks;

		@Override
		public String toString() {
			return "GetFeedbackResponse [answers=" + feedbacks + "]";
		}

	}

	@Data
	public class FeedbackResponse {

		private String surveyId;

		private String surveyedBy;

		private String author;

		private String surveyName;

		private String answer;

		@Override
		public String toString() {
			return "FeedbackResponse [surveyId=" + surveyId + ", surveyedBy=" + surveyedBy + ", author=" + author
					+ ", surveyName=" + surveyName + ", answer=" + answer + "]";
		}

	}
}
