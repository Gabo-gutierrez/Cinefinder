package com.trainee.Cinefinder.exceptions.categorias;

public class CategoriaNoEliminadaException extends RuntimeException {
    public CategoriaNoEliminadaException(Integer id) {
        super("No se pudo eliminar la categoria con id: " + id);
    }
}
