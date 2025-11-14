package com.trainee.Cinefinder.service;

import com.trainee.Cinefinder.model.dto.ObrasDto;

import java.util.List;
import java.util.Optional;

public interface ObrasServices extends CrudServices<ObrasDto, Integer>{
    Optional<ObrasDto> getObrasPorTitutlo(String titulo);
}
