package com.example;

public class OrderProduct {

    public int IdPedido;
    public String Productos;
    public int CantProductos;

    public OrderProduct(int idPedido,  String productos, int cantProductos) { //int idProducto?
        IdPedido = idPedido;
        Productos = productos;
        CantProductos = cantProductos;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int idPedido) {
        IdPedido = idPedido;
    }

    public String getProductos() {
        return Productos;
    }

    public void setProductos(String productos) {
        Productos = productos;
    }

    public int getCantProductos() {
        return CantProductos;
    }

    public void setCantProductos(int cantProductos) {
        CantProductos = cantProductos;
    }

}
