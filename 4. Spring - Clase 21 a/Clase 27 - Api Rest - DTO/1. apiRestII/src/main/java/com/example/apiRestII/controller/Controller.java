package com.example.apiRestII.controller;

import com.example.apiRestII.daos.ConfiguracionJDBC;
import com.example.apiRestII.daos.OdontologoDAOH2;
import com.example.apiRestII.entidades.Odontologo;
import com.example.apiRestII.servicios.OdontologoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practica")
public class Controller {

    private OdontologoService odontologoService = new OdontologoService();


    @PostMapping("/registrar")
    public Odontologo guardar(@RequestBody Odontologo odontologo){
        odontologoService.setOdontologoInterfaceDAO(new OdontologoDAOH2());
        return odontologoService.guardarOdontologo()
    }

}
