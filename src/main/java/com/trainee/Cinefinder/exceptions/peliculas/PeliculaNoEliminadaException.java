package com.trainee.Cinefinder.exceptions.peliculas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PeliculaNoEliminadaException extends RuntimeException {
    public PeliculaNoEliminadaException(Integer id, String message) {
        super("No se pudo eliminar la pelicula con el id:" + id + message);
    }
}
