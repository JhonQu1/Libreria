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
    @Column(name="generoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreGenero")
    private String nombreGenero;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libros",
            joinColumns = @JoinColumn(name = "generoId"),
            inverseJoinColumns = @JoinColumn(name = "libroId"))
    @Column(name="listaGeneros")
    private List<LibroEntity> listaGeneros;
}
