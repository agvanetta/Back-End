package com.example.springmvc.service;

import com.example.springmvc.Dominio.Usuario;

public class UsuarioService {

    public Usuario crearUsuario(){
        Usuario usuario = new Usuario("Pupino",4);
        return usuario;
    };
}
