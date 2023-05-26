package com.proyecto.Libreria.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "autorId", cascade = CascadeType.ALL)
    @Column(name="listaLibros")
    private List<LibroEntity> listaLibros;

    @ManyToOne
    @JoinColumn(name = "paisId")
    private PaisEntity paisId;


}
