package com.backend.proyectointegrador.service.impl;

import com.backend.proyectointegrador.exceptions.BadRequestException;
import com.backend.proyectointegrador.exceptions.ResourceNotFoundException;
import com.backend.proyectointegrador.service.IPacienteService;
import com.backend.proyectointegrador.utils.Mapper;
import com.backend.proyectointegrador.config.SpringConfig;
import com.backend.proyectointegrador.model.DomicilioDto;
import com.backend.proyectointegrador.model.PacienteDto;
import com.backend.proyectointegrador.persistence.entities.Domicilio;
import com.backend.proyectointegrador.persistence.entities.Paciente;
import com.backend.proyectointegrador.persistence.repository.IPacienteRepository;
import com.backend.proyectointegrador.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private final IPacienteRepository pacienteRepository;
    private final IDomicilioService domicilioService;
    private final SpringConfig springConfig;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository, IDomicilioService domicilioService, SpringConfig springConfig) {
        this.pacienteRepository = pacienteRepository;
        this.domicilioService = domicilioService;
        this.springConfig = springConfig;
    }

    @Override
    public PacienteDto buscar(Integer dni) throws BadRequestException, ResourceNotFoundException {
        if (dni == null)
            throw new BadRequestException("El DNI del paciente no puede ser null");
        Paciente paciente = pacienteRepository.buscar(dni).orElse(null);
        if (paciente == null)
            throw new ResourceNotFoundException("No se encontrĂ³ el paciente con DNI " + dni);
        return springConfig.getModelMapper().map(paciente, PacienteDto.class);
    }

    @Override
    public List<PacienteDto> buscar(String nombre) {
        List<Paciente> pacientes = pacienteRepository.buscar(nombre).orElse(new ArrayList<>());
        return Mapper.mapList(springConfig.getModelMapper(), pacientes, PacienteDto.class);
    }

    @Override
    public List<PacienteDto> buscar(String nombre, String apellido) {
        List<Paciente> pacientes = pacienteRepository.buscar(nombre, apellido).orElse(new ArrayList<>());
        return Mapper.mapList(springConfig.getModelMapper(), pacientes, PacienteDto.class);
    }

    @Override
    public PacienteDto buscarPorId(Integer id) throws BadRequestException, ResourceNotFoundException {
        if (id == null || id < 1)
            throw new BadRequestException("El id del paciente no puede ser null ni negativo");
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente == null)
            throw new ResourceNotFoundException("No se encontrĂ³ el paciente con id " + id);
        return springConfig.getModelMapper().map(paciente, PacienteDto.class);
    }

    @Override
    public PacienteDto crear(PacienteDto pacienteDto) throws BadRequestException {
        if (pacienteDto == null)
            throw new BadRequestException("No se puede crear un paciente null");
        Paciente paciente = springConfig.getModelMapper().map(pacienteDto, Paciente.class);
        return springConfig.getModelMapper().map(pacienteRepository.save(paciente), PacienteDto.class);
    }

    @Override
    public PacienteDto actualizar(PacienteDto pacienteDto) throws BadRequestException, ResourceNotFoundException {
        if (pacienteDto == null)
            throw new BadRequestException("No se pudo actualizar el paciente null");
        if (pacienteDto.getId() == null)
            throw new BadRequestException("El id del paciente a actualizar no puede ser null");
        Optional<Paciente> pacienteEnBD = pacienteRepository.findById(pacienteDto.getId());
        if (pacienteEnBD.isPresent()) {
            Paciente actualizado = this.actualizar(pacienteEnBD.get(), pacienteDto);
            pacienteDto = springConfig.getModelMapper().map(pacienteRepository.save(actualizado), PacienteDto.class);
        } else {
            throw new ResourceNotFoundException("El paciente no existe");
        }
        return pacienteDto;
    }

    @Override
    public void eliminar(Integer id) throws BadRequestException, ResourceNotFoundException {
        if (id == null || id < 1)
            throw new BadRequestException("El id del paciente no puede ser null ni negativo");
        if (!pacienteRepository.existsById(id))
            throw new ResourceNotFoundException("No existe ningĂºn paciente con id: " + id);
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<PacienteDto> consultarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return Mapper.mapList(springConfig.getModelMapper(), pacientes, PacienteDto.class);
    }

    private Paciente actualizar(Paciente paciente, PacienteDto pacienteDto) throws BadRequestException, ResourceNotFoundException {
        if (pacienteDto.getNombre() != null) {
            paciente.setNombre(pacienteDto.getNombre());
        }
        if (pacienteDto.getApellido() != null) {
            paciente.setApellido(pacienteDto.getApellido());
        }
        if (pacienteDto.getDni() != null) {
            paciente.setDni(pacienteDto.getDni());
        }
        if (pacienteDto.getDomicilio() != null) {
            DomicilioDto actualizado = domicilioService.actualizar(pacienteDto.getDomicilio());
            paciente.setDomicilio(springConfig.getModelMapper().map(actualizado, Domicilio.class));
        }
        return paciente;
    }
}
