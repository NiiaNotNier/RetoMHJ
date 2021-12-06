package com.example.demo;

public class Pedidos {
    public int IdPedido;
    public int CantProductos;
    public String FechaCreacion;
    public String NombreUsuario;
    public String Estado;

<<<<<<< HEAD:RetoBackend/RetoBackend/src/main/java/com/example/demo/Pedidos.java
    public Pedidos(int idPedido, int cantProductos, Date fechaCreacion, String nombreUsuario, String estado) {
=======
    public Pedidos(int idPedido, int cantProductos, String fechaCreacion, String nombreUsuario, String estado) {
>>>>>>> 9092fd4a071119367fa1039a4676c0c7701c669f:RetoBackend/RetoBackend/src/main/java/com/example/demo/Models/Pedidos.java
        IdPedido = idPedido;
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

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
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
