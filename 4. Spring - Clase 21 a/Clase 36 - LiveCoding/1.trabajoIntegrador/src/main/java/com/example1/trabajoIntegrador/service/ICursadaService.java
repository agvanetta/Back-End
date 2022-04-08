package com.example1.trabajoIntegrador.service;

import com.example1.trabajoIntegrador.dto.CursadaDTO;

import java.util.Set;

public interface ICursadaService {

    void crearCursada(CursadaDTO cursadaDTO);
    CursadaDTO leerCursada(Long id);
    void modificarCursada(CursadaDTO cursadaDTO);
    void eliminarCursada(Long id);
    Set<CursadaDTO> getTodos();
}
