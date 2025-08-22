package com.trainee.Cinefinder.mapper;

import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.Obras;
import com.trainee.Cinefinder.model.dto.ObrasDto;
import org.springframework.stereotype.Component;

@Component
public class ObrasMapper {
    public static ObrasDto ObrasToDto (Obras Obras){
        return new ObrasDto(
                Obras.getId(),
                Obras.getTitulo(),
                Obras.getDescripcion(),
                Obras.getDuracion(),
                Obras.getCategorias_id().getId()
        );
    }

    public static Obras ObrasToEntity (ObrasDto ObrasToDto){
        Obras Obras = new Obras();
        Obras.setId(ObrasToDto.id());
        Obras.setTitulo(ObrasToDto.titulo());
        Obras.setDescripcion(ObrasToDto.descripcion());
        Obras.setDuracion(ObrasToDto.duracion());

        Categorias categoria = new Categorias();
        categoria.setId(ObrasToDto.categoria_id());
        Obras.setCategorias_id(categoria);

        return Obras;
    }
}
