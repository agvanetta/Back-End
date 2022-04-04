package com.example1.springData.modelo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Escuela {

    @Id
    @SequenceGenerator(name = "escuela_sequence", sequenceName = "escuela_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "escuela_sequence")
    private Long id;
    private String nombre;
    private String direccion;
    @OneToMany(mappedBy = "escuela", fetch = FetchType.LAZY)
    //No va a cargar los alumnos asociados, hasta que no los necesite
    private Set<Alumno> alumnos = new HashSet<>();

    public Escuela(){

    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
