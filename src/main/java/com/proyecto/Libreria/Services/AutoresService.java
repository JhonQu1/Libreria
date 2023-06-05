package com.proyecto.Libreria.Services;

import com.proyecto.Libreria.Entity.AutorEntity;

import java.util.List;
import java.util.Optional;

public interface AutoresService {

    List<AutorEntity> consultaTodos();
    Optional<AutorEntity> consultaPorId(Long id);
    AutorEntity insertarAutor(AutorEntity autor);
    void EliminarAutor(Long id);
    AutorEntity ModificarAutor(AutorEntity autor);

}
