package com.proyecto.Libreria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="prestamos")
public class PrestamoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="idUsuario")
    private Long idUsuario;

    @Column(name="fechaPrestamo")
    private String fechaPrestamo;

    @Column(name="fechaEntrega")
    private String fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuarioId;

    @OneToMany(mappedBy = "prestamoId", cascade = CascadeType.ALL)
    @Column(name = "listaEstados")
    private List<EstadoEntity> listaEstados;

    @OneToMany(mappedBy = "prestamoId", cascade = CascadeType.ALL)
    @Column(name = "listaLibros")
    private List<LibroEntity> listaLibros;


}
