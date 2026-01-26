package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.ObrasDto;
import com.trainee.Cinefinder.model.dto.SuccessResponse;
import com.trainee.Cinefinder.service.ObrasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RequestMapping("/Obras")
@RequiredArgsConstructor
@RestController
public class ObrasController {
    private final ObrasServices ObrasServices;

    @GetMapping
    public List<ObrasDto> consultar(){
        return ObrasServices.consultar();
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<ObrasDto> findObraByTitulo(@PathVariable String titulo){
        return ObrasServices.getObrasPorTitutlo(titulo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<ObrasDto> guardar(@RequestBody ObrasDto dto){
        ObrasDto creada = ObrasServices.guardar(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObrasDto> actualizar(
            @PathVariable Integer id,
            @RequestBody ObrasDto dto) {
        return ResponseEntity.ok(ObrasServices.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> eliminar(@PathVariable Integer id, WebRequest request){
        ObrasServices.eliminar(id);

        SuccessResponse response = SuccessResponse.builder()
                .details("la obra con el id: " + id + ". fue eliminada correctamente.")
                .location(request.getDescription(false).replace("uri=", ""))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
