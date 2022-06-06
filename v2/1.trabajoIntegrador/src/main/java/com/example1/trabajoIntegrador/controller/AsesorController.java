package com.example1.trabajoIntegrador.controller;

import com.example1.trabajoIntegrador.dto.AsesorDTO;
import com.example1.trabajoIntegrador.service.IAsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/asesores")
public class AsesorController {

    @Autowired
    IAsesorService asesorService; // Se conecta con esta capa, la de servicio

    @PostMapping
    public ResponseEntity<?> crearAsesor(@RequestBody AsesorDTO asesorDTO){
        asesorService.crearAsesor(asesorDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AsesorDTO getAsesor(@PathVariable Long id){
        return asesorService.leerAsesor(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarAsesor(@RequestBody AsesorDTO asesorDTO){
        asesorService.modificarAsesor(asesorDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsesor(@PathVariable Long id){
        asesorService.eliminarAsesor(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public Collection<AsesorDTO> getTodosAsesores(){
        return asesorService.getTodos();
    }

}
