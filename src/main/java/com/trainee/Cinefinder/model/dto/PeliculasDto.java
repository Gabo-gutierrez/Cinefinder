package com.trainee.Cinefinder.model.dto;

public record PeliculasDto(
        Integer id,
        String titulo,
        String sipnosis,
        Integer duracion,
        Integer categoria_id
) {}