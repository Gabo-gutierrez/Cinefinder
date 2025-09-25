package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.mapper.CategoriasMapper;
import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.dto.CategoriasDto;
import com.trainee.Cinefinder.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CategoriasServicesImplTest {

    @Mock
    CategoriaRepository categoriaRepository;

    CategoriasMapper categoriasMapper = mock(CategoriasMapper.class);

    @InjectMocks
    CategoriasServicesImpl categoriasServicesImpl;



    @Test
    void getCategorias() {
        //given
        var categoria1 = new Categorias(1, "Drama");
        var categoria2 = new Categorias(2, "Terror");
        var categoriaDto1 = new CategoriasDto(1, "Drama");
        var categoriaDto2 = new CategoriasDto(2, "Terror");


        //when
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(categoria1, categoria2));

        List<CategoriasDto> response = categoriasServicesImpl.getCategorias();
        //then

        assertEquals(response.get(0).id(), categoriaDto1.id());
        assertEquals(response.get(1).id(), categoriaDto2.id());

    }

    @Test
    void getCategoriasPorNombre() {
    }

    @Test
    void guardarCategoria() {
    }

    @Test
    void actualizarCategoria() {
    }

    @Test
    void eliminarCategoria() {
    }

    private List<Categorias> categoriasList (){
        List<Categorias> categorias1 = new ArrayList<>();
        Categorias categorias2 = Categorias.builder()
                .id(1)
                .nombre("terror")
                .build();
        categorias1.add(categorias2);
        return categorias1;
    }}