package com.example1.trabajoIntegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example1.trabajoIntegrador.dto.EstudianteDTO;
import com.example1.trabajoIntegrador.modelo.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example1.trabajoIntegrador.repository.IEstudianteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired // Injeccion de dependencias para instanciar
    private IEstudianteRepository estudianteRepository; //Para poder acceder a la base de datos (Capa de datos)

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearEstudiante(EstudianteDTO estudianteDTO) {
        guardarEstudiante(estudianteDTO); /// reutilizamos codigo
    }

    @Override
    public EstudianteDTO leerEstudiante(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;
        if(estudiante.isPresent())
            estudianteDTO=mapper.convertValue(estudiante, EstudianteDTO.class);

        return estudianteDTO;
    }

    // Creamos este metodo para reutilizar el save
    private void guardarEstudiante(EstudianteDTO estudianteDTO){
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override // No hay un modificar, usamos save de crearEstudiante
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        guardarEstudiante(estudianteDTO);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Set<EstudianteDTO> getTodos() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        Set<EstudianteDTO> estudiantesDTO = new HashSet<>();

        for (Estudiante estudiante: estudiantes){
            estudiantesDTO.add(mapper.convertValue(estudiante, EstudianteDTO.class));
        }
        return estudiantesDTO;
    }
}
