package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;


@Entity
@Table(name = "inscripcion")
@NoArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //una inscripcion tiene un curso
    @JoinColumn(name= "curso_id")
    private Curso curso;

    @ManyToOne// una inscripcion tiene un estudiante
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @Column(name = "fecha_inscripcion")
    private LocalDate fechaIncripcion;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private String status;

    public Inscripcion(Curso curso, Estudiante estudiante, LocalDate fechaIncripcion, String status) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.fechaIncripcion = fechaIncripcion;
        this.status = status;
    }
}
