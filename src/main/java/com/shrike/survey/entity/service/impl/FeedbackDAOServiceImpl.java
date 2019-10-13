package com.shrike.survey.entity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.shrike.survey.entity.Feedback;
import com.shrike.survey.entity.repository.FeedbackRepository;
import com.shrike.survey.entity.service.IFeedbackDAOService;
import com.shrike.survey.model.BaseRequestResponse.BaseResponse;
import com.shrike.survey.model.CreateFeedBackRequestResponse.CreateFeedBackRequest;
import com.shrike.survey.model.CreateFeedBackRequestResponse.CreateFeedBackResponse;
import com.shrike.survey.model.GetFeedbackRequestResponse.FeedbackResponse;
import com.shrike.survey.model.GetFeedbackRequestResponse.GetFeedbackResponse;

@Service
public class FeedbackDAOServiceImpl implements IFeedbackDAOService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public BaseResponse<CreateFeedBackResponse> saveFeedback(CreateFeedBackRequest createFeedBackRequest) {
		BaseResponse<CreateFeedBackResponse> baseResponse = new BaseResponse<>();
		Gson gson = new Gson();
		Feedback feedback = new Feedback();
		feedback.setAuthor(createFeedBackRequest.getAuthor());
		feedback.setSurveyedBy(createFeedBackRequest.getSurveyedBy());
		feedback.setSurveyId(createFeedBackRequest.getSurveyId());
		feedback.setSurveyName(createFeedBackRequest.getSurveyName());
		feedback.setAnswer(gson.toJson(createFeedBackRequest.getAnswers()));
		try {
			feedbackRepository.save(feedback);
			baseResponse.setCode("200");
			baseResponse.setMessage("Saved your response successfully.");
		} catch (Exception ex) {
			baseResponse.setCode("50003");
			baseResponse.setMessage("Couldn't save your feedback. Please try again.");
		}
		return baseResponse;
	}

	@Override
	public BaseResponse<GetFeedbackResponse> getAllFeedbacksByAuthor(String author) {
		BaseResponse<GetFeedbackResponse> baseResponse = new BaseResponse<>();
		GetFeedbackResponse getFeedbackResponse = new GetFeedbackResponse();
		List<FeedbackResponse> feedbackResponses = new ArrayList<>();
		List<Feedback> feedbacks = feedbackRepository.findAllByAuthor(author);
		JsonParser jsonParser = new JsonParser();
		feedbacks.forEach(feedback -> {
			FeedbackResponse feedbackResponse = new FeedbackResponse();
			feedbackResponse.setAuthor(feedback.getAuthor());
			feedbackResponse.setSurveyedBy(feedback.getSurveyedBy());
			feedbackResponse.setSurveyName(feedback.getSurveyName());
			feedbackResponse.setAnswer(jsonParser.parse(feedback.getAnswer()).getAsJsonObject());
			feedbackResponse.setSurveyId(feedback.getSurveyId());
			feedbackResponses.add(feedbackResponse);
		});
		
		getFeedbackResponse.setFeedbacks(feedbackResponses);
		baseResponse.setResponseData(getFeedbackResponse);
		baseResponse.setCode("200");
		baseResponse.setMessage("Fetched responses successfully.");
		return baseResponse;
	}

}
