package com.example.demo.domain.controllers;

import com.example.demo.api.CursoService;
import com.example.demo.dto.CursoDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("cursos")
public class CursoController {

    CursoService cursoService;

    @PostMapping("/crear")
    @Operation(summary = "Agregar un curso")
    public ResponseEntity<?> create(@RequestBody CursoDTO cursoDTO) {

        cursoService.crearCurso(cursoDTO.getNombre(),cursoDTO.getDescripcion(),cursoDTO.getFechaInicio(),cursoDTO.getFechaFin());
        return ResponseEntity.status(OK).body("Ok");
    }

}
