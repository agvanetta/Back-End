package com.backend.proyectointegrador.persistence.repository.auth;

import com.backend.proyectointegrador.persistence.entities.auth.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
