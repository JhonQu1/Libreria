package com.proyecto.Libreria.Services;

import com.proyecto.Libreria.Entity.UsuarioEntity;
import com.proyecto.Libreria.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {


    @Autowired

    private UsuarioRepository usuarioRepository;


    @Override
    public List<UsuarioEntity> consultaTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> consultaPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioEntity insertarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void EliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioEntity ModificarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }
}
