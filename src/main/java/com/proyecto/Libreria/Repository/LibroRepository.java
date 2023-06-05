package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity,Long> {
}
