package com.example1.trabajoIntegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example1.trabajoIntegrador.dto.ReunionDTO;
import com.example1.trabajoIntegrador.modelo.Reunion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example1.trabajoIntegrador.repository.IReunionRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ReunionService implements IReunionService {


    @Autowired // Injeccion de dependencias para instanciar
    private IReunionRepository reunionRepository; //Para poder acceder a la base de datos (Capa de datos)

    @Autowired
    ObjectMapper mapper;

    // Creamos este metodo para reutilizar el save
    private void guardarReunion(ReunionDTO reunionDTO){
        Reunion reunion = mapper.convertValue(reunionDTO, Reunion.class);
        reunionRepository.save(reunion);
    }

    @Override
    public void crearReunion(ReunionDTO reunionDTO) {
        guardarReunion(reunionDTO);
    }

    @Override
    public ReunionDTO leerReunion(Long id) {
        Optional<Reunion> reunion = reunionRepository.findById(id);
        ReunionDTO reunionDTO = null;
        if(reunion.isPresent())
            reunionDTO=mapper.convertValue(reunion, ReunionDTO.class);

        return reunionDTO;
    }

    @Override
    public void modificarReunion(ReunionDTO reunionDTO) {
        guardarReunion(reunionDTO);
    }

    @Override
    public void eliminarReunion(Long id) {
        reunionRepository.deleteById(id);
    }

    @Override
    public Set<ReunionDTO> getTodos() {
        List<Reunion> reuniones = reunionRepository.findAll();
        Set<ReunionDTO> reunionesDTO = new HashSet<>();

        for (Reunion reunion: reuniones){
            reunionesDTO.add(mapper.convertValue(reunion, ReunionDTO.class));
        }
        return reunionesDTO;
    }
}
