public class MTecnico extends Manejador{
    @Override
    public void comprobar(Mail mail) {
        if ((mail.getMailDeDestino() == "Tecnica@colmena.com" || mail.getTema() == "Tecnico"))
        {
            System.out.println(mail.getCuerpoMail()+" | Este mensaje fue entregado al area tecnica");
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
