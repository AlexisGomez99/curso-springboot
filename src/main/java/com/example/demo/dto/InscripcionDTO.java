package com.example.demo.dto;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estudiante;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class InscripcionDTO {
    private Long id;
    private CursoDTO curso;
    private EstudianteDTO estudiante;
    private LocalDate fechaIncripcion;
    private String status;

    public InscripcionDTO(Long id,CursoDTO curso, EstudianteDTO estudiante, LocalDate fechaIncripcion, String status) {
        this.id=id;
        this.curso = curso;
        this.estudiante = estudiante;
        this.fechaIncripcion = fechaIncripcion;
        this.status = status;
    }
}
