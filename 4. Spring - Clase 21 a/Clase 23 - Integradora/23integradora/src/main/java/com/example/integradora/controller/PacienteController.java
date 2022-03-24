package com.example.integradora.controller;


import com.example.integradora.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("pacientes") // para agregar nuestra URL,
@RestController // para decirle a Spring que este es nuestro controller

public class PacienteController {

    public PacienteService pacienteService;

   @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("nombre","Buenardas");
        return "index";
    }
    }



