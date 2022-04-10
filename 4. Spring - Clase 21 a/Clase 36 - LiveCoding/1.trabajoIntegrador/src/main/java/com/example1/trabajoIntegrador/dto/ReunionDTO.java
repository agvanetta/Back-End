package com.example1.trabajoIntegrador.dto;

import com.example1.trabajoIntegrador.modelo.Cliente;
import com.example1.trabajoIntegrador.modelo.Asesor;

public class ReunionDTO {

    private Long id;
    private Cliente cliente;
    private Asesor asesor;
    private String fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
