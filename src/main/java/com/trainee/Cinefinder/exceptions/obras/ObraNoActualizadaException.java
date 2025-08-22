package com.trainee.Cinefinder.exceptions.obras;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObraNoActualizadaException extends RuntimeException {
    public ObraNoActualizadaException(Integer id, String message) {
        super("No se pudo actualizar la Obra con el id: " + id + message);
    }
}
