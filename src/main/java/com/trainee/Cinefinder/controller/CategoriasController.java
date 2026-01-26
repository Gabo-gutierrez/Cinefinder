package com.trainee.Cinefinder.controller;

import com.trainee.Cinefinder.model.dto.CategoriasDto;
import com.trainee.Cinefinder.model.dto.SuccessResponse;
import com.trainee.Cinefinder.service.CategoriasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RequestMapping("/categorias")
@RequiredArgsConstructor
@RestController
public class CategoriasController {
    private final CategoriasServices categoriasServices;

    @GetMapping
    public List<CategoriasDto> consultar(){
        return categoriasServices.consultar();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<CategoriasDto> findCategoriasPorNombre(@PathVariable String nombre){
        return categoriasServices.getCategoriasPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST insertar
    @PostMapping()
    public ResponseEntity<CategoriasDto> guardar(@RequestBody CategoriasDto dto) {
        CategoriasDto creada = categoriasServices.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<CategoriasDto> actualizar(
            @PathVariable Integer id,
            @RequestBody CategoriasDto dto) {
            return ResponseEntity.ok(categoriasServices.actualizar(id, dto));
    }

    // DELETE - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> eliminar(@PathVariable Integer id, WebRequest request) {
        categoriasServices.eliminar(id);

        SuccessResponse response = SuccessResponse.builder()
                .details("la categoría con el id: " + id + ". fue eliminada correctamente.")
                .location(request.getDescription(false).replace("uri=", ""))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
