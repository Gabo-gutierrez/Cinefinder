package com.trainee.Cinefinder.repository;

import com.trainee.Cinefinder.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {
    @Query("SELECT c FROM Categorias c WHERE c.nombre = :nombre")
    Optional<Categorias> findByNombre (String nombre);
}