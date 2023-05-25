package com.proyecto.Libreria.Entity;

import jakarta.persistence.Id;

public class UsuarioEntity {
    @Id
    private int id;
    private String nombre;
    private boolean autenticado;
    private String telefono;


}
