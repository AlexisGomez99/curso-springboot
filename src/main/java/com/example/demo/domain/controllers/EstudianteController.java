package com.example.demo.domain.controllers;

import com.example.demo.api.EstudianteService;
import com.example.demo.dto.EstudianteDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("cursos")
public class EstudianteController {

    EstudianteService estudianteService;

    @PostMapping("/crear")
    @Operation(summary = "Agregar un estudiante")
    public ResponseEntity<?> create(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteService.crearEstudiante(estudianteDTO.getNombre(),estudianteDTO.getApellido(),estudianteDTO.getEmail(),estudianteDTO.getDni(),estudianteDTO.getFechaNacimiento());
        return ResponseEntity.status(OK).body("Ok");
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Estudiantes")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(OK).body(estudianteService.listarEstudiantes());
    }

    @GetMapping("/buscar/{idEstudiante}")
    @Operation(summary = "buscar un Estudiante")
    public ResponseEntity<?> findAll(@PathVariable Long idEstudiante) {
        return ResponseEntity.status(OK).body(estudianteService.buscarPorId(idEstudiante));
    }

    @PutMapping("/actualizar")
    @Operation(summary = "Modificar un Estudiante")
    public ResponseEntity<?> update(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteService.actualizarEstudiante(estudianteDTO.getId(),estudianteDTO.getNombre(),estudianteDTO.getApellido(),estudianteDTO.getEmail(),estudianteDTO.getDni(),estudianteDTO.getFechaNacimiento());
        return ResponseEntity.status(OK).body("Ok");
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un estudiante")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.status(OK).body("Ok");
    }
}
