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
  public List<ParticipacionesDto> getParticipaciones(){
    return participacionesServices.getParticipaciones();
  }

  @GetMapping("/{tipo_evento}")
  public Optional<ParticipacionesDto> findParticipacionByTipo(@PathVariable String tipoEvento){
    return participacionesServices.getParticipacionesPorTipo(tipoEvento);
  }

  @PostMapping()
  public ResponseEntity<ParticipacionesDto> crearParticipacion(@RequestBody ParticipacionesDto dto){
    ParticipacionesDto creada = participacionesServices.guardarParticipacion(dto);
    return new ResponseEntity<>(creada, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ParticipacionesDto> actualizarParticipacion(
          @PathVariable Integer id,
          @RequestBody ParticipacionesDto dto) {
    return ResponseEntity.ok(participacionesServices.actualizarParticipacion(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarParticipacion(@PathVariable Integer id){
    return ResponseEntity.ok(participacionesServices.eliminarParticipacion(id));
  }
}
