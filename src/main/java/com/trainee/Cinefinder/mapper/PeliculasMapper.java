package com.trainee.Cinefinder.mapper;

import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.Peliculas;
import com.trainee.Cinefinder.model.dto.PeliculasDto;
import org.springframework.stereotype.Component;

@Component
public class PeliculasMapper {
    public static PeliculasDto peliculasToDto (Peliculas peliculas){
        return new PeliculasDto(
                peliculas.getId(),
                peliculas.getTitulo(),
                peliculas.getSipnosis(),
                peliculas.getDuracion(),
                peliculas.getCategorias_id().getId()
        );
    }

    public static Peliculas peliculasToEntity (PeliculasDto peliculasToDto){
        Peliculas peliculas = new Peliculas();
        peliculas.setId(peliculasToDto.id());
        peliculas.setTitulo(peliculasToDto.titulo());
        peliculas.setSipnosis(peliculasToDto.sipnosis());
        peliculas.setDuracion(peliculasToDto.duracion());

        Categorias categoria = new Categorias();
        categoria.setId(peliculasToDto.categoria_id());
        peliculas.setCategorias_id(categoria);

        return peliculas;
    }
}
