package com.trainee.Cinefinder.model.dto;

public record ObrasDto(
        Integer id,
        String titulo,
        String descripcion,
        Integer duracion,
        Integer categoria_id
) {}