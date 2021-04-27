/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.tareasmaven.model.service;

import com.analistas.tareasmaven.model.domain.Usuario;

/**
 *
 * @author ander
 */
public interface IUsuarioService {
    
    public boolean validar(String nombre, String clave);
    
    public Usuario buscarPorNombre(String nombre);
    
}
