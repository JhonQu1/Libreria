package com.proyecto.Libreria.Services;

import com.proyecto.Libreria.Entity.LibroEntity;
import com.proyecto.Libreria.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosServiceImpl implements LibrosService{

    @Autowired
    private LibroRepository libroRepository;
    @Override
    public List<LibroEntity> consultaTodos() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<LibroEntity> consultaPorId(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public LibroEntity insertarLibro(LibroEntity libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void EliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public LibroEntity ModificarLibro(LibroEntity libro) {
    return libroRepository.save(libro);
    }


}
