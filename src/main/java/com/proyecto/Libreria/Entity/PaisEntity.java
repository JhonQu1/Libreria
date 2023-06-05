package com.proyecto.Libreria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    //@OneToMany(mappedBy = "paisId",cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "autores",unique = false)
    @JsonIgnoreProperties("autores")
    //@JsonManagedReference
    private List<AutorEntity> autores;

}
