package com.example.demo.repository;

import com.example.demo.domain.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion,Long> {

    //D. Listar todas las inscripciones rechazadas o pendiente
    @Query("select i from Inscripcion i where i.status = 'Rechazada' or i.status = 'Pendiente'")
    List<Inscripcion> inscripcionesRechazadasOPendientes();

    //Listar todas las inscripciones en base a un parámetro de estado
    @Query("select i from Inscripcion i where i.status = :estado")
    List<Inscripcion> inscripcionesConEstado(@Param("estado") String estado);

    //H. Listar todas las inscripciones en base a un parámetro de estado utilizando consulta nativa
    @Query(value="select i from Inscripcion i where i.status = :estado", nativeQuery = true)
    List<Inscripcion> inscripcionesConEstadoNativo(@Param("estado") String estado);
}
