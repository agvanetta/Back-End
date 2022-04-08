package com.example1.trabajoIntegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example1.trabajoIntegrador.dto.CursadaDTO;
import com.example1.trabajoIntegrador.modelo.Cursada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example1.trabajoIntegrador.repository.ICursadaRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class CursadaService implements ICursadaService {


    @Autowired // Injeccion de dependencias para instanciar
    private ICursadaRepository cursadaRepository; //Para poder acceder a la base de datos (Capa de datos)

    @Autowired
    ObjectMapper mapper;

    // Creamos este metodo para reutilizar el save
    private void guardarCursada(CursadaDTO cursadaDTO){
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public void crearCursada(CursadaDTO cursadaDTO) {
        guardarCursada(cursadaDTO);
    }

    @Override
    public CursadaDTO leerCursada(Long id) {
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        CursadaDTO cursadaDTO = null;
        if(cursada.isPresent())
            cursadaDTO=mapper.convertValue(cursada, CursadaDTO.class);

        return cursadaDTO;
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDTO) {
        guardarCursada(cursadaDTO);
    }

    @Override
    public void eliminarCursada(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public Set<CursadaDTO> getTodos() {
        List<Cursada> cursadas = cursadaRepository.findAll();
        Set<CursadaDTO> cursadasDTO = new HashSet<>();

        for (Cursada cursada: cursadas){
            cursadasDTO.add(mapper.convertValue(cursada, CursadaDTO.class));
        }
        return cursadasDTO;
    }
}
