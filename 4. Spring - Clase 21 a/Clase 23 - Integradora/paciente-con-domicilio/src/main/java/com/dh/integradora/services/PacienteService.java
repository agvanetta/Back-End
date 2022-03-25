package com.dh.integradora.services;

import com.dh.integradora.model.Domicilio;
import com.dh.integradora.model.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PacienteService {

    // Crea la lista de pacientes
    private List<Paciente> pacientes = new ArrayList<>();

    // Agrega un Domicilio
    Domicilio dom1 = new Domicilio(1,"Guemes",490,"Cordoba","Cordoba");
    // Agrega un paciente
    public PacienteService(){
        pacientes.add(new Paciente(1, "Vanetta","Agustin","ag.dh@gmail.com", "38545656", new Date(221,0,6), dom1));
    }

    // Los pide a todos
    public List<Paciente> getAll(){
        return pacientes;
    }

    // Busca uno por mail
    public Paciente getPacienteByEmail(String email){
        for (Paciente paciente : pacientes) {
            if (paciente.getEmail().equals(email)) {
                return paciente;
            }
        }
        return null;
    }
}
