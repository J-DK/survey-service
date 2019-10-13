package com.shrike.survey.model;


import lombok.Data;

public interface LoginUserRequestResponse {

    @Data
    class LoginUserRequest extends BaseRequestResponse.BaseRequest {

        private String email;

        private String password;
    }

    @Data
    class LoginUserResponse extends BaseRequestResponse.BaseResponse {

        private String email;

    }
}
