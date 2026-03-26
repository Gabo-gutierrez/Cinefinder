package com.trainee.Cinefinder.exceptions;

import com.trainee.Cinefinder.model.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex, WebRequest request) {
        String uri = request.getDescription(false).replace("uri=", "");

        ErrorResponse error = ErrorResponse.builder()
                .code(String.valueOf(ex.getStatus().value()))
                .details(ex.getMessage())
                .location(request.getDescription(true))
                .moreInfo(ex.getMoreInfo() + " | endpoint: " + uri)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, WebRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .code("500")
                .details(ex.getMessage())
                .location(request.getDescription(false))
                .moreInfo("Ocurrió un error inesperado")
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}