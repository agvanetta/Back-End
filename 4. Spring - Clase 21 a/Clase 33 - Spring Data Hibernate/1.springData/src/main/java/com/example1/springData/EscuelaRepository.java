package com.example1.springData;

import com.example1.springData.modelo.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscuelaRepository extends JpaRepository <Escuela, Long> {


}
