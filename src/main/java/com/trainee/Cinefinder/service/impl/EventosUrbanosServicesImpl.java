package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.exceptions.RecursoNoEncontradoException;
import com.trainee.Cinefinder.exceptions.eventosUrbanos.EventoUrbanoNoActualizadaException;
import com.trainee.Cinefinder.exceptions.eventosUrbanos.EventoUrbanoNoEliminadaException;
import com.trainee.Cinefinder.exceptions.eventosUrbanos.EventoUrbanoTituloYaExistenteException;
import com.trainee.Cinefinder.mapper.EventosUrbanosMapper;
import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.EventosUrbanos;
import com.trainee.Cinefinder.model.dto.EventosUrbanosDto;
import com.trainee.Cinefinder.repository.CategoriaRepository;
import com.trainee.Cinefinder.repository.EventoUrbanoRepository;
import com.trainee.Cinefinder.service.EventosUrbanosServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventosUrbanosServicesImpl implements EventosUrbanosServices {
    private final EventoUrbanoRepository eventosUrbanosRepositorio;
    private final CategoriaRepository categoriasRespositorio;

    @Override
    public List<EventosUrbanosDto> consultar(){
        return eventosUrbanosRepositorio.findAll()
                .stream()
                .map(EventosUrbanosMapper::EventosUrbanosToDto)
                .toList();
    }

    @Override
    public Optional<EventosUrbanosDto> getEventosUrbanosPorTitutlo(String titulo) {
        EventosUrbanos eventoUrbano = eventosUrbanosRepositorio.findByTitulo(titulo)
                .orElseThrow(() -> new RecursoNoEncontradoException("EventoUrbano con el titulo: " + titulo + " no se encuentra."));
        return Optional.of(EventosUrbanosMapper.EventosUrbanosToDto(eventoUrbano));
    }

    @Override
    public EventosUrbanosDto guardar(EventosUrbanosDto dto){
        Optional<EventosUrbanos> existente = eventosUrbanosRepositorio.findByTitulo(dto.titulo());
        if (existente.isPresent()){
            throw new EventoUrbanoTituloYaExistenteException(dto.titulo());
        }
        else {
            EventosUrbanos eventoUrbano = EventosUrbanosMapper.EventosUrbanosToEntity(dto);
            eventoUrbano = eventosUrbanosRepositorio.save(eventoUrbano);
            return EventosUrbanosMapper.EventosUrbanosToDto(eventoUrbano);
        }
    }

    @Override
    public EventosUrbanosDto actualizar(Integer id, EventosUrbanosDto dto) {
        try{
            EventosUrbanos eventoUrbano = eventosUrbanosRepositorio.findById(id)
                    .orElseThrow(() -> new RecursoNoEncontradoException("EventoUrbano con id: " + id + " no encontrada"));

            Categorias categoria = categoriasRespositorio.findById(dto.categoria_id())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Categoría con id: " + dto.categoria_id() + " no encontrada"));

            eventoUrbano.setTitulo(dto.titulo());
            eventoUrbano.setDescripcion(dto.descripcion());
            eventoUrbano.setFecha(dto.fecha());
            eventoUrbano.setLugar(dto.lugar());
            eventoUrbano.setCategorias_id(categoria);
            return EventosUrbanosMapper.EventosUrbanosToDto(eventoUrbano);
        }
        catch (Exception e){
            throw new EventoUrbanoNoActualizadaException(id, e.getMessage());
        }
    }

    @Override
    public Void eliminar(Integer id) {
        try {
            if (!eventosUrbanosRepositorio.existsById(id)){
                throw new RecursoNoEncontradoException("EventoUrbano con el ID:" + id + " no se encuentra.");
            }
            categoriasRespositorio.deleteById(id);
            return null;
        }
        catch (Exception e){
            throw new EventoUrbanoNoEliminadaException(id, e.getMessage());
        }
    }
}
