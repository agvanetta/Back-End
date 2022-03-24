package servicios;

import daos.IDAO;
import entidades.Estudiante;

import java.util.List;

public class EstudianteService {

    private IDAO<Estudiante> estudianteIDAO;

    public IDAO<Estudiante> getEstudianteIDAO() {
        return estudianteIDAO;
    }

    public void setEstudianteIDAO(IDAO<Estudiante> estudianteIDAO) {
        this.estudianteIDAO = estudianteIDAO;
    }

    public Estudiante guardarEstudiante(Estudiante e){
        // Delegarle la responsabilidad de guardar al DAO
        return estudianteIDAO.guardar(e);
    }

    public void eliminarEstudiante(Long id) {
        // Delegarle la responsabilidad
        estudianteIDAO.eliminar(id);
    }

    public Estudiante buscarEstudiante(Long id){
        // Delegarle la responsabilidad
            return estudianteIDAO.buscar(id);
    }

    public List<Estudiante> buscarTodos(){
        // Delegarle la responsabilidad
        return estudianteIDAO.buscarTodos();
    }


}
