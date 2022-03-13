public class MSpam extends Manejador {
    @Override
    public void comprobar(Mail mail) {
        System.out.println("Marcado como Spam");
    }
}