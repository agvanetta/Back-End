import service.AccesoDocumento;
import service.impl.Documento;
import service.impl.GoogleDrive;
import service.impl.ProxyDrive;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> usuariosHabilitados = Arrays.asList("apolo@gmail.com","pupino@gmail.com","luca@gmail.com");
        Documento proxyDOC = new Documento("ab22","www.googledrive.com/22","Subir el resultado a git",usuariosHabilitados);

        AccesoDocumento proxy = new ProxyDrive(new GoogleDrive(),usuariosHabilitados);

        proxy.accederAlDocumento("apolo@gmail.com","www.googledrive.com/22", proxyDOC);

        proxy.accederAlDocumento("asd@gmail.com", "www.googledrive.com/22", proxyDOC);
    }
}
