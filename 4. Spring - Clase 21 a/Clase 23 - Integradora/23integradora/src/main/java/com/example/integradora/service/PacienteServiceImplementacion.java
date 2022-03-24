package com.example.integradora.service;

import com.example.integradora.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class PacienteServiceImplementacion implements PacienteService {

    @Override
    public List<Paciente> listPacientes() {
        return Arrays.asList(new Paciente(1L,"Vanetta","Agustin","agvanetta@dh.com",37732230)
                , new Paciente(2L,"Luca","Vanetta","luca@dh.com",1254));
    }

    private List<Paciente> pacientes = new ArrayList<>();
    @Override
    public List<Paciente> getAll() {
        return pacientes;
    }

    @Override
    public Paciente getPacienteByEmail(String email) {
        for (Paciente paciente : pacientes) {
        if (paciente.getEmail().equals(email)) {
            return paciente;
        }
    }
        return null;
    }
}
