package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.PeliculasDto;
import com.trainee.Cinefinder.service.PeliculasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/peliculas")
@RequiredArgsConstructor
@RestController
public class PeliculasController {
    private final PeliculasServices peliculasServices;

    @GetMapping
    public List<PeliculasDto> consultar(){
        return peliculasServices.consultar();
    }

    @GetMapping("/{titulo}")
    public Optional<PeliculasDto> findPeliculaByTitulo(@PathVariable String titulo){
        return peliculasServices.getPeliculasPorTitutlo(titulo);
    }

    @PostMapping()
    public ResponseEntity<PeliculasDto> guardar(@RequestBody PeliculasDto dto){
        PeliculasDto creada = peliculasServices.guardar(dto);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculasDto> actualizar(
            @PathVariable Integer id,
            @RequestBody PeliculasDto dto) {
        return ResponseEntity.ok(peliculasServices.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        return ResponseEntity.ok(peliculasServices.eliminar(id));
    }
}
