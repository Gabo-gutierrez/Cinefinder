package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.ObrasDto;
import com.trainee.Cinefinder.service.ObrasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<ObrasDto> findObraByTitulo(@PathVariable String titulo){
        return ObrasServices.getObrasPorTitutlo(titulo);
    }

    @PostMapping()
    public ResponseEntity<ObrasDto> guardar(@RequestBody ObrasDto dto){
        ObrasDto creada = ObrasServices.guardar(dto);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObrasDto> actualizar(
            @PathVariable Integer id,
            @RequestBody ObrasDto dto) {
        return ResponseEntity.ok(ObrasServices.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        return ResponseEntity.ok(ObrasServices.eliminar(id));
    }
}
