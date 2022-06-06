package com.backend.proyectointegrador.service;

import com.backend.proyectointegrador.model.DomicilioDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDomicilioService extends CRUDService<DomicilioDto> {
    List<DomicilioDto> buscar(String calle);

    List<DomicilioDto> buscar(String calle, Integer numero);

    DomicilioDto buscar(String calle, Integer numero, String localidad, String provincia) throws Exception;
}
