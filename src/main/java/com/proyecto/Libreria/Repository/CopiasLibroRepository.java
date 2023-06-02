package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.CopiasLibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopiasLibroRepository extends JpaRepository<CopiasLibroEntity,Long> {
}
