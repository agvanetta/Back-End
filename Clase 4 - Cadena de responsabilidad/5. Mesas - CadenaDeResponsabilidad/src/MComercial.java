public class MComercial extends Manejador{
    @Override
    public void comprobar(Mail mail) {

        if ((mail.getMailDeDestino() == "comercial@colmena.com" || mail.getTema() == "Comercial"))
        {
            System.out.println(mail.getCuerpoMail()+" | Este mensaje fue entregado al area comercial");
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
