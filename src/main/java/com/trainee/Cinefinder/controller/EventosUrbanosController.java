package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.EventosUrbanosDto;
import com.trainee.Cinefinder.model.dto.SuccessResponse;
import com.trainee.Cinefinder.service.EventosUrbanosServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RequestMapping("/eventosUrbanos")
@RequiredArgsConstructor
@RestController
public class EventosUrbanosController {
    private final EventosUrbanosServices eventosUrbanosServices;

    @GetMapping
    public List<EventosUrbanosDto> consultar(){
        return eventosUrbanosServices.consultar();
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<EventosUrbanosDto> findEventoUrbanoByTitulo(@PathVariable String titulo){
        return eventosUrbanosServices.getEventosUrbanosPorTitutlo(titulo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<EventosUrbanosDto> guardar(@RequestBody EventosUrbanosDto dto){
        EventosUrbanosDto creada = eventosUrbanosServices.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventosUrbanosDto> actualizar(
            @PathVariable Integer id,
            @RequestBody EventosUrbanosDto dto) {
        return ResponseEntity.ok(eventosUrbanosServices.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> eliminar(@PathVariable Integer id, WebRequest request){
        eventosUrbanosServices.eliminar(id);

        SuccessResponse response = SuccessResponse.builder()
                .details("el evento con el id: " + id + ". fue eliminado correctamente.")
                .location(request.getDescription(false).replace("uri=", ""))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
