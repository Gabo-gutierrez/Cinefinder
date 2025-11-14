package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.CategoriasDto;
import com.trainee.Cinefinder.service.CategoriasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/categorias")
@RequiredArgsConstructor
@RestController
public class CategoriasController {
    private final CategoriasServices categoriasServices;

    @GetMapping
    public List<CategoriasDto> consultar(){
        return categoriasServices.consultar();
    }
    @GetMapping("/{nombre}")
    public Optional<CategoriasDto> findCategoriasPorNombre(@PathVariable String nombre){
        return categoriasServices.getCategoriasPorNombre(nombre);
    }

    // POST insertar
    @PostMapping()
    public ResponseEntity<CategoriasDto> guardar(@RequestBody CategoriasDto dto) {
        CategoriasDto creada = categoriasServices.guardar(dto);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<CategoriasDto> actualizar(
            @PathVariable Integer id,
            @RequestBody CategoriasDto dto) {
            return ResponseEntity.ok(categoriasServices.actualizar(id, dto));
    }

    // DELETE - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriasServices.eliminar(id));
    }
}
