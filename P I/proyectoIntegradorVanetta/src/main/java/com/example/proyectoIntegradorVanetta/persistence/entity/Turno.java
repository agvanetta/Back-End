package com.example.proyectoIntegradorVanetta.persistence.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Turno {

    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;
    private String hora;

    public Turno(){}

    public Turno(Integer id, Paciente paciente, Odontologo odontologo, LocalDate fecha, String hora) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turno)) return false;
        Turno turno = (Turno) o;
        return getFecha().equals(turno.getFecha()) && getHora().equals(turno.getHora());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFecha(), getHora());
    }
}
