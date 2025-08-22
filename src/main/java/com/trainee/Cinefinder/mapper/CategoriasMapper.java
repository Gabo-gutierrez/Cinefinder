package com.trainee.Cinefinder.mapper;

import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.dto.CategoriasDto;
import org.springframework.stereotype.Component;

@Component
public class CategoriasMapper {
    public static CategoriasDto categoriasToDto (Categorias categorias){
        return new CategoriasDto (
                categorias.getId(),
                categorias.getNombre()
        );
    }
    public static Categorias categoriasToEntity (CategoriasDto categoriasToDto){
        Categorias categorias = new Categorias();
        categorias.setId(categoriasToDto.id());
        categorias.setNombre(categoriasToDto.nombre());
        return categorias;
    }
}
