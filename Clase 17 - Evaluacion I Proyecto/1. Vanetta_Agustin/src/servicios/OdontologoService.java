package servicios;

import daos.InterfaceDAO;
import entidades.Odontologo;

import java.util.List;

public class OdontologoService {

    private InterfaceDAO<Odontologo> odontologoInterfaceDAO;

    public InterfaceDAO<Odontologo> getOdontologoInterfaceDAO() {
        return odontologoInterfaceDAO;
    }

    public void setOdontologoInterfaceDAO(InterfaceDAO<Odontologo> odontologoInterfaceDAO) {
        this.odontologoInterfaceDAO = odontologoInterfaceDAO;
    }

    public Odontologo guardarOdontologo(Odontologo o){
        // Delegarle la responsabilidad de guardar al DAO
        return odontologoInterfaceDAO.guardar(o);
    }

    public void eliminarOdontologo(Long id) {
        // Delegarle la responsabilidad
        odontologoInterfaceDAO.eliminar(id);
    }

    public Odontologo buscarOdontologo(Long id){
        // Delegarle la responsabilidad
        return odontologoInterfaceDAO.buscar(id);
    }

    public List<Odontologo> buscarTodos(){
        // Delegarle la responsabilidad
        return odontologoInterfaceDAO.buscarTodos();
    }
}
