package com.trainee.Cinefinder.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table (name = "obras")
public class Obras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @Column (name = "titulo")
    private String titulo;
    @Column (name = "descripcion")
    private String descripcion;
    @Column (name = "duracion")
    private Integer duracion;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categorias_id;
}
