import java.time.LocalDate;

public class Debito extends Tarjeta {

    private double saldoDisponible;

    public Debito(int numerosDelFrente, int codigoDeSeguridad, LocalDate fechaDeExpiracion) {
        super(numerosDelFrente, codigoDeSeguridad, fechaDeExpiracion);
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    protected boolean pagoAutorizado(double Monto) {
        if (saldoDisponible >= Monto) {
            return true;
        } else {
            return false;
        }
    }
}