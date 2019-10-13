package com.shrike.survey.entity.service;

import com.shrike.survey.model.BaseRequestResponse.BaseResponse;
import com.shrike.survey.model.CreateFeedBackRequestResponse.CreateFeedBackRequest;
import com.shrike.survey.model.CreateFeedBackRequestResponse.CreateFeedBackResponse;
import com.shrike.survey.model.GetFeedbackRequestResponse.GetFeedbackResponse;

public interface IFeedbackDAOService {

	BaseResponse<CreateFeedBackResponse> saveFeedback(CreateFeedBackRequest createFeedBackRequest);

	BaseResponse<GetFeedbackResponse> getAllFeedbacksByAuthor(String author);
}
