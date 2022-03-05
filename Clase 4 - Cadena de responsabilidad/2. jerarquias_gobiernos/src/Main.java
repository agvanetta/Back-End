import service.Gobierno;
import service.impl.Diputado;
import service.impl.Mensaje;
import service.impl.Ministro;
import service.impl.Presidente;

public class Main {
    public static void main(String[] args) {

        Mensaje privado121 = new Mensaje("El rojo no existe", 2);

        Gobierno manejadorBase = new Diputado("Pupino").setSigMiembroDelGobierno(new Ministro("Luca").setSigMiembroDelGobierno(new Presidente("Apollo")));

        manejadorBase.procesarMensaje(privado121);

    }
}