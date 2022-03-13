package com.main;
import org.apache.log4j.Logger;

public class Leon {

    private static final Logger logger = Logger.getLogger(Leon.class);

    private String nombre;
    private int edad;
    private boolean esAlfa;


    public void correr(){
        logger.info("El Leon "+nombre+" esta corriendo!!!");
    }
    public void esMayorA10(){
        try {
            if (edad<0)
                throw new Exception("Valores invalidos");
        } catch (Exception e){
            logger.error("Ocurrio un error en "+e);
        }
        if(esAlfa && edad>10){
            logger.info("El Leon tiene una edad de "+edad+" y es Alfa.");
        }

    }

    public Leon(String nombre, int edad, boolean esAlfa) {
        this.nombre = nombre;
        this.edad = edad;
        this.esAlfa = esAlfa;
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

    public boolean isEsAlfa() {
        return esAlfa;
    }

    public void setEsAlfa(boolean esAlfa) {
        this.esAlfa = esAlfa;
    }
}
