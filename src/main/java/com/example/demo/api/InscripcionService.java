package com.example.demo.api;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface InscripcionService {

    void crearInscripcion(Long idCurso,Long idEstudiante, LocalDate fecha, String status);
}
