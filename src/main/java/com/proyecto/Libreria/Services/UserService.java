package com.proyecto.Libreria.Services;

import com.proyecto.Libreria.Entity.LibroEntity;

import java.util.List;

public interface UserService {

    List<LibroEntity> buscarLibro();
    String saludar();
}
