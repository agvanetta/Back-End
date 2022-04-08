package com.example1.trabajoIntegrador.repository;

import com.example1.trabajoIntegrador.modelo.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursadaRepository extends JpaRepository<Cursada,Long> {
}
