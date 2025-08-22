package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.ObrasDto;

import java.util.List;
import java.util.Optional;

public interface ObrasServices {
    List<ObrasDto> getObras();
    Optional<ObrasDto> getObrasPorTitutlo(String titulo);

    ObrasDto guardarObra(ObrasDto dto);
    ObrasDto actualizarObra(Integer id, ObrasDto dto);
    Void eliminarObra(Integer id);
}
