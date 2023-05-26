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
@Table(name="roles")
public class RolEntity {
    @Id
    @Column(name="rolId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name="nombreRol")
    private String nombreRol;

    @OneToMany(mappedBy = "rolId", cascade = CascadeType.ALL)
    @Column(name="listaUsuarios")
    private List<UsuarioEntity> listaUsuarios;
}


