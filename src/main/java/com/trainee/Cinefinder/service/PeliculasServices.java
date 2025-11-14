package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.PeliculasDto;

import java.util.List;
import java.util.Optional;

public interface PeliculasServices extends CrudServices<PeliculasDto, Integer>{
    Optional<PeliculasDto> getPeliculasPorTitutlo(String titulo);
}
