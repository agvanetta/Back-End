package com.example1.trabajoIntegrador.service;

import com.example1.trabajoIntegrador.dto.AsesorDTO;

import java.util.Set;

public interface IAsesorService {

    void crearAsesor(AsesorDTO asesorDTO);
    AsesorDTO leerAsesor(Long id);
    void modificarAsesor(AsesorDTO asesorDTO);
    void eliminarAsesor(Long id);
    Set<AsesorDTO> getTodos();
}
