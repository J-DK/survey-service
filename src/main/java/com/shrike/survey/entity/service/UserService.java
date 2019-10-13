package com.shrike.survey.entity.service;


import com.shrike.survey.model.LoginUserRequestResponse.LoginUserRequest;
import com.shrike.survey.model.LoginUserRequestResponse.LoginUserResponse;
import com.shrike.survey.model.SignupUserRequestResponse.SignupUserRequest;
import com.shrike.survey.model.SignupUserRequestResponse.SignupUserResponse;

public interface UserService {

    SignupUserResponse createUser(SignupUserRequest signupUserRequest);

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);
}
