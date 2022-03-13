package com.dh.banco;

import com.dh.banco.service.EmpleadoBanco;
import com.dh.banco.service.impl.Director;
import com.dh.banco.service.impl.EjecutivoCuenta;
import com.dh.banco.service.impl.Gerente;

public class Main {

    public static void main(String[] args) {
        // Establecer la cadena de responsablidad
        EmpleadoBanco manejadorBase = new EjecutivoCuenta().setSigEmpleadoBanco(new Gerente().setSigEmpleadoBanco(new Director()));
        // Utilizar la cadena de responsabilidad para procesar una solicitud
        manejadorBase.procesarSolicitud(78000);

    }
}
