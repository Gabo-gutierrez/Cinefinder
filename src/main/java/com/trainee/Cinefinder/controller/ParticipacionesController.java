package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.ParticipacionesDto;
import com.trainee.Cinefinder.service.ParticipacionesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
  public Optional<ParticipacionesDto> findParticipacionByTipo(@PathVariable String tipoEvento){
    return participacionesServices.getParticipacionesPorTipo(tipoEvento);
  }

  @PostMapping()
  public ResponseEntity<ParticipacionesDto> guardar(@RequestBody ParticipacionesDto dto){
    ParticipacionesDto creada = participacionesServices.guardar(dto);
    return new ResponseEntity<>(creada, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ParticipacionesDto> actualizar(
          @PathVariable Integer id,
          @RequestBody ParticipacionesDto dto) {
    return ResponseEntity.ok(participacionesServices.actualizar(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Integer id){
    return ResponseEntity.ok(participacionesServices.eliminar(id));
  }
}
