package com.backend.proyectointegrador.service;

import com.backend.proyectointegrador.exceptions.BadRequestException;
import com.backend.proyectointegrador.exceptions.ResourceNotFoundException;
import com.backend.proyectointegrador.model.PacienteDto;

import java.util.List;

public interface IPacienteService extends CRUDService<PacienteDto> {
    PacienteDto buscar(Integer dni) throws ResourceNotFoundException, BadRequestException;

    List<PacienteDto> buscar(String nombre);

    List<PacienteDto> buscar(String nombre, String apellido);
}
