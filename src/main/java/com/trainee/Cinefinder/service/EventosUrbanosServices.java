package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.EventosUrbanosDto;

import java.util.List;
import java.util.Optional;

public interface EventosUrbanosServices {
    List<EventosUrbanosDto> getEventosUrbanos();
    Optional<EventosUrbanosDto> getEventosUrbanosPorTitutlo(String titulo);

    EventosUrbanosDto guardarEventoUrbano(EventosUrbanosDto dto);
    EventosUrbanosDto actualizarEventoUrbano(Integer id, EventosUrbanosDto dto);
    Void eliminarEventoUrbano(Integer id);
}
