package com.proyecto.Libreria.Entity;

import com.fasterxml.jackson.annotation.*;
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

    //@OneToMany(mappedBy = "generoId", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "libro",unique = false)
    @JsonIgnoreProperties("libros")
    //@JsonManagedReference
    private List<LibroEntity> libros;



}
