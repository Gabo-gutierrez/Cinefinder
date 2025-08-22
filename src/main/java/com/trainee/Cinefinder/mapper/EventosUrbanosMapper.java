package com.trainee.Cinefinder.mapper;

import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.EventosUrbanos;
import com.trainee.Cinefinder.model.dto.EventosUrbanosDto;
import org.springframework.stereotype.Component;

@Component
public class EventosUrbanosMapper {
    public static EventosUrbanosDto EventosUrbanosToDto (EventosUrbanos EventosUrbanos){
        return new EventosUrbanosDto(
                EventosUrbanos.getId(),
                EventosUrbanos.getTitulo(),
                EventosUrbanos.getDescripcion(),
                EventosUrbanos.getFecha(),
                EventosUrbanos.getLugar(),
                EventosUrbanos.getCategorias_id().getId()
        );
    }

    public static EventosUrbanos EventosUrbanosToEntity (EventosUrbanosDto EventosUrbanosToDto){
        EventosUrbanos EventosUrbanos = new EventosUrbanos();
        EventosUrbanos.setId(EventosUrbanosToDto.id());
        EventosUrbanos.setTitulo(EventosUrbanosToDto.titulo());
        EventosUrbanos.setDescripcion(EventosUrbanosToDto.descripcion());
        EventosUrbanos.setFecha(EventosUrbanosToDto.fecha());
        EventosUrbanos.setLugar(EventosUrbanosToDto.lugar());

        Categorias categoria = new Categorias();
        categoria.setId(EventosUrbanosToDto.categoria_id());
        EventosUrbanos.setCategorias_id(categoria);

        return EventosUrbanos;
    }
}
