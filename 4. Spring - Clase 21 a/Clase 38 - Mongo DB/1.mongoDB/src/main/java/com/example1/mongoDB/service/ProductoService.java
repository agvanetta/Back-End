package com.example1.mongoDB.service;

import com.example1.mongoDB.model.Producto;
import com.example1.mongoDB.respository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto guardar(Producto p){
        return productoRepository.save(p);
    }

    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    public Producto buscar(Integer id){
        return productoRepository.findById(id).orElseGet(null);
        // Devuelve un opcional, le agregamos este metodo para que en caso de que no exista
        // nos devolvera un null. Podemos crear un producto por defecto
    }

    public void eliminar(Integer id){
        productoRepository.deleteById(id);
    }
}
