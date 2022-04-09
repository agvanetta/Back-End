package com.example1.mongoDB.controller;

import com.example1.mongoDB.model.Producto;
import com.example1.mongoDB.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto p){
        return productoService.guardar(p);
    }

    @GetMapping
    public List<Producto> listar(){
        return productoService.listar();
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        productoService.eliminar(id);
        return "eliminado";
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Integer id){
        return productoService.buscar(id);
    }
}
