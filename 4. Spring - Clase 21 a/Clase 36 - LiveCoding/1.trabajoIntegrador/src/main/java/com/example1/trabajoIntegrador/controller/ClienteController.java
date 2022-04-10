package com.example1.trabajoIntegrador.controller;

import com.example1.trabajoIntegrador.dto.ClienteDTO;
import com.example1.trabajoIntegrador.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example1.trabajoIntegrador.service.IClienteService;

import java.util.Collection;

@CrossOrigin("*")

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    IClienteService clienteService; // Se conecta con esta capa, la de servicio

    @PostMapping
    public ResponseEntity<?> crearCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.crearCliente(clienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ClienteDTO getCliente(@PathVariable Long id){
        return clienteService.leerCliente(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.modificarCliente(clienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) throws ResourceNotFoundException {
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public Collection<ClienteDTO> getTodosClientes(){
       return clienteService.getTodos();
    }

   /* @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    } */

}
