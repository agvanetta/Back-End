import daos.DomicilioDAOH2;
import daos.InterfaceDAO;
import daos.PacienteDAOH2;
import entidades.Domicilio;
import entidades.Paciente;
import servicios.PacienteService;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Domicilio dom1 = new Domicilio(8L,"Guemes",490,"Capital","Cordoba");
        Paciente pac1 = new Paciente(8L,"Pupe","Agustin",37732203,new Date(),dom1);

        PacienteService pacienteService = new PacienteService();
        // Definir la "estrategia" ; Seteamos la estrategia de presistencia , un DAO.
        pacienteService.setPacienteInterfaceDAO(new PacienteDAOH2());

        PacienteService pacienteService2 = new PacienteService();
        // Definir la "estrategia" ; Seteamos la estrategia de presistencia , un DAO.
        pacienteService2.setDomicilioInterfaceDAO(new DomicilioDAOH2());

        //pacienteService2.getDomicilioInterfaceDAO().guardar(dom1);
        //pacienteService.guardarPaciente(pac1);

        //pacienteService.buscarTodos();
       // pacienteService2.getDomicilioInterfaceDAO().buscarTodos();

        //pacienteService2.getDomicilioInterfaceDAO().buscar(1L);

        List<Paciente> pacientes = pacienteService.buscarTodos();
        System.out.println(pacientes);
        pacienteService.buscarTodos();
    }
}
