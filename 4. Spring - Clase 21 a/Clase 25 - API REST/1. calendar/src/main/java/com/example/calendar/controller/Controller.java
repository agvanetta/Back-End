package com.example.calendar.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

@RestController
//@RestControllerEquivalente a @Controller +@ResponseBodyLas anotaciones se utilizan juntas.
public class Controller {

    @GetMapping("calendar/{fecha}") // "2020-01-15"
    public String devolverFecha(@PathVariable("fecha") String requestDate) {
        //requestDate = "2020-01-15";
        LocalDate myDate = LocalDate.parse(requestDate);
        LocalDate currentDate = LocalDate.now();

        long numberOFDays = YEARS.between(myDate, currentDate);
        return "Tu edad es " + numberOFDays;
    }

    @GetMapping("/{numero}")
    public String suma(@PathVariable("numero") int numeroAlAzar) {
        int suma = 10+numeroAlAzar;
        return "el resultado es =" +suma;
    }

    @GetMapping("/hola")
    public String sum2(int random) {
        int suma = 10+random;
        return "el resultado es =" +suma;
    }

    @GetMapping("/hola2")
    public String saludo(){
        return "hola";
    }
}
