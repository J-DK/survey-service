package com.shrike.survey.entity.service;

import com.shrike.survey.model.BaseRequestResponse.BaseResponse;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyRequest;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyResponse;

public interface ISurveyDAOService {

	BaseResponse<CreateSurveyResponse> createSurvey(CreateSurveyRequest createSurveyRequest);
	
}
