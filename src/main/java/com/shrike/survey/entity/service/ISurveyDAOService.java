package com.shrike.survey.entity.service;

import com.shrike.survey.model.BaseRequestResponse.BaseResponse;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyRequest;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyResponse;
import com.shrike.survey.model.GetSurveyRequestResponse.GetSurveyByIdResponse;
import com.shrike.survey.model.GetSurveyRequestResponse.GetSurveyResponse;

public interface ISurveyDAOService {

	BaseResponse<CreateSurveyResponse> createSurvey(CreateSurveyRequest createSurveyRequest);

	BaseResponse<GetSurveyResponse> getAllSurveys();

	BaseResponse<GetSurveyByIdResponse> getSurveyBySurveyId(String surveyId);

}
