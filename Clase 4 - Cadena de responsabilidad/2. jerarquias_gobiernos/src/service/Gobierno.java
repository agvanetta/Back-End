package service;

import service.impl.Mensaje;

public abstract class Gobierno {

    private String nombreCompleto;

    // 1. Tipo Gobierno sig;
    protected Gobierno sigMiembroDelGobierno;

    // 2. procesarSolicitud dependiendo de cada clase

    public abstract void procesarMensaje(Mensaje mensaje);

    // 3. Setter del protected Gobierno SigMiembroDelGobierno?
    public Gobierno setSigMiembroDelGobierno(Gobierno sigMiembroDelGobierno) {
        this.sigMiembroDelGobierno = sigMiembroDelGobierno;
        return this;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Gobierno getSigMiembroDelGobierno() {
        return sigMiembroDelGobierno;
    }


    public Gobierno(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
