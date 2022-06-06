package com.example1.trabajoIntegrador.controller;

import com.example1.trabajoIntegrador.dto.ReunionDTO;
import com.example1.trabajoIntegrador.service.IReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/reuniones")
public class ReunionController {

    @Autowired
    IReunionService reunionService; // Se conecta con esta capa, la de servicio

    @PostMapping
    public ResponseEntity<?> crearReunion(@RequestBody ReunionDTO reunionDTO){
        reunionService.crearReunion(reunionDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ReunionDTO getReunion(@PathVariable Long id){
        return reunionService.leerReunion(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarReunion(@RequestBody ReunionDTO reunionDTO){
        reunionService.modificarReunion(reunionDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarReunion(@PathVariable Long id){
        reunionService.eliminarReunion(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todas")
    public Collection<ReunionDTO> getTodosReunion(){
        return reunionService.getTodos();
    }
}
