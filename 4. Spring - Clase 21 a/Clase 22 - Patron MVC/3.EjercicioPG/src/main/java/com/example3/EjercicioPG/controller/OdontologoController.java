package com.example3.EjercicioPG.controller;

import com.example3.EjercicioPG.domain.Odontologo;
import com.example3.EjercicioPG.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RequestMapping("odontologos") // para agregar nuestra URL, en este caso/odontólogo.
@RestController // para decirle a Spring que este es nuestro controller
public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> getOdontologos() {
        return odontologoService.listaOdontologos();
    }

    @GetMapping("/Inicio")
    public String goHome(Model model){
        model.addAttribute("titulo","Buenardas");
        return "Inicio";
    }

}
