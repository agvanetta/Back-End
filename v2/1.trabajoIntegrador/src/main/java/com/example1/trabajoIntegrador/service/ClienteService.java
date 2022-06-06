package com.example1.trabajoIntegrador.service;

import com.example1.trabajoIntegrador.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example1.trabajoIntegrador.dto.ClienteDTO;
import com.example1.trabajoIntegrador.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example1.trabajoIntegrador.repository.IClienteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClienteService implements IClienteService {

    @Autowired // Injeccion de dependencias para instanciar
    private IClienteRepository clienteRepository; //Para poder acceder a la base de datos (Capa de datos)

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearCliente(ClienteDTO clienteDTO) {
        guardarCliente(clienteDTO); /// reutilizamos codigo
    }

    @Override
    public ClienteDTO leerCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        ClienteDTO clienteDTO = null;
        if(cliente.isPresent())
            clienteDTO=mapper.convertValue(cliente, ClienteDTO.class);

        return clienteDTO;
    }

    // Creamos este metodo para reutilizar el save
    private void guardarCliente(ClienteDTO clienteDTO){
        Cliente cliente = mapper.convertValue(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
    }

    @Override // No hay un modificar, usamos save de crearEstudiante
    public void modificarCliente(ClienteDTO clienteDTO) {
        guardarCliente(clienteDTO);
    }

    @Override
    public void eliminarCliente(Long id) throws ResourceNotFoundException {
        if(leerCliente(id) == null)
            throw new ResourceNotFoundException("No existe un cliente con id "+id);
        clienteRepository.deleteById(id);
    }

    @Override
    public Set<ClienteDTO> getTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        Set<ClienteDTO> clientesDTO = new HashSet<>();

        for (Cliente cliente: clientes){
            clientesDTO.add(mapper.convertValue(cliente, ClienteDTO.class));
        }
        return clientesDTO;
    }
}
