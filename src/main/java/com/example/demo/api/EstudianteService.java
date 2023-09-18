package com.example.demo.api;

import com.example.demo.dto.EstudianteDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EstudianteService {

    void crearEstudiante(String nombre, String apellido, String email, int dni, LocalDate fechaNacimiento);

    List<EstudianteDTO> listarEstudiantes();

    EstudianteDTO buscarPorId(Long id);

    void actualizarEstudiante(Long id,String nombre, String apellido, String email, int dni, LocalDate fechaNacimiento);

    void eliminarEstudiante(Long id);
}
