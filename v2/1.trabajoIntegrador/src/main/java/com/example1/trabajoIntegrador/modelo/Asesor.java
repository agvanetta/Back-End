package com.example1.trabajoIntegrador.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Asesores")
public class Asesor {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "asesor")
    @JsonIgnore // En relaciones OneToMany para evitar loop i.
    private Set<Reunion> reuniones;

    public Set<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(Set<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
