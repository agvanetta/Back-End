public abstract class Empleado {

    private String nombreCompleto;
    private int legajo;
    private int cuentaBancaria;

    public void liquidarSueldo(){
    calcularSueldo();
    impresion();
    deposito();
    if (calcularSueldo()>0)System.out.println("Saldo a liquidar " + calcularSueldo());
    }

    public Empleado(String nombreCompleto, int legajo, int cuentaBancaria) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(int cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    protected abstract double calcularSueldo();
    protected abstract void impresion();

    public boolean deposito(){
        if(calcularSueldo()>0){
            return true;
        } else {
            return false;
        }
    }

}
