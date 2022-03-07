public class ProcesaMail {
    public static void main(String[] args) {

        Mail correo1 = new Mail("Comercial","sinmail@colmena.com","Hola este es un correo electronico");

        CompruebaMail proceso = new CompruebaMail();

        proceso.comprobar(correo1);



    }
}
