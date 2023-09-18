package com.example.demo.repository;

import com.example.demo.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface CursoRepository extends JpaRepository<Curso,Long> {

    //A. Listar todos los cursos
    @Query("select c from Curso c")
    List<Curso> findAllCursos();

    //F. Listar todos los cursos que hayan empezado después de “01/02/2020”
    @Query("select c from Curso c where current_date > :fecha")
    List<Curso> despuesDe(@Param("fecha") LocalDate fecha);
}
