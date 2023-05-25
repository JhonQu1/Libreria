package com.proyecto.Libreria.Entity;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class PrestamoEntity {
    @Id
    private int id;
    private int idUsuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;


}
