package com.example1.trabajoIntegrador.service;

import com.example1.trabajoIntegrador.dto.ReunionDTO;

import java.util.Set;

public interface IReunionService {

    void crearReunion(ReunionDTO cursadaDTO);
    ReunionDTO leerReunion(Long id);
    void modificarReunion(ReunionDTO cursadaDTO);
    void eliminarReunion(Long id);
    Set<ReunionDTO> getTodos();
}
