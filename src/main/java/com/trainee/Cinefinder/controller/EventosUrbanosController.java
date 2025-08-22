package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.EventosUrbanosDto;
import com.trainee.Cinefinder.service.EventosUrbanosServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/eventosUrbanos")
@RequiredArgsConstructor
@RestController
public class EventosUrbanosController {
    private final EventosUrbanosServices eventosUrbanosServices;

    @GetMapping
    public List<EventosUrbanosDto> getEventosUrbanos(){
        return eventosUrbanosServices.getEventosUrbanos();
    }

    @GetMapping("/{titulo}")
    public Optional<EventosUrbanosDto> findEventoUrbanoByTitulo(@PathVariable String titulo){
        return eventosUrbanosServices.getEventosUrbanosPorTitutlo(titulo);
    }

    @PostMapping()
    public ResponseEntity<EventosUrbanosDto> crearEventoUrbano(@RequestBody EventosUrbanosDto dto){
        EventosUrbanosDto creada = eventosUrbanosServices.guardarEventoUrbano(dto);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventosUrbanosDto> actualizarEventoUrbano(
            @PathVariable Integer id,
            @RequestBody EventosUrbanosDto dto) {
        return ResponseEntity.ok(eventosUrbanosServices.actualizarEventoUrbano(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEventoUrbano(@PathVariable Integer id){
        return ResponseEntity.ok(eventosUrbanosServices.eliminarEventoUrbano(id));
    }
}
