package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.exceptions.RecursoNoEncontradoException;
import com.trainee.Cinefinder.exceptions.participaciones.ParticipacionNoActualizadaException;
import com.trainee.Cinefinder.exceptions.participaciones.ParticipacionNoEliminadaException;
import com.trainee.Cinefinder.mapper.ParticipacionesMapper;
import com.trainee.Cinefinder.model.Artistas;
import com.trainee.Cinefinder.model.Participaciones;
import com.trainee.Cinefinder.model.dto.ParticipacionesDto;
import com.trainee.Cinefinder.repository.ArtistaRepository;
import com.trainee.Cinefinder.repository.ParticipacionRepository;
import com.trainee.Cinefinder.service.ParticipacionesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParticipacionesServicesImpl implements ParticipacionesServices {
    private final ParticipacionRepository participacionesRepositorio;
    private final ArtistaRepository artistasRespositorio;

    @Override
    public List<ParticipacionesDto> getParticipaciones(){
        return participacionesRepositorio.findAll()
                .stream()
                .map(ParticipacionesMapper::participacionesToDto)
                .toList();
    }

    @Override
    public Optional<ParticipacionesDto> getParticipacionesPorTipo(String tipoEvento) {
        Participaciones participacion = participacionesRepositorio.findByTipoEvento(tipoEvento)
                .orElseThrow(() -> new RecursoNoEncontradoException("Participacion con el tipo de eveneto: " + tipoEvento + " no se encuentra."));
        return Optional.of(ParticipacionesMapper.participacionesToDto(participacion));
    }

    @Override
    public ParticipacionesDto guardarParticipacion(ParticipacionesDto dto){
        Participaciones participacion = ParticipacionesMapper.participacionesToEntity(dto);
        participacion = participacionesRepositorio.save(participacion);
        return ParticipacionesMapper.participacionesToDto(participacion);
    }

    @Override
    public ParticipacionesDto actualizarParticipacion(Integer id, ParticipacionesDto dto) {
        try{
            Participaciones participacion = participacionesRepositorio.findById(Long.valueOf(id))
                    .orElseThrow(() -> new RecursoNoEncontradoException("Participacion con id: " + id + " no encontrada"));

            Artistas artista = artistasRespositorio.findById(dto.artistas_dni())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Artista con dni: " + dto.artistas_dni() + " no encontrada"));

            participacion.setTipoEvento(dto.tipo_evento());
            participacion.setEvento_id(dto.evento_id());
            participacion.setArtista_dni(artista.getDni());
            return ParticipacionesMapper.participacionesToDto(participacion);
        }
        catch (Exception e){
            throw new ParticipacionNoActualizadaException(id, e.getMessage());
        }
    }

    @Override
    public Void eliminarParticipacion(Integer id) {
        try {
            if (!participacionesRepositorio.existsById(Long.valueOf(id))){
                throw new RecursoNoEncontradoException("Participacion con el ID:" + id + " no se encuentra.");
            }
            artistasRespositorio.deleteById(Long.valueOf(id));
            return null;
        }
        catch (Exception e){
            throw new ParticipacionNoEliminadaException(id, e.getMessage());
        }
    }
}
