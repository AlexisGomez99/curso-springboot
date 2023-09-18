package com.example.demo.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CursoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public CursoDTO(Long id,String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id=id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
