import java.time.LocalDate;

public abstract class Tarjeta {

    private int numerosDelFrente;
    private int codigoDeSeguridad;
    private LocalDate fechaDeExpiracion;

    public Tarjeta(int numerosDelFrente, int codigoDeSeguridad, LocalDate fechaDeExpiracion) {
        this.numerosDelFrente = numerosDelFrente;
        this.codigoDeSeguridad = codigoDeSeguridad;
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    public int getNumerosDelFrente(int i) {
        return numerosDelFrente;
    }

    public void setNumerosDelFrente(int numerosDelFrente) {
        this.numerosDelFrente = numerosDelFrente;
    }

    public int getCodigoDeSeguridad() {
        return codigoDeSeguridad;
    }

    public void setCodigoDeSeguridad(int codigoDeSeguridad) {
        this.codigoDeSeguridad = codigoDeSeguridad;
    }

    public LocalDate getFechaDeExpiracion() {
        return fechaDeExpiracion;
    }

    public void setFechaDeExpiracion(LocalDate fechaDeExpiracion) {
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    // Si la fecha que vas a comparar(venc) es anterior al argumento FechaActual,
    // el método devolverá un valor menor a cero. Si la fecha que vas a
    // comparar es posterior al argumento date, el método devolverá un
    // valor mayor a cero.

    public boolean tarjetValida (){
        if ((fechaDeExpiracion.compareTo(LocalDate.now())) > 0){
            return true;
        } else {
            return false;
        }
    }
    protected abstract boolean pagoAutorizado(double Monto);

    public void procesarPago (double Monto){
        if (tarjetValida() && pagoAutorizado(Monto)){
            System.out.println("EL PAGO SE GENERO CON EXITO");
        } else {
            System.out.println("PAGO RECHAZADO");
        }
    }


}
