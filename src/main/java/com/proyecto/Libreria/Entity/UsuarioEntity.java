
package com.proyecto.Libreria.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="usuarios")
public class UsuarioEntity {


    @Id
    @Column(name="usuarioId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="telefono")
    private String telefono;

    @OneToMany(mappedBy = "usuarioId", cascade = CascadeType.ALL)
    //@JoinColumn(name = "prestamo",unique = false)
    @JsonIgnoreProperties("prestamos")
    //@JsonManagedReference
    private List<PrestamoEntity> prestamos;

    @ManyToOne
    //@JoinColumn(name = "idRol",unique = false)
    @JsonIgnoreProperties("rolId")
    //@JsonBackReference
    private RolEntity rolId;


}

