package com.trainee.Cinefinder.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity (name = "Participaciones")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Table (name = "participaciones")
public class Participaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @Column (name = "artista_dni")
    @NotNull
    @NonNull
    @NotBlank
    @Valid
    private Long artista_dni;
    @Column (name = "tipo_evento")
    private String tipoEvento;
    @Column (name = "evento_id")
    private Integer evento_id;
}
