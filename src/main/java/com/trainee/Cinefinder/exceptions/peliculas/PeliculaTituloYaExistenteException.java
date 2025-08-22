package com.trainee.Cinefinder.exceptions.peliculas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PeliculaTituloYaExistenteException extends RuntimeException {
    public PeliculaTituloYaExistenteException(String titulo) {
        super("Ya existe una película con el titulo de: " + titulo + ", por favor, intente con otro distinto");
    }
}
