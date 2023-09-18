package com.example.demo.api;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface CursoService {

    void crearCurso(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin);
}
