package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity,Long> {
}
