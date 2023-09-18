package com.example.demo.dto;

import com.example.demo.domain.Inscripcion;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
@Getter
public class EstudianteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    private LocalDate fechaNacimiento;

    public EstudianteDTO(Long id,String nombre, String apellido, String email, int dni, LocalDate fechaNacimiento) {
        this.id= id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
}
