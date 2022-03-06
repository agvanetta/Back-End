package service;

import service.impl.Documento;

public interface AccesoDocumento {

    public void accederAlDocumento(String mail, String url, Documento documento);
}
