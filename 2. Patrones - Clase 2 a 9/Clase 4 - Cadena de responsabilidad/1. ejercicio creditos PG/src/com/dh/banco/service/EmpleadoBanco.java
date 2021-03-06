package com.dh.banco.service;

public abstract class EmpleadoBanco {

    protected EmpleadoBanco sigEmpleadoBanco; // o private

    public abstract void procesarSolicitud(Integer monto);

    public EmpleadoBanco setSigEmpleadoBanco(EmpleadoBanco sigEmpleadoBanco) {
        this.sigEmpleadoBanco = sigEmpleadoBanco;
        return this;
    }
}
