package Test;

import daos.OdontologoDAOH2;
import entidades.Odontologo;
import org.junit.Assert;
import servicios.OdontologoService;
import java.util.List;

class OdontologoServiceTest {

    Odontologo od1 = new Odontologo(55L,17,"Gabriel","Hauche");
    Odontologo od2 = new Odontologo(65l,22,"Diego","Milito");
    Odontologo od3 = new Odontologo(75L,23,"Gustavo","Bou");

    private static OdontologoService odontologoService = new OdontologoService();


    @org.junit.jupiter.api.Test
    public void buscarTodos() {
        odontologoService.setOdontologoInterfaceDAO(new OdontologoDAOH2());
        odontologoService.guardarOdontologo(od1);
        odontologoService.guardarOdontologo(od2);
        odontologoService.guardarOdontologo(od3);

        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() > 0);
        System.out.println(odontologos);
    }
}
