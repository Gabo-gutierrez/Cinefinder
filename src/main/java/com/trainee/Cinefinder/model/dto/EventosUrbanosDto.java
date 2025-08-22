package com.trainee.Cinefinder.model.dto;

import java.util.Date;

public record EventosUrbanosDto(
        Integer id,
        String titulo,
        String descripcion,
        Date fecha,
        String lugar,
        Integer categoria_id
) {}