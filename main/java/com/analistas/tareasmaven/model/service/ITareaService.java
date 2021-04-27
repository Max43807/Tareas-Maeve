/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.tareasmaven.model.service;

import com.analistas.tareasmaven.model.domain.Tarea;
import com.analistas.tareasmaven.model.domain.Usuario;
import java.util.List;
public interface ITareaService {
    
    public List<Tarea> listarPorUsuario(Usuario usuario);
    
    public void guardar(Tarea tarea);
    
    public void borrar(int id);

    public void cambiarEstado(int idTarea);

    public List<Tarea> buscarTodo();

    public List<Tarea> buscarPor(Usuario usuario, String criterio);
    
}
