package com.example1.trabajoIntegrador.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Estudiantes")

public class Estudiante {

    @Id // Id por default ; requerido
    @GeneratedValue // Si no se lo pasamos, que se autogenere
    private Long id;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "estudiante" ) // Como se llama la propiedad del a clase con la que se relaciona
    @JsonIgnore // ignora la propiedad
    private Set<Cursada> cursadas; // Puede tener muchas cursadas, una coleccion

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
