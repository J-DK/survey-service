package com.shrike.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrike.survey.entity.service.ISurveyDAOService;
import com.shrike.survey.model.BaseRequestResponse.BaseResponse;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyRequest;
import com.shrike.survey.model.CreateSurveyRequestResponse.CreateSurveyResponse;

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
}
