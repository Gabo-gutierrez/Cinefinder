package com.trainee.Cinefinder.exceptions.participaciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParticipacionYaRegistradoException extends RuntimeException {
    public ParticipacionYaRegistradoException(Integer id) {
        super("La persona con el id: " + id + " ya se encuentra registrada;");
    }
}
