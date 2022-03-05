public class EmpleadoEfectivo extends Empleado{

    private double sueldoBasico;
    private double descuentos;
    private double premios;

    public EmpleadoEfectivo(String nombreCompleto, int legajo, int cuentaBancaria, double sueldoBasico) {
        super(nombreCompleto, legajo, cuentaBancaria);
        this.sueldoBasico = sueldoBasico;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double getPremios() {
        return premios;
    }

    public void setPremios(double premios) {
        this.premios = premios;
    }

    @Override
    protected double calcularSueldo() {
        return sueldoBasico - descuentos + premios;
    }

    @Override
    protected String impresion() {
        if (calcularSueldo()>0){
        return "digital"; }
    else {
        return "La liquidación no pudo ser calculada";}
    }
}
