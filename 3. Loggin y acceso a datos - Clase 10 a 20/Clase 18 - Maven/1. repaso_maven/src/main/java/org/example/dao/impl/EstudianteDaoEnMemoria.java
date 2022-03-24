package org.example.dao.impl;

import org.example.dao.IDao;
import org.example.model.Estudiante;

import java.util.List;

public class EstudianteDaoEnMemoria implements IDao<Estudiante> {
    private List<Estudiante> estudianteRepositorio;

    public EstudianteDaoEnMemoria(List<Estudiante> estudianteRepositorio) {
        this.estudianteRepositorio = estudianteRepositorio;
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        estudianteRepositorio.add(estudiante);
        return estudiante;
    }

    @Override
    public Estudiante buscar(Long id) {
        Estudiante estudianteBuscado = null;
        int i = 0;
        while(i < estudianteRepositorio.size() && estudianteBuscado == null){
            Estudiante estudiante = estudianteRepositorio.get(i);
            if(estudiante.getId() == id) {
               estudianteBuscado = estudiante;
            }
            i++;
        }
        return estudianteBuscado;
    }

    @Override
    public void eliminar(Long id) {
        Estudiante estudiante = buscar(id);
        estudianteRepositorio.remove(estudiante);
    }

    @Override
    public List<Estudiante> buscarTodos() {
        return estudianteRepositorio;
    }
}
