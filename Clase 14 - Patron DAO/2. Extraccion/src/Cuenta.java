public  class Cuenta {

    private int numero;
    private double saldo;
    private EstrategiaExtraccion estrategia;

    public void setEstrategia(EstrategiaExtraccion estrategia) {
        this.estrategia = estrategia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // El metodo extraer, utiliza el metodo extraer de la interface . Con this hace referencia a "esta cuenta"
     public boolean extraer(double monto){
        return estrategia.extraer(this, monto);
     }
}
