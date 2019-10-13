package com.shrike.survey.model;

import java.util.List;

public interface GetFeedbackRequestResponse {

	public class GetFeedbackRequest {

	}

	public class GetFeedbackResponse {

		private List<FeedbackResponse> feedbacks;

		public List<FeedbackResponse> getFeedbacks() {
			return feedbacks;
		}

		public void setFeedbacks(List<FeedbackResponse> feedbacks) {
			this.feedbacks = feedbacks;
		}

		@Override
		public String toString() {
			return "GetFeedbackResponse [answers=" + feedbacks + "]";
		}

	}

	public class FeedbackResponse {

		private String surveyId;

		private String surveyedBy;

		private String author;

		private String surveyName;

		private String answer;

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

		public String getSurveyName() {
			return surveyName;
		}

		public void setSurveyName(String surveyName) {
			this.surveyName = surveyName;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		@Override
		public String toString() {
			return "FeedbackResponse [surveyId=" + surveyId + ", surveyedBy=" + surveyedBy + ", author=" + author
					+ ", surveyName=" + surveyName + ", answer=" + answer + "]";
		}

	}
}
