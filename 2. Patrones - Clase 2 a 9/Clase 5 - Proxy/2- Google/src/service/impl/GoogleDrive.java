package service.impl;

import service.AccesoDocumento;

public class GoogleDrive implements AccesoDocumento {

    @Override
    public void accederAlDocumento(String mail, String url, Documento documento) {
        System.out.println("El usuario " + mail+" tiene permisos para acceder al documento "+url);
        System.out.println("El mensaje dice : " + documento.getContenido());
    }
}
