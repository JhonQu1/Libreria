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
@Table(name="copiasLibro")
public class CopiasLibroEntity {

    @Id
    @Column(name="copiaslibroId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "copiasLIbroId")
    @Column(name = "prestamos",unique = false)
    private List<PrestamoEntity> prestamos;

    @OneToOne
    @JoinColumn(name = "condicionId",unique = false)
    private CondicionEntity condicion;
}
