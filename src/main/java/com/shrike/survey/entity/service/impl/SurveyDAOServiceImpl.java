package com.shrike.survey.entity.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.shrike.survey.model.GetSurveyRequestResponse.GetSurveyByIdResponse;
import com.shrike.survey.model.GetSurveyRequestResponse.GetSurveyResponse;
import com.shrike.survey.model.GetSurveyRequestResponse.QuestionResponse;
import com.shrike.survey.model.GetSurveyRequestResponse.SurveyResponse;

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
				survey.setUserId(user.getEmail());
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

	@Override
	public BaseResponse<GetSurveyResponse> getAllSurveys() {
		BaseResponse<GetSurveyResponse> baseResponse = new BaseResponse<>();
		GetSurveyResponse getSurveyResponse = new GetSurveyResponse();
		List<SurveyResponse> surveyResponses = new ArrayList<>();
		List<Survey> surveys = surveyRepository.findAll();

		surveys.parallelStream().forEach(survey -> {
			SurveyResponse surveyResponse = getSurveyResponse(survey);
			surveyResponses.add(surveyResponse);
		});

		getSurveyResponse.setSurveys(surveyResponses);
		baseResponse.setCode("200");
		baseResponse.setMessage("Fetched surveys successfully.");
		baseResponse.setResponseData(getSurveyResponse);
		return baseResponse;
	}

	@Override
	public BaseResponse<GetSurveyByIdResponse> getSurveyBySurveyId(String surveyId) {
		BaseResponse<GetSurveyByIdResponse> baseResponse = new BaseResponse<>();
		GetSurveyByIdResponse getSurveyByIdResponse = new GetSurveyByIdResponse();
		Survey survey = surveyRepository.findAllBySurveyId(surveyId);

		SurveyResponse surveyResponse = getSurveyResponse(survey);

		getSurveyByIdResponse.setSurveys(surveyResponse);
		baseResponse.setCode("200");
		baseResponse.setMessage("Fetched surveys successfully.");
		baseResponse.setResponseData(getSurveyByIdResponse);
		return baseResponse;
	}

	private SurveyResponse getSurveyResponse(Survey survey) {
		SurveyResponse surveyResponse = new SurveyResponse();
		List<Question> questions = questionRepository.findAllBySurveyIdOrderByQuestionIdAsc(survey.getId());
		List<QuestionResponse> questionResponses = new ArrayList<>();
		questions.forEach(question -> {
			QuestionResponse questionResponse = new QuestionResponse();
			questionResponse.setQuestionNo(question.getQuestionId());
			questionResponse.setTitle(question.getTitle());
			questionResponse.setType(question.getType());
			questionResponse.setOptionalValues(Arrays.asList(question.getOptionalValues().split(",")));
			questionResponses.add(questionResponse);
		});
		surveyResponse.setQuestions(questionResponses);
		surveyResponse.setSurveyId(survey.getSurveyId());
		surveyResponse.setSurveyName(survey.getSurveyName());
		surveyResponse.setUserId(survey.getUserId());
		return surveyResponse;
	}

}
