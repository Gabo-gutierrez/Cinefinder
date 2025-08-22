package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.ParticipacionesDto;

import java.util.List;
import java.util.Optional;

public interface ParticipacionesServices {
    List<ParticipacionesDto> getParticipaciones();
    Optional<ParticipacionesDto> getParticipacionesPorTipo(String tipo_evento);

    ParticipacionesDto guardarParticipacion(ParticipacionesDto dto);
    ParticipacionesDto actualizarParticipacion(Integer id, ParticipacionesDto dto);
    Void eliminarParticipacion(Integer id);
}
