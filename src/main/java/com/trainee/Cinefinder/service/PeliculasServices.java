package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.PeliculasDto;

import java.util.List;
import java.util.Optional;

public interface PeliculasServices {
    List<PeliculasDto> getPeliculas();
    Optional<PeliculasDto> getPeliculasPorTitutlo(String titulo);

    PeliculasDto guardarPelicula(PeliculasDto dto);
    PeliculasDto actualizarPelicula(Integer id, PeliculasDto dto);
    Void eliminarPelicula(Integer id);
}
