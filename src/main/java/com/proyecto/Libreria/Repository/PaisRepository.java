package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity,Long> {
}
