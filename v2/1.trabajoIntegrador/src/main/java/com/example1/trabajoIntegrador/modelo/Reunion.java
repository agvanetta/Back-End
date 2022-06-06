package com.example1.trabajoIntegrador.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Reuniones")
public class Reunion {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne // Hay una propiedad, no una coleccion. por es es ToOne. Desde el otro lado parte
    @JoinColumn(name = "cliente_id", nullable = false) // Foreing Key
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "asesor_id", nullable = false)
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
