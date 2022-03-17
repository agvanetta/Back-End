import daos.OdontologoDAOH2;
import entidades.Odontologo;
import servicios.OdontologoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoInterfaceDAO(new OdontologoDAOH2());

        List<Odontologo> od = odontologoService.buscarTodos();
        System.out.println(od);
    }
}
