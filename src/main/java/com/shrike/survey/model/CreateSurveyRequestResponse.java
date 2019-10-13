package com.shrike.survey.model;

import java.util.List;
import lombok.Data;

public interface CreateSurveyRequestResponse {

  @Data
  class CreateSurveyRequest {

    private String emailId;

    private String surveyName;

    private List<Question> questionnaire;

    @Override
    public String toString() {
      return "CreateSurveyRequest [emailId=" + emailId + ", surveyName=" + surveyName
          + ", questionnaire="
          + questionnaire + "]";
    }

  }

  @Data
  class CreateSurveyResponse {

    private String surveyId;

    @Override
    public String toString() {
      return "CreateSurveyResponse [surveyId=" + surveyId + "]";
    }

  }

  @Data
  class Question {

    private Integer questionNo;

    private String title;

    private String type;

    private List<String> optionalValues;


    @Override
    public String toString() {
      return "Question [questionNo=" + questionNo + ", title=" + title + ", type=" + type
          + ", optionalValues="
          + optionalValues + "]";
    }

  }
}
