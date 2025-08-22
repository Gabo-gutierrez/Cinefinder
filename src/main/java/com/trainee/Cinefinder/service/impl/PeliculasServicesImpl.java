package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.exceptions.RecursoNoEncontradoException;
import com.trainee.Cinefinder.exceptions.peliculas.PeliculaNoActualizadaException;
import com.trainee.Cinefinder.exceptions.peliculas.PeliculaNoEliminadaException;
import com.trainee.Cinefinder.exceptions.peliculas.PeliculaTituloYaExistenteException;
import com.trainee.Cinefinder.mapper.PeliculasMapper;
import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.Peliculas;
import com.trainee.Cinefinder.model.dto.PeliculasDto;
import com.trainee.Cinefinder.repository.CategoriaRepository;
import com.trainee.Cinefinder.repository.PeliculaRepository;
import com.trainee.Cinefinder.service.PeliculasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeliculasServicesImpl implements PeliculasServices {
    private final PeliculaRepository peliculasRepositorio;
    private final CategoriaRepository categoriasRespositorio;

    @Override
    public List<PeliculasDto> getPeliculas(){
        return peliculasRepositorio.findAll()
                .stream()
                .map(PeliculasMapper::peliculasToDto)
                .toList();
    }

    @Override
    public Optional<PeliculasDto> getPeliculasPorTitutlo(String titulo) {
        Peliculas pelicula = peliculasRepositorio.findByTitulo(titulo)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pelicula con el titulo: " + titulo + " no se encuentra."));
        return Optional.of(PeliculasMapper.peliculasToDto(pelicula));
    }

    @Override
    public PeliculasDto guardarPelicula(PeliculasDto dto){
        Optional<Peliculas> existente = peliculasRepositorio.findByTitulo(dto.titulo());
        if (existente.isPresent()){
            throw new PeliculaTituloYaExistenteException(dto.titulo());
        }
        else {
            Peliculas pelicula = PeliculasMapper.peliculasToEntity(dto);
            pelicula = peliculasRepositorio.save(pelicula);
            return PeliculasMapper.peliculasToDto(pelicula);
        }
    }

    @Override
    public PeliculasDto actualizarPelicula(Integer id, PeliculasDto dto) {
        try{
            Peliculas pelicula = peliculasRepositorio.findById(id)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Pelicula con id: " + id + " no encontrada"));

            Categorias categoria = categoriasRespositorio.findById(dto.categoria_id())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Categoría con id: " + dto.categoria_id() + " no encontrada"));

            pelicula.setTitulo(dto.titulo());
            pelicula.setSipnosis(dto.sipnosis());
            pelicula.setDuracion(dto.duracion());
            pelicula.setCategorias_id(categoria);
            return PeliculasMapper.peliculasToDto(pelicula);
        }
        catch (Exception e){
            throw new PeliculaNoActualizadaException(id, e.getMessage());
        }
    }

    @Override
    public Void eliminarPelicula(Integer id) {
        try {
            if (!peliculasRepositorio.existsById(id)){
                throw new RecursoNoEncontradoException("Pelicula con el ID:" + id + " no se encuentra.");
            }
            categoriasRespositorio.deleteById(id);
            return null;
        }
        catch (Exception e){
            throw new PeliculaNoEliminadaException(id, e.getMessage());
        }
    }
}
