
package com.analistas.tareasmaven.model.service;

import com.analistas.tareasmaven.model.domain.Tarea;
import com.analistas.tareasmaven.model.domain.Usuario;
import com.analistas.tareasmaven.model.repository.TareaRepository;
import java.util.List;

public class TareaServiceImpl implements ITareaService{
    
    TareaRepository repo = new TareaRepository();

    @Override
    public List<Tarea> listarPorUsuario(Usuario usuario) {
        return repo.selectByUsuario(usuario);
    }

    @Override
    public void guardar(Tarea tarea) {

        //Si es modificación...
        if(tarea.getId() > 0)
        repo.updateTarea(tarea);
        else
            repo.guardar(tarea);
    }

    @Override
    public void borrar(int id) {
        repo.borrar(id);

    }

    @Override
    public void cambiarEstado(int idTarea) {
        repo.updateCumplida(idTarea);

    }

    @Override
    public List<Tarea> buscarTodo() {
        return null;
    }

    @Override
    public List<Tarea> buscarPor(Usuario usuario, String criterio) {
        return repo.buscarPor(usuario, criterio);
    }

}
