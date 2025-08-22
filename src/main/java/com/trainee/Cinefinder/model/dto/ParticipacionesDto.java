package com.trainee.Cinefinder.model.dto;


public record ParticipacionesDto(
        Integer id,
        Long artistas_dni,
        String tipo_evento,
        Integer evento_id
){}
