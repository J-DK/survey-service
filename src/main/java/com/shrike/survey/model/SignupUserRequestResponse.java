package com.shrike.survey.model;

import lombok.Data;

public interface SignupUserRequestResponse {

  @Data
  class SignupUserRequest extends BaseRequestResponse.BaseRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
  }


  @Data
  class SignupUserResponse extends BaseRequestResponse.BaseResponse {

    private String email;
  }
}
