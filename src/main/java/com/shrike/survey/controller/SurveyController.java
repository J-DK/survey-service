package com.shrike.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shrike.survey.entity.service.IFeedbackDAOService;
import com.shrike.survey.entity.service.ISurveyDAOService;
import com.shrike.survey.model.BaseRequestResponse.BaseResponse;
import com.shrike.survey.model.CreateFeedBackRequestResponse.CreateFeedBackRequest;
import com.shrike.survey.model.CreateFeedBackRequestResponse.CreateFeedBackResponse;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyRequest;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyResponse;
import com.shrike.survey.model.GetFeedbackRequestResponse.GetFeedbackResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@Api("Api Documentation for Survey Related API's")
@RequestMapping("/api")
public class SurveyController {

	@Autowired
	private ISurveyDAOService iSurveyDAOService;

	@Autowired
	private IFeedbackDAOService iFeedbackDAOService;

	@PostMapping("/v1/surveys")
	@ApiOperation(value = "Create survey", response = CreateSurveyResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Created survey successfully"),
			@ApiResponse(code = 403, message = "Unauthorized Access"),
			@ApiResponse(code = 404, message = "API Not Found"),
			@ApiResponse(code = 50001, message = "User not found. Can't create a survey."),
			@ApiResponse(code = 50002, message = "Couldn't create and save survey. Please try again.")

	})
	public BaseResponse<CreateSurveyResponse> createSurvey(@RequestBody CreateSurveyRequest createSurveyRequest) {
		return iSurveyDAOService.createSurvey(createSurveyRequest);
	}

	@PostMapping("v1/responses")
	@ApiOperation(value = "Submit feedback", response = CreateFeedBackResponse.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Saved your response successfully."),
			@ApiResponse(code = 403, message = "Unauthorized Access"),
			@ApiResponse(code = 404, message = "API Not Found"),
			@ApiResponse(code = 50003, message = "User not found. Can't create a survey.")
	})
	public BaseResponse<CreateFeedBackResponse> saveFeedBack(@RequestBody CreateFeedBackRequest createFeedBackRequest) {
		return iFeedbackDAOService.saveFeedback(createFeedBackRequest);
	}

	@GetMapping("/v1/responses")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched responses successfully."),
		@ApiResponse(code = 403, message = "Unauthorized Access"),
		@ApiResponse(code = 404, message = "API Not Found"),
		@ApiResponse(code = 50004, message = "Couldn't fetch feedbacks.")
	})
	public BaseResponse<GetFeedbackResponse> getAllFeedback(@RequestParam("author") String author) {
		return iFeedbackDAOService.getAllFeedbacksByAuthor(author);
	}
}
