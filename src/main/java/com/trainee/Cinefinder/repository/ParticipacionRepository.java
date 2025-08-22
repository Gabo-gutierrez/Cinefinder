package com.trainee.Cinefinder.repository;

import com.trainee.Cinefinder.model.Participaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipacionRepository extends JpaRepository<Participaciones, Long> {
    @Query("SELECT p FROM Participaciones p WHERE p.tipoEvento like :tipoEvento")
    Optional<Participaciones> findByTipoEvento (String tipoEvento);
}
