import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Tarjeta tarjetaVisa = new Debito(1234568789,693, LocalDate.of(2023,02,02));
        ((Debito) tarjetaVisa).setSaldoDisponible(1000);

        System.out.println(tarjetaVisa.tarjetValida());

        tarjetaVisa.procesarPago(900);

    }
}
