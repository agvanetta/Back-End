package com.example1.trabajoIntegrador.repository;

import com.example1.trabajoIntegrador.modelo.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsesorRepository extends JpaRepository<Asesor, Long> {
}
