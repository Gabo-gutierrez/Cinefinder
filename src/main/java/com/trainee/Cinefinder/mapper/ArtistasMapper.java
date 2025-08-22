package com.trainee.Cinefinder.mapper;

import com.trainee.Cinefinder.model.Artistas;
import com.trainee.Cinefinder.model.dto.ArtistasDto;
import org.springframework.stereotype.Component;

@Component
public class ArtistasMapper {
    public static ArtistasDto artistasToDto (Artistas artistas){
        return new ArtistasDto(
                artistas.getDni(),
                artistas.getNombre(),
                artistas.getApellido(),
                artistas.getTipo(),
                artistas.getDescripcion()
        );
    }

    public static Artistas artistasToEntity (ArtistasDto artistasToDto){
        Artistas artistas = new Artistas();
        artistas.setDni(artistasToDto.dni());
        artistas.setNombre(artistasToDto.nombre());
        artistas.setApellido(artistasToDto.apellido());
        artistas.setTipo(artistasToDto.tipo());
        artistas.setDescripcion(artistasToDto.descripcion());
        return artistas;
    }
}
