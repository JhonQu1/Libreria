package com.proyecto.Libreria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="paises")
public class PaisEntity {
    @Id
    @Column(name="paisId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "paisId", cascade = CascadeType.ALL)
    @Column(name="autorId")
    private List<AutorEntity> autorId;

}
