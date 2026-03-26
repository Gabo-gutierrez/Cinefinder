package com.trainee.Cinefinder.exceptions;

import org.springframework.http.HttpStatus;

public class RecursoNoEncontradoException extends ApiException {
  public RecursoNoEncontradoException(String message) {
    super(message, HttpStatus.NOT_FOUND, "Recurso No Encontrado");
  }
}
