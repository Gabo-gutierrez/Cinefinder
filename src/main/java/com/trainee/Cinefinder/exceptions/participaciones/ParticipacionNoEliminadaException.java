package com.trainee.Cinefinder.exceptions.participaciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParticipacionNoEliminadaException extends RuntimeException {
    public ParticipacionNoEliminadaException(Integer id, String message) {
        super("No se pudo eliminar el participacion con el id: " + id + message);
    }
}
