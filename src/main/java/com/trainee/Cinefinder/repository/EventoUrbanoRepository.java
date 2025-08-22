package com.trainee.Cinefinder.repository;

import com.trainee.Cinefinder.model.EventosUrbanos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoUrbanoRepository extends JpaRepository<EventosUrbanos, Integer> {
    @Query("SELECT e FROM EventosUrbanos e WHERE e.titulo = :titulo")
    Optional<EventosUrbanos> findByTitulo (String titulo);
}