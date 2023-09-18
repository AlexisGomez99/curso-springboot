package com.example.demo.repository;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {



    //B. Listar todos los estudiantes
    @Query("select e from Estudiante e")
    List<Estudiante> findAllEstudiantes();

    //C. Listar todos los estudiantes que tengan un dni mayor a 20M y que su apellido sea “Romero”
    @Query("select e from Estudiante e where e.dni > :dniMayorA and e.apellido = :apellido")
    List<Estudiante> findByApellidoAndDniMayorA(@Param("dniMayorA") int dniMayorA,@Param("apellido") String apellido);



}
