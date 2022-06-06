package com.example1.trabajoIntegrador.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Materias")
public class Materia {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "materia")
    @JsonIgnore // En relaciones OneToMany para evitar loop i.
    private Set<Cursada> cursadas;

    public Set<Cursada> getCursadas() {
        return cursadas;
    }

    public void setCursadas(Set<Cursada> cursadas) {
        this.cursadas = cursadas;
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
}
