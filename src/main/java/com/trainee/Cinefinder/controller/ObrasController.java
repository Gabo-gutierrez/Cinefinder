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
    public List<ObrasDto> getObras(){
        return ObrasServices.getObras();
    }

    @GetMapping("/{titulo}")
    public Optional<ObrasDto> findObraByTitulo(@PathVariable String titulo){
        return ObrasServices.getObrasPorTitutlo(titulo);
    }

    @PostMapping()
    public ResponseEntity<ObrasDto> crearObra(@RequestBody ObrasDto dto){
        ObrasDto creada = ObrasServices.guardarObra(dto);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObrasDto> actualizarObra(
            @PathVariable Integer id,
            @RequestBody ObrasDto dto) {
        return ResponseEntity.ok(ObrasServices.actualizarObra(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarObra(@PathVariable Integer id){
        return ResponseEntity.ok(ObrasServices.eliminarObra(id));
    }
}
