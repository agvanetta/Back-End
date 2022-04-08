package com.example1.trabajoIntegrador.repository;

import com.example1.trabajoIntegrador.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {


}
