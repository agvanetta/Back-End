package service.impl;

import service.Gobierno;

import java.time.LocalDateTime;

public class Diputado extends Gobierno {


    public Diputado(String nombreCompleto) {
        super(nombreCompleto);
    }

    @Override
    public void procesarMensaje(Mensaje mensaje) {
        if (mensaje.getTipo() == 1) {
            System.out.println(mensaje.getContenido() + " leido por "+getNombreCompleto()+" a las "+ LocalDateTime.now());
        } else if (this.sigMiembroDelGobierno != null) {
            this.sigMiembroDelGobierno.procesarMensaje(mensaje);
        }
      }
    }
