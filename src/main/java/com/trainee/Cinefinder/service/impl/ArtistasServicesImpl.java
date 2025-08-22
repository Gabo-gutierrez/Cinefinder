package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.exceptions.RecursoNoEncontradoException;
import com.trainee.Cinefinder.exceptions.artistas.ArtistaNoActualizadoException;
import com.trainee.Cinefinder.exceptions.artistas.ArtistaYaRegistradoException;
import com.trainee.Cinefinder.mapper.ArtistasMapper;
import com.trainee.Cinefinder.model.Artistas;
import com.trainee.Cinefinder.model.dto.ArtistasDto;
import com.trainee.Cinefinder.repository.ArtistaRepository;
import com.trainee.Cinefinder.service.ArtistasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistasServicesImpl implements ArtistasServices {
    private final ArtistaRepository artistasRepositorio;

    @Override
    public List<ArtistasDto> getArtistas() {
        return artistasRepositorio.findAll()
                .stream()
                .map(ArtistasMapper::artistasToDto)
                .toList();
    }

    @Override
    public Optional<ArtistasDto> getArtistasPorDni(Long dni) {
        Artistas artista = artistasRepositorio.findById(dni)
                .orElseThrow(() -> new RecursoNoEncontradoException("artista con el dni: " + dni + " no ha sido encontrado."));

        return Optional.of(ArtistasMapper.artistasToDto(artista));
    }

    @Override
    public ArtistasDto guardarArtista(ArtistasDto dto) {
        Optional<Artistas> existente = artistasRepositorio.findById(dto.dni());
        if(existente.isPresent()) {
            throw new ArtistaYaRegistradoException(dto.dni());
        }
        else {
            Artistas artista = ArtistasMapper.artistasToEntity(dto);
            artista = artistasRepositorio.save(artista);
            return ArtistasMapper.artistasToDto(artista);
        }
    }

    @Override
    public ArtistasDto actualizarArtista(Long dni, ArtistasDto dto) {
        try{
            Artistas artista = artistasRepositorio.findById(dni)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Artista con el dni: " + dni + " no ha sido encontrado."));

            artista.setNombre(dto.nombre());
            artista.setApellido(dto.apellido());
            artista.setTipo(dto.tipo());
            artista.setDescripcion(dto.descripcion());
            return ArtistasMapper.artistasToDto(artista);
        }
        catch (Exception e){
            throw new ArtistaNoActualizadoException(dni, e.getMessage());
        }
    }

    @Override
    public Void eliminarArtista(Long dni) {
        if (!artistasRepositorio.existsById(dni)){
            throw new RecursoNoEncontradoException("Artista no encontrado con el DNI: " + dni);
        }
        artistasRepositorio.deleteById(dni);
        return null;
    }
}
