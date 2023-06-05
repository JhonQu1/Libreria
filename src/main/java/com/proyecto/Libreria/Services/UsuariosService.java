package com.proyecto.Libreria.Services;

import com.proyecto.Libreria.Entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {


    List<UsuarioEntity> consultaTodos();
    Optional<UsuarioEntity> consultaPorId(Long id);
    UsuarioEntity insertarUsuario(UsuarioEntity libro);
    void EliminarUsuario(Long id);
    UsuarioEntity ModificarUsuario(UsuarioEntity libro);
    Optional<UsuarioEntity> consultaPornombre(String nombre);

}
