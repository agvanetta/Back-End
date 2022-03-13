import java.time.LocalDate;

public class Credito extends Tarjeta {

    private double limite;
    private double saldoUtilizado;

    public Credito(int numerosDelFrente, int codigoDeSeguridad, LocalDate fechaDeExpiracion) {
        super(numerosDelFrente, codigoDeSeguridad, fechaDeExpiracion);
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
    }

    @Override
    protected boolean pagoAutorizado(double Monto) {
        if ((limite-saldoUtilizado) >= Monto){
            return true;
        } else {
            return false;
        }
    }
}