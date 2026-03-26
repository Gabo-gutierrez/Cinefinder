package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.exceptions.RecursoNoActualizadoException;
import com.trainee.Cinefinder.exceptions.RecursoNoEliminadoException;
import com.trainee.Cinefinder.exceptions.RecursoNoEncontradoException;
import com.trainee.Cinefinder.exceptions.RecursoYaExistenteException;
import com.trainee.Cinefinder.mapper.ObrasMapper;
import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.Obras;
import com.trainee.Cinefinder.model.dto.ObrasDto;
import com.trainee.Cinefinder.repository.CategoriaRepository;
import com.trainee.Cinefinder.repository.ObraRepository;
import com.trainee.Cinefinder.service.ObrasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObrasServicesImpl implements ObrasServices {
    private final ObraRepository ObrasRepositorio;
    private final CategoriaRepository categoriasRespositorio;

    @Override
    public List<ObrasDto> consultar(){
        return ObrasRepositorio.findAll()
                .stream()
                .map(ObrasMapper::ObrasToDto)
                .toList();
    }

    @Override
    public Optional<ObrasDto> getObrasPorTitutlo(String titulo) {
        Obras Obra = ObrasRepositorio.findByTitulo(titulo)
                .orElseThrow(() -> new RecursoNoEncontradoException("Obra con el titulo: " + titulo + " no se encuentra."));
        return Optional.of(ObrasMapper.ObrasToDto(Obra));
    }

    @Override
    public ObrasDto guardar(ObrasDto dto){
        Optional<Obras> existente = ObrasRepositorio.findByTitulo(dto.titulo());
        if (existente.isPresent()){
            throw new RecursoYaExistenteException("Obra",dto.titulo());
        }
        else {
            Obras Obra = ObrasMapper.ObrasToEntity(dto);
            Obra = ObrasRepositorio.save(Obra);
            return ObrasMapper.ObrasToDto(Obra);
        }
    }

    @Override
    public ObrasDto actualizar(Integer id, ObrasDto dto) {
        try{
            Obras Obra = ObrasRepositorio.findById(id)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Obra con id: " + id + " no encontrada"));

            Categorias categoria = categoriasRespositorio.findById(dto.categoria_id())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Categoría con id: " + dto.categoria_id() + " no encontrada"));

            Obra.setTitulo(dto.titulo());
            Obra.setDescripcion(dto.descripcion());
            Obra.setDuracion(dto.duracion());
            Obra.setCategorias_id(categoria);
            return ObrasMapper.ObrasToDto(Obra);
        }
        catch (Exception e){
            throw new RecursoNoActualizadoException("Obra", id);
        }
    }

    @Override
    public Void eliminar(Integer id) {
        try {
            if (!ObrasRepositorio.existsById(id)){
                throw new RecursoNoEncontradoException("Obra con el ID:" + id + " no se encuentra.");
            }
            categoriasRespositorio.deleteById(id);
            return null;
        }
        catch (Exception e){
            throw new RecursoNoEliminadoException("Obra", id);
        }
    }
}
