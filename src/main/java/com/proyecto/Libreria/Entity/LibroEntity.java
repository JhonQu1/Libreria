package com.proyecto.Libreria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LibroEntity {
    @Id
    private int id;
    private int idUsuario;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private String genero;


}
