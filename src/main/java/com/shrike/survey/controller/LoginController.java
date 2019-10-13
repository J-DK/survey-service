package com.shrike.survey.controller;

import com.shrike.survey.entity.service.UserService;
import com.shrike.survey.model.LoginUserRequestResponse.LoginUserRequest;
import com.shrike.survey.model.LoginUserRequestResponse.LoginUserResponse;
import com.shrike.survey.model.SignupUserRequestResponse.SignupUserRequest;
import com.shrike.survey.model.SignupUserRequestResponse.SignupUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
@Api(value = "APIs for Login service")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation(value = "Login User API", response = String.class)
    @ApiResponses({ @ApiResponse(code = 200, message = "Login Successful"),
            @ApiResponse(code = 404, message = "API Not Found") })
    public LoginUserResponse login(@RequestBody
        LoginUserRequest loginUserRequest) {
        return userService.loginUser(loginUserRequest);
    }

    @PostMapping("register")
    @ResponseBody
    @ApiOperation(value = "Register User API", response = SignupUserResponse.class)
    @ApiResponses({ @ApiResponse(code = 200, message = "Registration Successful"),
            @ApiResponse(code = 404, message = "API Not Found") })
    public SignupUserResponse register(@RequestBody
        SignupUserRequest registerUserRequest) {
        return userService.createUser(registerUserRequest);
    }

}
