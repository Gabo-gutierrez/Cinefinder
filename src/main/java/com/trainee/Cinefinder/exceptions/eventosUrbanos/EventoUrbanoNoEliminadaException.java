package com.trainee.Cinefinder.exceptions.eventosUrbanos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventoUrbanoNoEliminadaException extends RuntimeException {
    public EventoUrbanoNoEliminadaException(Integer id, String message) {
        super("No se pudo eliminar la EventoUrbano con el id:" + id + message);
    }
}
