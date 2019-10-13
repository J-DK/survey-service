package com.shrike.survey.model;

import lombok.Data;

public interface BaseRequestResponse {

  class BaseRequest {
    /**
     * Basic Request Template
     */
  }

  /**
   * Basic Response Response of all Response models.
   */
  @Data
  class BaseResponse<T> {

    private String code;

    private String message;

    private T responseData;

  }
}
