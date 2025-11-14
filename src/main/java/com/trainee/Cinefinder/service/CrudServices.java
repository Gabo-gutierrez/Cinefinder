package com.trainee.Cinefinder.service;

import java.util.List;
import java.util.Optional;

public interface CrudServices<T, ID> {
    List<T> consultar();
    T guardar(T dto);
    T actualizar(ID id, T dto);
    Void eliminar(ID id);
}
