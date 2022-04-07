package com.example1.springData.dao;

import com.example1.springData.modelo.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EscuelaRepository extends JpaRepository <Escuela, Long> {

    @Query ("SELECT e FROM Escuela WHERE e.direccion = ?1")
    Optional<Escuela> buscarEscuelas(String direccion);
}

