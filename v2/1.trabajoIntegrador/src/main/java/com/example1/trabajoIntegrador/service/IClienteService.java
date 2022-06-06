package com.example1.trabajoIntegrador.service;

import com.example1.trabajoIntegrador.dto.ClienteDTO;
import com.example1.trabajoIntegrador.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IClienteService {

    void crearCliente(ClienteDTO clienteDTO);
    ClienteDTO leerCliente(Long id);
    void modificarCliente(ClienteDTO estudianteDTO);
    void eliminarCliente(Long id) throws ResourceNotFoundException;
    Set<ClienteDTO> getTodos();

}
