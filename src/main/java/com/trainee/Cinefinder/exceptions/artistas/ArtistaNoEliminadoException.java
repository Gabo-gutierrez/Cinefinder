package com.trainee.Cinefinder.exceptions.artistas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArtistaNoEliminadoException extends RuntimeException {
    public ArtistaNoEliminadoException(Long dni, String message) {
        super("No se pudo eliminar el artista con el dni: " + dni + message);
    }
}
