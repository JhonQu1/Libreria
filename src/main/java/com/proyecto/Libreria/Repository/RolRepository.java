package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity,Long> {
}
