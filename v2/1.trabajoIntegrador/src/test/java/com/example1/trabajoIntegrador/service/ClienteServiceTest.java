package com.example1.trabajoIntegrador.service;

import com.example1.trabajoIntegrador.dto.ClienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private IClienteService clienteService;

    @Test
    public void testCrearCliente(){

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre("Agustin");
        clienteDTO.setApellido("Vanetta");
        clienteService.crearCliente(clienteDTO);

        ClienteDTO clienteAgustin = clienteService.leerCliente(1L);

        assertTrue(clienteAgustin != null);
    }

}