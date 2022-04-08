package com.example1.trabajoIntegrador.controller;


import com.example1.trabajoIntegrador.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example1.trabajoIntegrador.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    IEstudianteService estudianteService; // Se conecta con esta capa, la de servicio

    @PostMapping
    public ResponseEntity<?> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public EstudianteDTO getEstudiante(@PathVariable Long id){
        return estudianteService.leerEstudiante(id);
    }
}
