package com.trainee.Cinefinder.repository;

import com.trainee.Cinefinder.model.Obras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObraRepository extends JpaRepository<Obras, Integer> {
    @Query("SELECT o FROM Obras o WHERE o.titulo = :titulo")
    Optional<Obras> findByTitulo (String titulo);
}