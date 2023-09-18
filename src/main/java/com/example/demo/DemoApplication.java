package com.example.demo;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	EstudianteRepository estudiantes;

	@Autowired
	CursoRepository cursos;
	@Autowired
	InscripcionRepository inscripciones;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			estudiantes.save( new Estudiante("Alexis","Gomez", "ralexisge@gmail.com",42456256, LocalDate.of(1999,12,27)));
			estudiantes.save( new Estudiante("Martin","Romero", "mperez@gmail.com",43446256, LocalDate.of(1999,12,3)));
			estudiantes.findAll();

			cursos.save(new Curso("Matematica","Funciones y calculo",LocalDate.now().minusDays(20),LocalDate.now().plusMonths(3)));
			cursos.save(new Curso("Lenguaje","Gramatica y lectura",LocalDate.now().minusDays(20),LocalDate.now().plusMonths(3)));
			cursos.findAll();

		};
	}

}
