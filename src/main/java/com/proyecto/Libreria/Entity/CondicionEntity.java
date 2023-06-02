package com.proyecto.Libreria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="condiciones")
public class CondicionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "condicion",unique = false)
    private String condicion;

    @OneToOne(mappedBy = "condicion")
    private CopiasLibroEntity copiasLibro;


}
