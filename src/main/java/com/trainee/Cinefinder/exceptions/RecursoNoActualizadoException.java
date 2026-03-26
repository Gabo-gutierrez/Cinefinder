package com.trainee.Cinefinder.exceptions;

import org.springframework.http.HttpStatus;

public class RecursoNoActualizadoException extends ApiException {
    public RecursoNoActualizadoException(String recurso, Object id) {
        super(
                "No se pudo actualizar la " + recurso + " con el id: " + id,
                HttpStatus.BAD_REQUEST,
                "Recurso No Actualizado"
        );
    }
}
