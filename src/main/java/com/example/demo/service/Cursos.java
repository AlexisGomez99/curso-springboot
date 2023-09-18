package com.example.demo.service;

import com.example.demo.api.CursoService;
import com.example.demo.domain.Curso;
import com.example.demo.repository.CursoRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Validated
@Service
public class Cursos implements CursoService {
    @Autowired
    CursoRepository cursos;


    @Override
    public void crearCurso(@NotNull @NotEmpty String nombre, @NotNull @NotEmpty String descripcion,@NotNull LocalDate fechaInicio,@NotNull LocalDate fechaFin) {

        if(fechaInicio.isBefore(fechaFin))
            throw new RuntimeException("Las fechas no son validas");
        cursos.save(new Curso(nombre,descripcion,fechaInicio,fechaFin));
    }
}
