package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.CategoriasDto;

import java.util.List;
import java.util.Optional;

public interface CategoriasServices extends CrudServices<CategoriasDto, Integer>{
    Optional<CategoriasDto> getCategoriasPorNombre(String nombre);
}
