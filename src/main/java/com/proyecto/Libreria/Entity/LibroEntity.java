package com.biblioteca.demo.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LibroEntity {
    private int id;
    private int idUsuario;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private String genero;


}
