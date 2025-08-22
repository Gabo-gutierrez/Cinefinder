package com.trainee.Cinefinder.exceptions.artistas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArtistaNoActualizadoException extends RuntimeException {
    public ArtistaNoActualizadoException(Long dni,String message) {
        super("No se pudo actualizar el artista con el dni: " + dni + message);
    }
}
