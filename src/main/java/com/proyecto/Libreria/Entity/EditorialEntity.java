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
@Table(name="editoriales")
public class EditorialEntity {
    @Id
    @Column(name="editorialId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreEditorial")
    private String nombreEditorial;

    @OneToMany(mappedBy = "editorialId", cascade = CascadeType.ALL)
    @Column(name="listaLibros")
    private List<LibroEntity> listaLibros;
}


