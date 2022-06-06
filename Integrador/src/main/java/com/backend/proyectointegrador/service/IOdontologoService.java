package com.backend.proyectointegrador.service;

import com.backend.proyectointegrador.exceptions.BadRequestException;
import com.backend.proyectointegrador.exceptions.ResourceNotFoundException;
import com.backend.proyectointegrador.model.OdontologoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOdontologoService extends CRUDService<OdontologoDto> {
    OdontologoDto buscar(Integer matricula) throws ResourceNotFoundException, BadRequestException;

    List<OdontologoDto> buscar(String nombre);

    List<OdontologoDto> buscar(String nombre, String apellido);
}
