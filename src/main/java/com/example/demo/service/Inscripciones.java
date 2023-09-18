package com.example.demo.service;

import com.example.demo.api.InscripcionService;
import com.example.demo.domain.Curso;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.dto.InscripcionDTO;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Validated
@Service
public class Inscripciones implements InscripcionService {
    @Autowired
    InscripcionRepository inscripciones;
    @Autowired
    CursoRepository cursos;
    @Autowired
    EstudianteRepository estudiantes;


    @Override
    public void crearInscripcion(@NotNull @Positive Long idCurso, @NotNull @Positive Long idEstudiante,@NotNull LocalDate fecha,@NotNull String status) {

        Curso cursoOptional= cursos
                .findById(idCurso)
                .orElseThrow(() -> new RuntimeException("el id del curso no es valido"));

        Estudiante estudianteOptional= estudiantes
                .findById(idEstudiante)
                .orElseThrow(() -> new RuntimeException("el id del estudiante no es valido"));


        if(!estudianteOptional.esMayor(18))
            throw new RuntimeException("El estudiante es menor de edad");
        inscripciones.save(new Inscripcion(cursoOptional,estudianteOptional,fecha,status));
    }
}
