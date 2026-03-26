package com.trainee.Cinefinder.exceptions;

import org.springframework.http.HttpStatus;

public class RecursoNoEliminadoException extends ApiException {
    public RecursoNoEliminadoException(String recurso, Object id) {
        super(
                "No se pudo eliminar la " + recurso + " con id: " + id,
                HttpStatus.BAD_REQUEST,
                "Recurso No Eliminado");
    }
}
