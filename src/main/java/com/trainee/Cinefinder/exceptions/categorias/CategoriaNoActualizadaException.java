package com.trainee.Cinefinder.exceptions.categorias;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoriaNoActualizadaException extends RuntimeException {
    public CategoriaNoActualizadaException(Integer id) {
        super("No se pudo actualizar la categoría con el id:" + id);
    }
}
