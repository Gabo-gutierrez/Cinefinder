package com.trainee.Cinefinder.repository;

import com.trainee.Cinefinder.model.Artistas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artistas, Long> {
}
