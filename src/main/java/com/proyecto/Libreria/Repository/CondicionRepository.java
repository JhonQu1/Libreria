package com.proyecto.Libreria.Repository;

import com.proyecto.Libreria.Entity.CondicionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionRepository extends JpaRepository <CondicionEntity,Long>{
}
