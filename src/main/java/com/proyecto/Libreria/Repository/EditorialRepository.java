package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.EditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<EditorialEntity,Long> {
}
