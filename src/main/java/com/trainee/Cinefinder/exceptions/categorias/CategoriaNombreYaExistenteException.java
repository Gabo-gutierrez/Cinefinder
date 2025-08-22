package com.trainee.Cinefinder.exceptions.categorias;

public class CategoriaNombreYaExistenteException extends RuntimeException {
    public CategoriaNombreYaExistenteException(String nombre) {
        super("Ya existe una categoría con el nombre: " + nombre + ", por favor, intente con otro distinto");
    }
}
