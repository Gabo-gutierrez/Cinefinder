package com.trainee.Cinefinder.service.impl;

import com.trainee.Cinefinder.exceptions.RecursoNoActualizadoException;
import com.trainee.Cinefinder.exceptions.RecursoNoEliminadoException;
import com.trainee.Cinefinder.exceptions.RecursoNoEncontradoException;
import com.trainee.Cinefinder.exceptions.RecursoYaExistenteException;
import com.trainee.Cinefinder.mapper.CategoriasMapper;
import com.trainee.Cinefinder.model.Categorias;
import com.trainee.Cinefinder.model.dto.CategoriasDto;
import com.trainee.Cinefinder.repository.CategoriaRepository;
import com.trainee.Cinefinder.service.CategoriasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriasServicesImpl implements CategoriasServices {
    private final CategoriaRepository categoriaRepositorio;

    @Override
    public List<CategoriasDto> consultar() {
        return categoriaRepositorio.findAll()
                .stream()
                .map(CategoriasMapper::categoriasToDto)
                .toList();
    }

    @Override
    public Optional<CategoriasDto> getCategoriasPorNombre(String nombre) {
        Categorias categoria = categoriaRepositorio.findByNombre(nombre)
                .orElseThrow(() -> new RecursoNoEncontradoException("categoria con nombre: " + nombre + " no econtrada."));

        return Optional.of(CategoriasMapper.categoriasToDto(categoria));
    }

    @Override
    public CategoriasDto guardar(CategoriasDto dto) {
        Optional<Categorias> existente = categoriaRepositorio.findByNombre(dto.nombre());
        if (existente.isPresent()) {
            throw new RecursoYaExistenteException("Categoria", dto.nombre());
        }
        else{
            Categorias categoria = CategoriasMapper.categoriasToEntity(dto);
            categoria = categoriaRepositorio.save(categoria);
            return CategoriasMapper.categoriasToDto(categoria);
        }
    }

    @Override
    public CategoriasDto actualizar(Integer id, CategoriasDto dto) {
        try {
            Categorias categoria = categoriaRepositorio.findById(id)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Categoría no encontrada con ID: " + id));

            categoria.setNombre(dto.nombre());
            categoria = categoriaRepositorio.save(categoria);

            return CategoriasMapper.categoriasToDto(categoria);
        }
        catch (Exception e){
            throw new RecursoNoActualizadoException("Categoria", id);
        }
    }

    @Override
    public Void eliminar(Integer id) {
//        if (!categoriaRepositorio.existsById(id)) {
//            throw new RecursoNoEncontradoException("Categoría no encontrada con ID: " + id);
//        }
        try {
//            categoriaRepositorio.deleteById(id);
            throw new RecursoNoEliminadoException("categoria", id);
        } catch (Exception e) {
            throw new RecursoNoEliminadoException("categoria", id);
        }
//        return null;
    }
}
