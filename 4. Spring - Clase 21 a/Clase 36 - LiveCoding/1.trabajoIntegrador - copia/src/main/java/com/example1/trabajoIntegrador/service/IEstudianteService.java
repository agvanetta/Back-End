package com.example1.trabajoIntegrador.service;

import com.example1.trabajoIntegrador.dto.EstudianteDTO;
import com.example1.trabajoIntegrador.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IEstudianteService {

    void crearEstudiante(EstudianteDTO estudiantDTO);
    EstudianteDTO leerEstudiante(Long id);
    void modificarEstudiante(EstudianteDTO estudianteDTO);
    void eliminarEstudiante(Long id) throws ResourceNotFoundException;
    Set<EstudianteDTO> getTodos();

}
