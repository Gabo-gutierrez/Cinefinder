package com.trainee.Cinefinder.exceptions.eventosUrbanos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventoUrbanoTituloYaExistenteException extends RuntimeException {
    public EventoUrbanoTituloYaExistenteException(String titulo) {
        super("Ya existe una película con el titulo de: " + titulo + ", por favor, intente con otro distinto");
    }
}
