package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.AutorEntity;
import com.proyecto.Libreria.Entity.LibroEntity;
import com.proyecto.Libreria.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity,Long> {

    Optional<LibroEntity> findBytitulo(String titulo);
    Optional<LibroEntity> findBynombreAutor(String nombreAutor);

}
