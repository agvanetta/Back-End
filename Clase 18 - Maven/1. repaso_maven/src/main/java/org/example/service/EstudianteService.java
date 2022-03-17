package org.example.service;

import org.example.dao.IDao;
import org.example.model.Estudiante;

import java.util.List;

public class EstudianteService {

    private IDao<Estudiante> estudianteDao;

    public EstudianteService() {

    }

    public EstudianteService( IDao<Estudiante> estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    public void setEstudianteDao( IDao<Estudiante> estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    public Estudiante guardarEstudiante(Estudiante estudiante){
        estudianteDao.guardar(estudiante);
        return estudiante;
    }

    public void eliminarEstudiante(Long id){
        estudianteDao.eliminar(id);
    }
    public Estudiante buscar(Long id){
        return estudianteDao.buscar(id);
    }

    public List<Estudiante> buscarTodos(){
        return estudianteDao.buscarTodos();
    }

}
