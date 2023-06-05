package com.proyecto.Libreria.Services;

import com.proyecto.Libreria.Entity.AutorEntity;
import com.proyecto.Libreria.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresServiceImpl implements AutoresService{

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorEntity> consultaTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<AutorEntity> consultaPorId(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public AutorEntity insertarAutor(AutorEntity autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void EliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public AutorEntity ModificarAutor(AutorEntity autor) {
        return autorRepository.save(autor);
    }
}
