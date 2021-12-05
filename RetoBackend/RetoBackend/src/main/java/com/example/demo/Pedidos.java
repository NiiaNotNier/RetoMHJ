package com.example.demo;

import java.sql.Date;

public class Pedidos {
    public int IdPedido;
    public int CantProductos;
    public Date FechaCreacion;
    public String NombreUsuario;
    public String Estado;

    public Pedidos(int IdPedido, int cantProductos, Date fechaCreacion, String nombreUsuario, String estado) {
        CantProductos = cantProductos;
        FechaCreacion = fechaCreacion;
        NombreUsuario = nombreUsuario;
        Estado = estado;
    }

    public int getCantProductos() {
        return CantProductos;
    }

    public void setCantProductos(int cantProductos) {
        CantProductos = cantProductos;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int idPedido) {
        IdPedido = idPedido;
    }

}
