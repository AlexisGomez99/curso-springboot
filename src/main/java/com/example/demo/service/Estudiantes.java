package com.example.demo.service;

import com.example.demo.api.EstudianteService;
import com.example.demo.domain.Estudiante;
import com.example.demo.dto.EstudianteDTO;
import com.example.demo.repository.EstudianteRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Validated
@Service
public class Estudiantes implements EstudianteService {

    @Autowired
    EstudianteRepository estudiantes;


    @Override
    public void crearEstudiante(@NotNull @NotEmpty String nombre, @NotNull @NotEmpty String apellido, @NotNull @NotEmpty String email, @NotNull @Positive int dni, @NotNull  LocalDate fechaNacimiento) {
        estudiantes.save(new Estudiante(nombre,apellido,email,dni,fechaNacimiento));
    }

    @Override
    public List<EstudianteDTO> listarEstudiantes() {
        List<EstudianteDTO> estudianteDTOS= new ArrayList<>();

        for(Estudiante e: estudiantes.findAll()){
            estudianteDTOS.add(new EstudianteDTO(e.getId(),e.getNombre(),e.getApellido(),e.getEmail(),e.getDni(),e.getFechaNacimiento()));
        }

        return estudianteDTOS;
    }

    @Override
    public EstudianteDTO buscarPorId(@NotNull @Positive Long id) {
        Estudiante estudiante= estudiantes
                .findById(id)
                .orElseThrow(() -> new RuntimeException("el id del estudiante no es valido"));

        EstudianteDTO estudianteDTO= new EstudianteDTO(estudiante.getId(),estudiante.getNombre(), estudiante.getApellido(), estudiante.getEmail(), estudiante.getDni(),estudiante.getFechaNacimiento());
        return estudianteDTO;
    }

    @Override
    public void actualizarEstudiante(@NotNull @Positive Long id,@NotNull @NotEmpty String nombre,@NotNull @NotEmpty String apellido,@NotNull @NotEmpty String email,@NotNull @Positive int dni,@NotNull LocalDate fechaNacimiento) {
        Estudiante estudiante= estudiantes.getReferenceById(id);
        estudiante.setApellido(estudiante.getApellido());
        estudiante.setNombre(estudiante.getNombre());
        estudiante.setDni(estudiante.getDni());
        estudiante.setEmail(estudiante.getEmail());
        estudiante.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudiantes.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(@NotNull @Positive Long id) {
        Estudiante estudiante= estudiantes
                .findById(id)
                .orElseThrow(() -> new RuntimeException("el id del estudiante no es valido"));

        estudiantes.deleteById(id);
    }
}
