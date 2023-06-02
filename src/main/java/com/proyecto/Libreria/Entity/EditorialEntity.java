package com.proyecto.Libreria.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    //@OneToMany(mappedBy = "editorialId", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "libro",unique = false)
    @JsonIgnoreProperties("libros")
    //@JsonManagedReference
    private List<LibroEntity> Libros;
}


