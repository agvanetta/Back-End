public class MGerencia extends Manejador{

    @Override
    public void comprobar(Mail mail) {

        if ((mail.getMailDeDestino() == "gerencia@colmena.com" || mail.getTema() == "Gerencia"))
        {
            System.out.println(mail.getCuerpoMail()+" | Este mensaje fue entregado a gerencia");
        }
        else
        {
            if( this.getSiguiente() != null )
            {
                // Llamamos al método en el siguiente objeto
                this.getSiguiente().comprobar( mail );
            }
        }

    }


}
