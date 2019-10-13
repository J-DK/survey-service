package com.shrike.survey.entity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrike.survey.entity.Question;
import com.shrike.survey.entity.Survey;
import com.shrike.survey.entity.User;
import com.shrike.survey.entity.repository.QuestionRepository;
import com.shrike.survey.entity.repository.SurveyRepository;
import com.shrike.survey.entity.service.ISurveyDAOService;
import com.shrike.survey.entity.service.IUserDAOService;
import com.shrike.survey.model.BaseRequestResponse.BaseResponse;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyRequest;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyResponse;

@Service
public class SurveyDAOServiceImpl implements ISurveyDAOService {

	@Autowired
	private IUserDAOService iUserDAOService;

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public BaseResponse<CreateSurveyResponse> createSurvey(CreateSurveyRequest createSurveyRequest) {
		BaseResponse<CreateSurveyResponse> baseResponse = new BaseResponse<>();
		CreateSurveyResponse createSurveyResponse = new CreateSurveyResponse();

		User user = iUserDAOService.findByEmail(createSurveyRequest.getEmailId());
		if (null == user) {
			baseResponse.setCode("50001");
			baseResponse.setMessage("User not found. Can't create a survey.");
		} else {
			try {
				Survey survey = new Survey();
				survey.setSurveyId(getSurveyId());
				survey.setSurveyName(createSurveyRequest.getSurveyName());
				survey.setUserId(user.getId());
				Survey savedSurvey = surveyRepository.save(survey);
				List<Question> questions = new ArrayList<>();
				
				createSurveyRequest.getQuestionnaire().forEach(ques -> {
					Question question = new Question();
					question.setQuestionId(ques.getQuestionNo());
					question.setSurveyId(savedSurvey.getId());
					question.setTitle(ques.getTitle());
					question.setType(ques.getType());
					question.setOptionalValues(ques.getOptionalValues().stream().collect(Collectors.joining(",")));
					questions.add(question);

				});
				questionRepository.saveAll(questions);
				createSurveyResponse.setSurveyId(savedSurvey.getSurveyId());
				baseResponse.setCode("200");
				baseResponse.setMessage("Survey created successfully.");
				baseResponse.setResponseData(createSurveyResponse);

			} catch (Exception ex) {
				baseResponse.setCode("50002");
				baseResponse.setMessage("Could'nt create and save survey. Please try again.");
			}
		}
		return baseResponse;
	}

	private String getSurveyId() {
		return "survey-" + RandomStringUtils.randomAlphanumeric(10);
	}

}
