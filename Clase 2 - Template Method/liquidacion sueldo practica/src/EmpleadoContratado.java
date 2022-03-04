public class EmpleadoContratado extends Empleado{

    private double cantidadHorasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoContratado(String nombreCompleto, int legajo, int cuentaBancaria, double tarifaPorHora) {
        super(nombreCompleto, legajo, cuentaBancaria);
        this.tarifaPorHora = tarifaPorHora;
    }

    public double getCantidadHorasTrabajadas() {
        return cantidadHorasTrabajadas;
    }

    public void setCantidadHorasTrabajadas(double cantidadHorasTrabajadas) {
        this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    protected double calcularSueldo() {
        return cantidadHorasTrabajadas*tarifaPorHora;
    }

    @Override
    protected void impresion() {
        if (calcularSueldo()>0){
            System.out.println("La liquidación generada es un documento digital."); }
        else {
            System.out.println("La liquidación no pudo ser calculada");}
    }
}

