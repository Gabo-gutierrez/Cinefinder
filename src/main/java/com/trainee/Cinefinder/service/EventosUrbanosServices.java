package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.EventosUrbanosDto;

import java.util.List;
import java.util.Optional;

public interface EventosUrbanosServices extends CrudServices<EventosUrbanosDto, Integer>{
    Optional<EventosUrbanosDto> getEventosUrbanosPorTitutlo(String titulo);
}
