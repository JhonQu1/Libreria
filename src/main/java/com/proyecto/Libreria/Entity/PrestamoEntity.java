package com.proyecto.Libreria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name="prestamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fechaPrestamo")
    private String fechaInicioPrestamo;

    @Column(name="fechaEntrega")
    private String fechaEntregaPrestamo;

    @Column(name="cantidadLibros")
    private int cantidadLibrosPrestamo;

    @ManyToOne
    @JoinColumn(name = "usuarioId", unique = false)
    @JsonIgnoreProperties("usuarioId")
    //@JsonBackReference
    private UsuarioEntity usuarioId;

    @OneToOne
    @JoinColumn(name = "estadoId",unique = false)
    @JsonIgnoreProperties("estado")
    private EstadoEntity estado;

    @ManyToMany
    @JoinTable(name = "copiasLIbroId", joinColumns = @JoinColumn(name = "prestamoId"),
            inverseJoinColumns = @JoinColumn(name = "copiasLIbroId",unique = false))
    private List<CopiasLibroEntity> copiasLIbroId;





}
