package com.trainee.Cinefinder.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table (name = "peliculas")
public class Peliculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @Column (name = "titulo")
    private String titulo;
    @Column (name = "sipnosis")
    private String sipnosis;
    @Column (name = "duracion")
    private Integer duracion;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categorias_id;


}
