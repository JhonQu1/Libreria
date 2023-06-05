package com.proyecto.Libreria.Services;

import com.proyecto.Libreria.Entity.AutorEntity;
import com.proyecto.Libreria.Entity.LibroEntity;

import java.util.List;
import java.util.Optional;

public interface LibrosService {
    List<LibroEntity> consultaTodos();
    Optional<LibroEntity> consultaPorId(Long id);
    LibroEntity insertarLibro(LibroEntity libro);
    void EliminarLibro(Long id);
    LibroEntity ModificarLibro(LibroEntity libro);

}
