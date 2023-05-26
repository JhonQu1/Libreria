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
@Table(name="generos")
public class GeneroEntity {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreGenero")
    private String nombreGenero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "generoId")
    private LibroEntity generoId;
}
