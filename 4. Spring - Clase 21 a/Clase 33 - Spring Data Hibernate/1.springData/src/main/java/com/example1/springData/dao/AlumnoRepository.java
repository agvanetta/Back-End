package com.example1.springData.dao;

import com.example1.springData.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    @Query("SELECT A FROM ALUMNO WHERE A.NOMBRE = ?1")
    Optional<Alumno> buscarAlumno(String nombre);
}
