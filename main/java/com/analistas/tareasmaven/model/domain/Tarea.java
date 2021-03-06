package com.analistas.tareasmaven.model.domain;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Tarea {
    
    private int id;
    private String descripcion;
    private LocalDate fecha;
    private boolean cumplida;
    private Usuario usuario;

    //Propiedades formateadas
    private String estado;
    private String fechaESP;
    //Constructores

    public Tarea() {
    }

    public Tarea(int id, String descripcion, LocalDate fecha, boolean cumplida, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cumplida = cumplida;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isCumplida() {
        return cumplida;
    }

    public void setCumplida(boolean cumplida) {
        this.cumplida = cumplida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return isCumplida() ? "Finalizada" : "Pendiente";
    }

    public String getFechaESP() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(Date.valueOf(fecha.toString()));
    }
}
