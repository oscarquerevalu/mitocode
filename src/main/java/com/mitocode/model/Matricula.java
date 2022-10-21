package com.mitocode.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    @Column(nullable = false)
    private LocalDateTime fechaMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetalleMatricula> detalleMatriculas;

    @Column(nullable = false)
    private boolean estado;
}
