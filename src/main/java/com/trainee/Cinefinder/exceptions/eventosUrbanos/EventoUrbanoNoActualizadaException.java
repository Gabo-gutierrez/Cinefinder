package com.trainee.Cinefinder.exceptions.eventosUrbanos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventoUrbanoNoActualizadaException extends RuntimeException {
    public EventoUrbanoNoActualizadaException(Integer id, String message) {
        super("No se pudo actualizar la EventoUrbano con el id: " + id + message);
    }
}
