package servicios;

import daos.InterfaceDAO;
import entidades.Domicilio;
import entidades.Paciente;

import java.util.List;

public class PacienteService {

    private InterfaceDAO<Paciente> pacienteInterfaceDAO;
    private InterfaceDAO<Domicilio> domicilioInterfaceDAO;

    public InterfaceDAO<Paciente> getPacienteInterfaceDAO() {
        return pacienteInterfaceDAO;
    }

    public InterfaceDAO<Domicilio> getDomicilioInterfaceDAO() {
        return domicilioInterfaceDAO;
    }

    public void setDomicilioInterfaceDAO(InterfaceDAO<Domicilio> domicilioInterfaceDAO) {
        this.domicilioInterfaceDAO = domicilioInterfaceDAO;
    }

    public void setPacienteInterfaceDAO(InterfaceDAO<Paciente> pacienteInterfaceDAO) {
        this.pacienteInterfaceDAO = pacienteInterfaceDAO;
    }

    public Paciente guardarPaciente(Paciente p){
        // Delegarle la responsabilidad de guardar al DAO
        return pacienteInterfaceDAO.guardar(p);
    }

    public void eliminarPaciente(Long id) {
        // Delegarle la responsabilidad
        pacienteInterfaceDAO.eliminar(id);
    }

    public Paciente buscarPaciente(Long id){
        // Delegarle la responsabilidad
        return pacienteInterfaceDAO.buscar(id);
    }

    public List<Paciente> buscarTodos(){
        // Delegarle la responsabilidad
        return pacienteInterfaceDAO.buscarTodos();
    }

}
