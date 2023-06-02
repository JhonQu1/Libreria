package com.proyecto.Libreria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToOne(mappedBy = "estado")
    //@JoinColumn(name = "prestamoId")
    private PrestamoEntity prestamoId;



}
