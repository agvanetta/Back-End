package com.example.springmvc.controller;

import com.example.springmvc.Dominio.Usuario;
import com.example.springmvc.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/")
    public Usuario crearUsuario(){
        return usuarioService.crearUsuario();
    }

    @GetMapping("Crear2")
    public Usuario crearUsuario2(){
        Usuario usuario = new Usuario("Luca",1);
        return usuario;
    }
}
