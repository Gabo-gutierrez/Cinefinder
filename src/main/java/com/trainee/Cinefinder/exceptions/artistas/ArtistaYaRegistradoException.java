package com.trainee.Cinefinder.exceptions.artistas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArtistaYaRegistradoException extends RuntimeException {
    public ArtistaYaRegistradoException(Long dni) {
        super("La persona con el dni: " + dni + " ya se encuentra registrada;");
    }
}
