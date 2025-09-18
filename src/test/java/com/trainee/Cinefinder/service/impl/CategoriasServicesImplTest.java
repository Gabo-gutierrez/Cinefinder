package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.mapper.CategoriasMapper;
import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.dto.CategoriasDto;
import com.trainee.Cinefinder.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class CategoriasServicesImplTest {

    @Mock
    CategoriaRepository categoriaRepository;

    @Mock
    CategoriasMapper categoriasMapper;

    @Mock
    Categorias categorias;

    @InjectMocks
    CategoriasServicesImpl categoriasServicesImpl;

    @BeforeEach
    void setUp(){
        when(categoriaRepository.findAll()).thenReturn(categoriasList());
    }

    @Test
    void getCategorias() {
        //given
        //when
        List<CategoriasDto> response = categoriasServicesImpl.getCategorias();
        //then

        assertNotNull(response);
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