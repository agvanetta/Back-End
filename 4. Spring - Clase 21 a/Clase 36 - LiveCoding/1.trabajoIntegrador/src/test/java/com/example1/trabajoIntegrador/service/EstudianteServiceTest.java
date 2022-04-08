package com.example1.trabajoIntegrador.service;

import com.example1.trabajoIntegrador.dto.EstudianteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EstudianteServiceTest {

    @Autowired
    private IEstudianteService estudianteService;

    @Test
    public void testCrearEstudiante(){

        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre("Agustin");
        estudianteDTO.setApellido("Vanetta");
        estudianteService.crearEstudiante(estudianteDTO);

        EstudianteDTO estudianteAgustin = estudianteService.leerEstudiante(1L);

        assertTrue(estudianteAgustin != null);
    }

}