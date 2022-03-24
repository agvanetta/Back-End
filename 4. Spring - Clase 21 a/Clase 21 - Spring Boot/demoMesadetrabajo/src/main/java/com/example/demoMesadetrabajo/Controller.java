package com.example.demoMesadetrabajo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("titulo","Buenardas");
        return "Inicio";
    }
}
