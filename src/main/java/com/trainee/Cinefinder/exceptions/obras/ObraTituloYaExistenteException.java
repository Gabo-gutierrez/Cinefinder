package com.trainee.Cinefinder.exceptions.obras;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObraTituloYaExistenteException extends RuntimeException {
    public ObraTituloYaExistenteException(String titulo) {
        super("Ya existe una película con el titulo de: " + titulo + ", por favor, intente con otro distinto");
    }
}
