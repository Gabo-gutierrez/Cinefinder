package com.trainee.Cinefinder.exceptions;

import org.springframework.http.HttpStatus;

public class RecursoYaExistenteException extends ApiException {
    public RecursoYaExistenteException(String recurso, Object id) {
        super(
                "El " + recurso + " identificado con: " + id + " ya existe en la base de datos",
                HttpStatus.CONFLICT,
                "Recurso Ya Existente"
        );
    }
}