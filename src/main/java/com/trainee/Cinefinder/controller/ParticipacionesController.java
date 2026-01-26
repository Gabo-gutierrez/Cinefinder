package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.ParticipacionesDto;
import com.trainee.Cinefinder.model.dto.SuccessResponse;
import com.trainee.Cinefinder.service.ParticipacionesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RequestMapping("/participaciones")
@RequiredArgsConstructor
@RestController
public class ParticipacionesController {
  private final ParticipacionesServices participacionesServices;

  @GetMapping
  public List<ParticipacionesDto> consultar(){
    return participacionesServices.consultar();
  }

  @GetMapping("/{tipo_evento}")
  public ResponseEntity<ParticipacionesDto> findParticipacionByTipo(@PathVariable String tipoEvento){
    return participacionesServices.getParticipacionesPorTipo(tipoEvento)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping()
  public ResponseEntity<ParticipacionesDto> guardar(@RequestBody ParticipacionesDto dto){
    ParticipacionesDto creada = participacionesServices.guardar(dto);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(creada);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ParticipacionesDto> actualizar(
          @PathVariable Integer id,
          @RequestBody ParticipacionesDto dto) {
    return ResponseEntity.ok(participacionesServices.actualizar(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<SuccessResponse> eliminar(@PathVariable Integer id, WebRequest request){
    participacionesServices.eliminar(id);

    SuccessResponse response = SuccessResponse.builder()
            .details("la participación con el id: " + id + ". fue eliminada correctamente.")
            .location(request.getDescription(false).replace("uri=", ""))
            .build();

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
  }
}
