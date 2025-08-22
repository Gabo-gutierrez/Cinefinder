package com.trainee.Cinefinder.exceptions.obras;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObraNoEliminadaException extends RuntimeException {
    public ObraNoEliminadaException(Integer id, String message) {
        super("No se pudo eliminar la Obra con el id:" + id + message);
    }
}
