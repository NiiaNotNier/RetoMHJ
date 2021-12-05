package com.example.demo;

public class Productos {
    public int IdProducto;
    public String NombreProducto;
    public double Precio;
    public String Img;

    public Productos(int idProducto, String nombreProducto, double precio, String img) {
        this.NombreProducto = nombreProducto;
        this.Precio = precio;
        this.IdProducto = idProducto;
        this.Img = img;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int idProducto) {
        IdProducto = idProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public Productos() {
    }

}
