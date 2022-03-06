package service.impl;

import service.AccesoDocumento;

import java.util.List;

public class ProxyDrive implements AccesoDocumento {
    private GoogleDrive googleDrive;
    private List<String> UsuariosAutorizados;


    public ProxyDrive(GoogleDrive googleDrive, List<String> usuariosAutorizados) {
        this.googleDrive = googleDrive;
        this.UsuariosAutorizados = usuariosAutorizados;
    }

    //Si el usuario esta en la lista , nos conectamos.


    @Override
    public void accederAlDocumento(String mail, String url,Documento documento) {
        if(this.UsuariosAutorizados.contains(mail))
            this.googleDrive.accederAlDocumento(mail,url,documento);
        else
            System.out.println("El usuario "+ mail+ " no tiene permisos / no esta autorizado para acceder al documento "+documento.getId());
    }
}
