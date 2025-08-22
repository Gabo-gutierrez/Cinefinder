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
    public List<PeliculasDto> getPeliculas(){
        return peliculasServices.getPeliculas();
    }

    @GetMapping("/{titulo}")
    public Optional<PeliculasDto> findPeliculaByTitulo(@PathVariable String titulo){
        return peliculasServices.getPeliculasPorTitutlo(titulo);
    }

    @PostMapping()
    public ResponseEntity<PeliculasDto> crearPelicula(@RequestBody PeliculasDto dto){
        PeliculasDto creada = peliculasServices.guardarPelicula(dto);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculasDto> actualizarPelicula(
            @PathVariable Integer id,
            @RequestBody PeliculasDto dto) {
        return ResponseEntity.ok(peliculasServices.actualizarPelicula(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Integer id){
        return ResponseEntity.ok(peliculasServices.eliminarPelicula(id));
    }
}
