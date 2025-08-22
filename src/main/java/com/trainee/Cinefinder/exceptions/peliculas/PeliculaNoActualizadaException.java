package com.trainee.Cinefinder.exceptions.peliculas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PeliculaNoActualizadaException extends RuntimeException {
    public PeliculaNoActualizadaException(Integer id, String message) {
        super("No se pudo actualizar la pelicula con el id: " + id + message);
    }
}
