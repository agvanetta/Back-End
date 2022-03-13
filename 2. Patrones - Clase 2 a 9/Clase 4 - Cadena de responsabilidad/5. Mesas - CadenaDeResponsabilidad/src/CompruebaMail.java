public class CompruebaMail {

    Manejador inicial;

    public CompruebaMail(){
        this.inicial = new MGerencia();
        MTecnico tecnica = new MTecnico();
        MComercial comercial = new MComercial();
        MSpam spam = new MSpam();

        inicial.setSiguiente(tecnica);
        tecnica.setSiguiente(comercial);
        comercial.setSiguiente(spam);
    }

    public void comprobar(Mail mail){
        inicial.comprobar(mail);
    }

}
