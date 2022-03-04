public class Main {
    public static void main(String[] args) {

        Empleado pompillaPompini = new EmpleadoContratado("Pompilla Pompini",27855,1478520369,7 );
        ((EmpleadoContratado) pompillaPompini).setCantidadHorasTrabajadas(120);

        pompillaPompini.liquidarSueldo();

        Empleado v2Pompilla = new EmpleadoEfectivo("Martin Martini",125478,1410258963,400);
        ((EmpleadoEfectivo) v2Pompilla).setDescuentos(40);
        ((EmpleadoEfectivo) v2Pompilla).setPremios(60);

        v2Pompilla.liquidarSueldo();

        Empleado errorEmpleado = new EmpleadoEfectivo("Agustin Vanetta", 2541,21245125,0);
        errorEmpleado.liquidarSueldo();
    }
}
