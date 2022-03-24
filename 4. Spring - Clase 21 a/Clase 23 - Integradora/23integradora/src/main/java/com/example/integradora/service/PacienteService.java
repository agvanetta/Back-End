package com.example.integradora.service;

import com.example.integradora.domain.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> listPacientes();

    List<Paciente> getAll();

    Paciente getPacienteByEmail(String email);
}
