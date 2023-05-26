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
@Table(name="libros")
public class LibroEntity {
    @Id
    @Column(name="libroId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="fechaPublicacion")
    private String fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "autorId")
    private AutorEntity autorId;


    @ManyToOne
    @JoinColumn(name = "editorialId")
    private EditorialEntity editorialId;


    @OneToMany(mappedBy = "generoId", cascade = CascadeType.ALL)
    @Column(name="listaGeneros")
    private List<GeneroEntity> listaGeneros;

    @ManyToOne
    @JoinColumn(name = "prestamoId")
    private PrestamoEntity prestamoId;


}
