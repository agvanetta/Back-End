package com.example1.trabajoIntegrador.controller;

import com.example1.trabajoIntegrador.dto.MateriaDTO;
import com.example1.trabajoIntegrador.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cursadas")
public class CursadaController {

    @Autowired
    IMateriaService materiaService; // Se conecta con esta capa, la de servicio

    @PostMapping
    public ResponseEntity<?> crearCursada(@RequestBody MateriaDTO materiaDTO){
        materiaService.crearMateria(materiaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public MateriaDTO getCursada(@PathVariable Long id){
        return materiaService.leerMateria(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarCursada(@RequestBody MateriaDTO materiaDTO){
        materiaService.modificarMateria(materiaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCursada(@PathVariable Long id){
        materiaService.eliminarMateria(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public Collection<MateriaDTO> getTodosCursada(){
        return materiaService.getTodos();
    }
}
