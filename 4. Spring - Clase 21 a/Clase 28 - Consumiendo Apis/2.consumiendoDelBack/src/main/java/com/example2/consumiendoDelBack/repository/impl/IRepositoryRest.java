package com.example2.consumiendoDelBack.repository.impl;

import com.example2.consumiendoDelBack.dto.MedicamentoDTO;

public interface IRepositoryRest<T> {

    public T guardar(T t);
    public T buscar(Integer id);
    public T update(T t);
    public String eliminar(Integer id);

}
