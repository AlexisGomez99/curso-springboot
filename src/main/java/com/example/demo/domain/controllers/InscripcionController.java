package com.example.demo.domain.controllers;

import com.example.demo.api.CursoService;
import com.example.demo.api.InscripcionService;
import com.example.demo.dto.CursoDTO;
import com.example.demo.dto.InscripcionDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("inscripciones")
public class InscripcionController {

    InscripcionService inscripciones;

    @PostMapping("/crear")
    @Operation(summary = "Agregar una inscripcion")
    public ResponseEntity<?> create(@RequestBody InscripcionDTO inscripcionDTO) {

        inscripciones.crearInscripcion(inscripcionDTO.getCurso().getId(),inscripcionDTO.getEstudiante().getId(),inscripcionDTO.getFechaIncripcion(),inscripcionDTO.getStatus());
        return ResponseEntity.status(OK).body("Ok");
    }
}
