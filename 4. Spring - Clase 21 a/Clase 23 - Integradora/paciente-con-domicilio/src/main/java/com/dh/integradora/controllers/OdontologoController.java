package com.dh.integradora.controllers;

import com.dh.integradora.model.Odontologo;
import com.dh.integradora.model.Paciente;
import com.dh.integradora.services.OdontologoService;
import com.dh.integradora.services.PacienteService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import static java.time.LocalDate.*;

//@RequestMapping("/medicamentos") Se pone adelante de cada url que generemos para definir "sectores"
@Controller /// Esta clase va a ser un controller
public class OdontologoController {
    @Autowired
    public OdontologoService odontologoService;
    public PacienteService pacienteService;

    @ResponseBody //Se encarga de transformar los objetos a formato json o xml
    @GetMapping("/odontologos/todos")
    public List<Odontologo> obtenerTodos(){
        return odontologoService.getAll();
    }

    @GetMapping("/odontologos/id") // Url que nos lleva a la ejecucion de ese metodo
    public String consultarOdontologoPorID(@RequestParam String id, Model model){
        Odontologo odontologo = odontologoService.getOdontologoById(id);
        String response = "error";
        if (odontologo != null){
            model.addAttribute("nombre", "odontólogo ".concat(odontologo.getNombre()));
            model.addAttribute("apellido", odontologo.getApellido());
            response = "informacion";
        } else {
            model.addAttribute("mensaje", "No se encontró ningún odontólogo con id: ".concat(id));
        }
        return response;
    }

    // Ej API
    @GetMapping("/{email}")
    public Paciente buscar(@PathVariable("email") String correo){
        return pacienteService.getPacienteByEmail(correo);
    }

    @PostMapping("/registrar") //La info llega por el body por lo que definimos url
    public Odontologo guardar(@RequestBody Odontologo odontologo){
        return odontologoService.guardar(odontologo);
        // Desde postman envio un post>body>raw : ingreso un objeto con los atributos de la clase
    }

    @GetMapping("/calendar={fecha}")
    public int devolverFecha(@PathVariable("fecha") LocalDate fechaNacimiento){
        Period period = Period.between(LocalDate.now(), fechaNacimiento);
        return period.getYears();
    }
}
