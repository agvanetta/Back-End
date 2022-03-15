import daos.EstudianteDAOH2;
import entidades.Estudiante;
import servicios.EstudianteService;

public class Main {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante();

        estudiante.setId(1L); // la L es porque es LONG, si pones 1 lo toma como INT
        estudiante.setNombre("Agustin");
        estudiante.setApellido("Vanetta");

        EstudianteService estudianteService = new EstudianteService();
        // Definir la "estrategia" ; Seteamos la estrategia de presistencia , un DAO.
        estudianteService.setEstudianteIDAO(new EstudianteDAOH2());

        estudianteService.guardarEstudiante(estudiante);

        estudianteService.eliminarEstudiante(1L);

    }

}
