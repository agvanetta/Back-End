package com.example3.claveCompuestav2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="personas")
@IdClass(value=PersonaKey.class)  // Clase que contiene la clave compuesta "PersonaKey"
public class Persona {

    @Id
    private Integer dni;
    @Id
    private Integer numTramite;



    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(Integer numTramite) {
        this.numTramite = numTramite;
    }
}
