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
public class ConsultaEntity {

    @Id
    private int id;
    private int idUsuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

}
