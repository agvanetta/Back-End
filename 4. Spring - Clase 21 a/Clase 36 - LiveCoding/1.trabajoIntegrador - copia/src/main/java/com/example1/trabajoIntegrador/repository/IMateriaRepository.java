package com.example1.trabajoIntegrador.repository;

import com.example1.trabajoIntegrador.modelo.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia, Long> {
}
