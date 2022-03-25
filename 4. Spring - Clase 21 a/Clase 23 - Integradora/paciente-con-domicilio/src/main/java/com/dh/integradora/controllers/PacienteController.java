package com.dh.integradora.controllers;

import com.dh.integradora.model.Paciente;
import com.dh.integradora.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller //Esta anotacion define la clase como un controlador de Spring MVC
public class PacienteController {
    @Autowired
    public PacienteService pacienteService;

    @ResponseBody
    @GetMapping("/pacientes/todos")
    public List<Paciente> obtenerTodos(){
        return pacienteService.getAll();
    }

    @GetMapping("/pacientes/email") // Ruta que podemos introducir en el navegador
    public String consultarPacientePorEmail(@RequestParam String email, Model model){
        Paciente paciente = pacienteService.getPacienteByEmail(email);
        String response = "error"; //Trae el html error

        if (paciente != null){
            // model.aaddAtribute : informacion que enviamos a la plantilla al a vista
            model.addAttribute("nombre", paciente.getNombre());
            model.addAttribute("apellido", paciente.getApellido());
            model.addAttribute("email", paciente.getEmail());
            model.addAttribute("fechaingreso", paciente.getFechaIngreso());
            model.addAttribute("domicilio", paciente.getDomicilio().getCalle());

            response = "informacion"; // Trae el html informacion
            // http://localhost:8080/pacientes/email?email=asd
            // Los parametros de URL contienen una clave y un valor seprados por un signo igual y unidos por un
            //signo de union & : /listasOfertas ? mes=1 & user=google
        } else {
            model.addAttribute("mensaje", "No se encontró ningún paciente con mail: ".concat(email));
        }

        return response;
    }
}
