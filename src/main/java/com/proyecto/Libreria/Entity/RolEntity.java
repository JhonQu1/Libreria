package com.proyecto.Libreria.Entity;

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
@Table(name="roles")
public class RolEntity {
    @Id
    @Column(name="rolId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name="nombreRol")
    private String nombreRol;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario",unique = false)
    @JsonIgnoreProperties("usuarios")
    //@JsonManagedReference
    private List<UsuarioEntity> usuarios;

}


