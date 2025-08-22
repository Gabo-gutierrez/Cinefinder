package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.CategoriasDto;

import java.util.List;
import java.util.Optional;

public interface CategoriasServices {
    List<CategoriasDto> getCategorias();
    Optional<CategoriasDto> getCategoriasPorNombre(String nombre);

    CategoriasDto guardarCategoria(CategoriasDto dto);
    CategoriasDto actualizarCategoria(Integer id, CategoriasDto dto);
    Void eliminarCategoria(Integer id);
}
