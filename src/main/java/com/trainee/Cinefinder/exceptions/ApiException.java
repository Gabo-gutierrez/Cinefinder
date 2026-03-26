package com.trainee.Cinefinder.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {

  private final HttpStatus status;
  private final String moreInfo;

  public ApiException(String message, HttpStatus status, String moreInfo) {
    super(message);
    this.status = status;
    this.moreInfo = moreInfo;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getMoreInfo() {
    return moreInfo;
  }
}