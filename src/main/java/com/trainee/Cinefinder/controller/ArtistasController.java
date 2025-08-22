package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.ArtistasDto;
import com.trainee.Cinefinder.service.ArtistasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/artistas")
@RequiredArgsConstructor
@RestController
public class ArtistasController {
  private final ArtistasServices artistasServices;

  @GetMapping
  public List<ArtistasDto> getArtistas(){
    return artistasServices.getArtistas();
  }

  @GetMapping("/{dni}")
  public Optional<ArtistasDto> findArtistaByNombre(@PathVariable Long dni){
    return artistasServices.getArtistasPorDni(dni);
  }

  @PostMapping()
  public ResponseEntity<ArtistasDto> crearArtista(@RequestBody ArtistasDto dto){
    ArtistasDto creada = artistasServices.guardarArtista(dto);
    return new ResponseEntity<>(creada, HttpStatus.CREATED);
  }

  @PutMapping("/{dni}")
  public ResponseEntity<ArtistasDto> actualizarArtista(
          @PathVariable Long dni,
          @RequestBody ArtistasDto dto) {
    return ResponseEntity.ok(artistasServices.actualizarArtista(dni, dto));
  }

  @DeleteMapping("/{dni}")
  public ResponseEntity<Void> eliminarArtista(@PathVariable Long dni){
    return ResponseEntity.ok(artistasServices.eliminarArtista(dni));
  }
}
