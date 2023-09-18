package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Table(name= "estudiante")
@NoArgsConstructor
@Getter
@Setter
public class Estudiante {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "dni")
    private int dni;

    @Column(name = "fecha_de_nacimiento")
    private LocalDate fechaNacimiento;


    public Estudiante(String nombre, String apellido, String email, int dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean esMayor(int i) {
        boolean x=false;
        long age = ChronoUnit.YEARS.between(getFechaNacimiento(), LocalDate.now());
        if(age > i){
            x=true;
        }
        return x;
    }
}
