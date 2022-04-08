package com.example1.trabajoIntegrador.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Cursadas")
public class Cursada {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne // Hay una propiedad, no una coleccion. por es es ToOne. Desde el otro lado parte
    @JoinColumn(name = "estudiante_id", nullable = false) // Foreing Key
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
    private double nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
