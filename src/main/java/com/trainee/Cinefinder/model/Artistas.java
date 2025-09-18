package com.trainee.Cinefinder.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigInteger;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "artistas")
public class Artistas {
    @Id
    @Column (name = "dni")
    @NotNull
    @NotBlank
    @Valid
    private Long dni;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellido")
    private String apellido;
    @Column (name = "tipo")
    private String tipo;
    @Column (name = "descripcion")
    private String descripcion;
}
