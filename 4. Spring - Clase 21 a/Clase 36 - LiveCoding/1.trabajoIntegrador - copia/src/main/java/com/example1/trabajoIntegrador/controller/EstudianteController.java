package com.example1.trabajoIntegrador.controller;

import com.example1.trabajoIntegrador.dto.EstudianteDTO;
import com.example1.trabajoIntegrador.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example1.trabajoIntegrador.service.IEstudianteService;

import java.util.Collection;

@CrossOrigin("*")

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

    @PutMapping
    public ResponseEntity<?> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        estudianteService.modificarEstudiante(estudianteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable Long id) throws ResourceNotFoundException {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public Collection<EstudianteDTO> getTodosEstudiantes(){
       return estudianteService.getTodos();
    }

   /* @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    } */

}
