package com.example.apiRestII.daos;

import java.util.List;

public interface InterfaceDAO<T> {
    public T guardar(T t);
    public void eliminar(Long id);
    public T buscar(Long id);
    public List<T> buscarTodos();
}
