package com.example1.trabajoIntegrador.repository;

import com.example1.trabajoIntegrador.modelo.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReunionRepository extends JpaRepository<Reunion,Long> {
}
