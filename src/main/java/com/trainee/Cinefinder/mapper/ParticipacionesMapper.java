package com.trainee.Cinefinder.mapper;

import com.trainee.Cinefinder.model.Participaciones;
import com.trainee.Cinefinder.model.dto.ParticipacionesDto;
import org.springframework.stereotype.Component;

@Component
public class ParticipacionesMapper {
    public static ParticipacionesDto participacionesToDto (Participaciones participaciones){
        return new ParticipacionesDto(
                participaciones.getId(),
                participaciones.getArtista_dni(),
                participaciones.getTipoEvento(),
                participaciones.getEvento_id()
        );
    }

    public static Participaciones participacionesToEntity (ParticipacionesDto participacionesToDto){
        Participaciones participaciones = new Participaciones();
        participaciones.setId(participacionesToDto.id());
        participaciones.setArtista_dni(participacionesToDto.artistas_dni());
        participaciones.setTipoEvento(participacionesToDto.tipo_evento());
        participaciones.setEvento_id(participacionesToDto.evento_id());
        return participaciones;
    }
}
