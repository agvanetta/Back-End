package com.example.apiRestII.controller;

import com.example.apiRestII.daos.ConfiguracionJDBC;
import com.example.apiRestII.daos.OdontologoDAOH2;
import com.example.apiRestII.entidades.Odontologo;
import com.example.apiRestII.servicios.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practica")
public class Controller {

    Odontologo od1 = new Odontologo(5L,17,"Gabriel","Hauche");
    Odontologo od2 = new Odontologo(6l,22,"Diego","Milito");
    Odontologo od3 = new Odontologo(7L,23,"Gustavo","Bou");

    private OdontologoService odontologoService = new OdontologoService();


    @PostMapping("/registrar")
    public Odontologo guardar(@RequestBody Odontologo odontologo){
        odontologoService.setOdontologoInterfaceDAO(new OdontologoDAOH2());
        return odontologoService.guardarOdontologo(od1);
    }

    @GetMapping("/buscar{id}")
    public Odontologo buscar(@PathVariable("id") Long identificador){
        odontologoService.setOdontologoInterfaceDAO(new OdontologoDAOH2());
        return odontologoService.buscarOdontologo(identificador);
    }

    @DeleteMapping("/eliminar{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        odontologoService.setOdontologoInterfaceDAO(new OdontologoDAOH2());
        ResponseEntity response = null;

        if(odontologoService.buscarOdontologo(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            odontologoService.eliminarOdontologo(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    // Se envia con PUT, Body raw json y se agrega el objeto abajo, similar a post (En postman)
    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        odontologoService.setOdontologoInterfaceDAO(new OdontologoDAOH2());
        ResponseEntity response = null;

        if(odontologoService.buscarOdontologo(odontologo.getId()) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(odontologoService.actualizar,HttpStatus.OK);
        }
        return response;
    }

}
