package com.proyecto.Libreria.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "nombreAutor")
    private String nombreAutor;

    @ManyToOne
    @JoinColumn(name = "autorId", unique = false)
    @JsonIgnoreProperties("autorId")
    @JsonBackReference
    private AutorEntity autorId;


    @ManyToOne
    @JoinColumn(name = "editorialId", unique = false)
    @JsonIgnoreProperties("editorialId")
    //@JsonBackReference
    private EditorialEntity editorialId;

    @ManyToOne
    @JoinColumn(name = "generoId",unique = false)
    @JsonIgnoreProperties("generoId")
    //@JsonBackReference
    private GeneroEntity generoId;





}
