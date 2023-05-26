package com.proyecto.Libreria.Services;

import com.proyecto.Libreria.Entity.LibroEntity;
import com.proyecto.Libreria.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<LibroEntity> buscarLibro() {
        return libroRepository.findAll();
    }

    @Override
    public String saludar() {
        return null;
    }
}
