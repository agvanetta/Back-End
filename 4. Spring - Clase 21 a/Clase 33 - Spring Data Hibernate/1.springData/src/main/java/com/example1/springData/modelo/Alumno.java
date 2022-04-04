package com.example1.springData.modelo;


import javax.persistence.*;

@Entity
@Table // Buena practica no es necesario si tu tabla va a tener la misma clase
public class Alumno {

    @Id
    @SequenceGenerator(name = "alumno_sequence", sequenceName = "alumno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Long id;
    private String nombre;
    private int edad;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)// Si elimino, por cascada elimina todos los alumnos
    @JoinColumn(name = "escuela_id") // Foreing Key
    private Escuela escuela;

    public Alumno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
