package com.example1.springData.service;

import com.example1.springData.dao.AlumnoRepository;
import com.example1.springData.modelo.Alumno;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlumnoServicioImpl {

    private AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoServicioImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> buscarTodos(){
       return alumnoRepository.findAll();
    }

    public Alumno buscarPorNombre(String nombre){
        return alumnoRepository.buscarAlumno(nombre).get(); // Devuelve un opcional, agrega.get
    }
}
