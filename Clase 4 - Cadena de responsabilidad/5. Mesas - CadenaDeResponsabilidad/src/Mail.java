public class Mail {

    private String Tema;
    private String MailDeDestino;
    private String CuerpoMail;

    public Mail(String tema, String mailDeDestino, String cuerpoMail) {
        Tema = tema;
        MailDeDestino = mailDeDestino;
        CuerpoMail = cuerpoMail;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        Tema = tema;
    }

    public String getMailDeDestino() {
        return MailDeDestino;
    }

    public void setMailDeDestino(String mailDeDestino) {
        MailDeDestino = mailDeDestino;
    }


    public String getCuerpoMail() {
        return CuerpoMail;
    }

    public void setCuerpoMail(String cuerpoMail) {
        CuerpoMail = cuerpoMail;
    }
}
