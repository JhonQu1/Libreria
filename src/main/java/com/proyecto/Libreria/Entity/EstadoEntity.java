package com.proyecto.Libreria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="estados")
public class EstadoEntity {
    @Id
    @Column(name="estadoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "prestamoId")
    private PrestamoEntity prestamoId;


}
