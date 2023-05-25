package com.proyecto.Libreria.Entity;

import jakarta.persistence.Id;

public class ServicioEntity {
    @Id
    private int id;
    private String prestamo;
    private String consulta;

}
