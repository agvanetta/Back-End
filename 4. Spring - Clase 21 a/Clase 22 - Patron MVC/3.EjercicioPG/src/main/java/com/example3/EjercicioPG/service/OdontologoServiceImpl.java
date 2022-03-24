package com.example3.EjercicioPG.service;

import com.example3.EjercicioPG.domain.Odontologo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service

public class OdontologoServiceImpl implements OdontologoService {
    @Override
    public List<Odontologo> listaOdontologos() {
        return Arrays.asList(new Odontologo("Javier"), new Odontologo("Ramon"));
    }
}
