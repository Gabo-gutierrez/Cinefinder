package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.exceptions.RecursoNoEncontradoException;
import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.dto.CategoriasDto;
import com.trainee.Cinefinder.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoriasServicesImplTest {

    @Mock
    CategoriaRepository categoriaRepository;

    @InjectMocks
    CategoriasServicesImpl categoriasServicesImpl;

    @Test
    void getCategorias() {
        //given
        var categoria1 = new Categorias(1, "Drama");
        var categoria2 = new Categorias(2, "Terror");
        var categoriaDto1 = new CategoriasDto(1, "Drama");
        var categoriaDto2 = new CategoriasDto(2, "Terror");

        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(categoria1, categoria2));

        //when
        List<CategoriasDto> response = categoriasServicesImpl.consultar();

        //then
        assertEquals(2, response.size());
        assertEquals(response.get(0), categoriaDto1);
        assertEquals(response.get(1), categoriaDto2);
        verify(categoriaRepository).findAll();
    }

    @Test
    void getCategoriasPorNombreCuandoExiste() {
        var categoria1 = new Categorias(1, "Drama");
        var categoria2 = new Categorias(2, "Terror");

        when(categoriaRepository.findByNombre("Drama")).thenReturn(Optional.of(categoria1));
        when(categoriaRepository.findByNombre("Terror")).thenReturn(Optional.of(categoria2));

        Optional<CategoriasDto> respuesta = categoriasServicesImpl.getCategoriasPorNombre("Drama");
        Optional<CategoriasDto> respuesta1 = categoriasServicesImpl.getCategoriasPorNombre("Terror");

        assertTrue(respuesta.isPresent());
        assertEquals(respuesta.get().nombre(), categoria1.getNombre());
        assertTrue(respuesta1.isPresent());
        assertEquals(respuesta1.get().nombre(), categoria2.getNombre());
        verify(categoriaRepository).findByNombre("Drama");
        verify(categoriaRepository).findByNombre("Terror");

    }

    @Test
    void getCategoriasPorNombreCuandoNoExiste() {
        when(categoriaRepository.findByNombre("Comedia")).thenReturn(Optional.empty());

        assertThrows(RecursoNoEncontradoException.class,
                ()  -> categoriasServicesImpl.getCategoriasPorNombre("Comedia")
        );

        verify(categoriaRepository).findByNombre("Comedia");
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