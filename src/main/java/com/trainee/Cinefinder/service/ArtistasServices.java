package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.ArtistasDto;

import java.util.List;
import java.util.Optional;

public interface ArtistasServices {
    List<ArtistasDto> getArtistas();
    Optional<ArtistasDto> getArtistasPorDni(Long dni);

    ArtistasDto guardarArtista(ArtistasDto dto);
    ArtistasDto actualizarArtista(Long dni, ArtistasDto dto);
    Void eliminarArtista(Long dni);
}
