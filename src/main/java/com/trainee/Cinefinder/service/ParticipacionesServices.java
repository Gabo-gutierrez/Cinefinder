package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.ParticipacionesDto;

import java.util.List;
import java.util.Optional;

public interface ParticipacionesServices extends CrudServices<ParticipacionesDto, Integer>{
    Optional<ParticipacionesDto> getParticipacionesPorTipo(String tipo_evento);
}
