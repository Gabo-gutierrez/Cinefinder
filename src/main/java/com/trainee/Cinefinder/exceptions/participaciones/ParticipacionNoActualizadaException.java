package com.trainee.Cinefinder.exceptions.participaciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParticipacionNoActualizadaException extends RuntimeException {
    public ParticipacionNoActualizadaException(Integer id, String message) {
        super("No se pudo actualizar el participacion con el id: " + id + message);
    }
}
