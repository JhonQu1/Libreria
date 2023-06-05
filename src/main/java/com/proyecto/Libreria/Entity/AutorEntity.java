package com.proyecto.Libreria.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="autores")
public class AutorEntity {
    @Id
    @Column(name="autorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreAutor")
    private String nombreAutor;

    @Column(name="apellidoAutor")
    private String apellidoAutor;

    @Column(name="fechaNacimiento")
    private String fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "paisId", unique = false)
    @JsonIgnoreProperties("paisId")
    //@JsonBackReference
    private PaisEntity paisId;

    //@OneToMany(mappedBy = "autorId",cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "libro",unique = false)
    @JsonIgnoreProperties("libros")
    @JsonManagedReference
    private List<LibroEntity> libros;



}
