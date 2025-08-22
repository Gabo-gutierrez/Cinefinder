package com.trainee.Cinefinder.repository;

import com.trainee.Cinefinder.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas, Integer> {
    @Query("SELECT p FROM Peliculas p WHERE p.titulo = :titulo")
    Optional<Peliculas> findByTitulo (String titulo);
}