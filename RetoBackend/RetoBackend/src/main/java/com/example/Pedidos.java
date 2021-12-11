package com.example;

import java.util.ArrayList;
import java.util.Calendar;

import com.example.Models.OrderStatus;


public class Pedidos {
    public int IdPedido;
    public String FechaCreacion;
    public String NombreUsuario;
    public OrderStatus Estado;

    public ArrayList<OrderProduct> productitos;
    public ArrayList<Productos> listaFavoritos;


    public Pedidos() {
        productitos = new ArrayList<OrderProduct>();
        listaFavoritos = new ArrayList<Productos>();
        FechaCreacion = Calendar.getInstance().getTime().toString();
        NombreUsuario = "Default User";
        Estado = OrderStatus.PENDIENTE;
    }

    public Pedidos(int idPedido, String fechaCreacion, String nombreUsuario, OrderStatus estado) {
        IdPedido = idPedido;
        FechaCreacion = fechaCreacion;
        NombreUsuario = nombreUsuario;
        Estado = OrderStatus.PENDIENTE;
        productitos = new ArrayList<OrderProduct>();
        listaFavoritos = new ArrayList<Productos>();
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

    public OrderStatus getEstado() {
        return Estado;
    }

    public void setEstado(OrderStatus estado) {
        Estado = estado;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int idPedido) {
        IdPedido = idPedido;
    }
    public ArrayList<OrderProduct> getProductitos() {
        return productitos;
    }

    public void setProductitos(ArrayList<OrderProduct> productitos) {
        this.productitos = productitos;
    }

    public ArrayList<Productos> getListaFavoritos() {
        return listaFavoritos;
    }

    public void setListaFavoritos(ArrayList<Productos> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }

    public void addCantidadOfProducto(Productos producto){
        for (OrderProduct orderProduct : productitos) {
            if(orderProduct.getProductos().IdProducto == producto.IdProducto){
                orderProduct.autoCantidad();
                return;
            }    
        }
        productitos.add(new OrderProduct(producto, 1));
    }
}
