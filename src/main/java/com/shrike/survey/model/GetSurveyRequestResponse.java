package com.shrike.survey.model;

import java.util.List;

import lombok.Data;

public interface GetSurveyRequestResponse {

	public class GetSurveyRequest {

	}

	@Data
	public class GetSurveyResponse {

		private List<SurveyResponse> surveys;

		@Override
		public String toString() {
			return "GetSurveyResponse [surveys=" + surveys + "]";
		}

	}
	
	@Data
	public class GetSurveyByIdResponse {

		private SurveyResponse surveys;

		@Override
		public String toString() {
			return "GetSurveyResponse [surveys=" + surveys + "]";
		}

	}

	@Data
	public class SurveyResponse {

		private String userId;

		private String surveyId;

		private String surveyName;

		private List<QuestionResponse> questions;

		@Override
		public String toString() {
			return "SurveyResponse [userId=" + userId + ", surveyId=" + surveyId + ", surveyName=" + surveyName
					+ ", questions=" + questions + "]";
		}

	}

	@Data
	public class QuestionResponse {

		private Integer questionNo;

		private String title;

		private String type;

		private List<String> optionalValues;

		@Override
		public String toString() {
			return "QuestionResponse [questionNo=" + questionNo + ", title=" + title + ", type=" + type
					+ ", optionalValues=" + optionalValues + "]";
		}

	}
}
