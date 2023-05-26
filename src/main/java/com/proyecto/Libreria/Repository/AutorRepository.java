package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity,Long> {
}
