public class Main {
    public static void main(String[] args) {

        // Vinculacion dinamica = Dinamyc Binding
        Cuenta cuenta = new CuentaCajaAhorro();
        cuenta.setSaldo(1000);
        //Polimorfismo
        cuenta.extraer(1500);
        System.out.println(cuenta.getSaldo() + " Queda en mil porque no se pudo realizar la operacion");

        // Creamos una nueva cuenta, y seteamos el saldo(o atributos) de la cuenta anterior getSaldo al setSaldo
        Cuenta cuenta2 = new CuentaCorriente();
        cuenta2.setSaldo(cuenta.getSaldo());
        System.out.println(cuenta.getSaldo());
        cuenta = cuenta2;

        cuenta.extraer(1500);
        System.out.println(cuenta.getSaldo() + " Se realizo porque cambio de tipo de cuenta");

        ////////////////////////////////////////////////////////

        Cuenta cuentaV2 = new Cuenta();
        cuentaV2.setSaldo(2000);
        cuentaV2.setNumero(11258);
        cuentaV2.setEstrategia(new EstrategiaCajaAhorro());

        cuentaV2.extraer(3000);
        System.out.println(cuentaV2.getSaldo() + "No extrae, excede el saldo");

        // Lo pasamos aplicando DAO ; cambiamos el tipo de estrategia, "el tipo de cuenta" y extraemos
        cuentaV2.setEstrategia(new EstrategiaCuentaCorriente());
        cuentaV2.extraer(3000);
        System.out.println(cuentaV2.getSaldo() + " Listo");
    }
}


// Tipos parametricos, permiten cambiar en tiempo de ejecucion