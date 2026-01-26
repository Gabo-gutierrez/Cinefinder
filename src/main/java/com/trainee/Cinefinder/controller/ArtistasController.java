package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.ArtistasDto;
import com.trainee.Cinefinder.model.dto.SuccessResponse;
import com.trainee.Cinefinder.service.ArtistasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

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
  public ResponseEntity<ArtistasDto> findArtistaByNombre(@PathVariable Long dni){
    return artistasServices.getArtistasPorDni(dni)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping()
  public ResponseEntity<ArtistasDto> crearArtista(@RequestBody ArtistasDto dto){
    ArtistasDto creada = artistasServices.guardarArtista(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(creada);
  }

  @PutMapping("/{dni}")
  public ResponseEntity<ArtistasDto> actualizarArtista(
          @PathVariable Long dni,
          @RequestBody ArtistasDto dto) {
    return ResponseEntity.ok(artistasServices.actualizarArtista(dni, dto));
  }

  @DeleteMapping("/{dni}")
  public ResponseEntity<SuccessResponse> eliminarArtista(@PathVariable Long dni, WebRequest request){
    artistasServices.eliminarArtista(dni);

    SuccessResponse response = SuccessResponse.builder()
            .details("el artista con el id: " + dni + ". fue eliminado correctamente.")
            .location(request.getDescription(false).replace("uri=", ""))
            .build();

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
  }
}
