package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.PeliculasDto;
import com.trainee.Cinefinder.model.dto.SuccessResponse;
import com.trainee.Cinefinder.service.PeliculasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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
    public ResponseEntity<PeliculasDto> findPeliculaByTitulo(@PathVariable String titulo){
        return peliculasServices.getPeliculasPorTitutlo(titulo)
                .map(ResponseEntity :: ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<PeliculasDto> guardar(@RequestBody PeliculasDto dto){
        PeliculasDto creada = peliculasServices.guardar(dto);
//        return new ResponseEntity<>(creada, HttpStatus.CREATED);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculasDto> actualizar(
            @PathVariable Integer id,
            @RequestBody PeliculasDto dto) {
        return ResponseEntity.ok(peliculasServices.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> eliminar(@PathVariable Integer id, WebRequest request){
//        return ResponseEntity.ok(peliculasServices.eliminar(id));
        peliculasServices.eliminar(id);

        SuccessResponse response = SuccessResponse.builder()
                .details("la pelicula con el id: " + id + ". fue eliminada correctamente.")
                .location(request.getDescription(false).replace("uri=", ""))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
