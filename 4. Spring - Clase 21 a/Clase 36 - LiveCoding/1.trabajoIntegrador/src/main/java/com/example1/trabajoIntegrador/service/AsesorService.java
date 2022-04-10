package com.example1.trabajoIntegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example1.trabajoIntegrador.dto.AsesorDTO;
import com.example1.trabajoIntegrador.modelo.Asesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example1.trabajoIntegrador.repository.IAsesorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AsesorService implements IAsesorService {

    @Autowired // Injeccion de dependencias para instanciar
    private IAsesorRepository asesorRepository; //Para poder acceder a la base de datos (Capa de datos)

    @Autowired
    ObjectMapper mapper;

    // Creamos este metodo para reutilizar el save
    private void guardarAsesor(AsesorDTO asesorDTO) {
        Asesor asesor = mapper.convertValue(asesorDTO, Asesor.class);
        asesorRepository.save(asesor);
    }

    @Override
    public void crearAsesor(AsesorDTO asesorDTO) {
        guardarAsesor(asesorDTO);
    }

    @Override
    public AsesorDTO leerAsesor(Long id) {
        Optional<Asesor> asesor = asesorRepository.findById(id);
        AsesorDTO asesorDTO = null;
        if(asesor.isPresent())
            asesorDTO =mapper.convertValue(asesor, AsesorDTO.class);

        return asesorDTO;
    }

    @Override
    public void modificarAsesor(AsesorDTO asesorDTO) {
        guardarAsesor(asesorDTO);
    }

    @Override
    public void eliminarAsesor(Long id) {
        asesorRepository.deleteById(id);
    }

    @Override
    public Set<AsesorDTO> getTodos() {
        List<Asesor> asesores = asesorRepository.findAll();
        Set<AsesorDTO> asesoresDTO = new HashSet<>();

        for (Asesor asesor : asesores){
            asesoresDTO.add(mapper.convertValue(asesor, AsesorDTO.class));
        }
        return asesoresDTO;
    }
}
