package com.example;

import java.util.ArrayList;

public class MyList {

    public ArrayList<Productos> productosMyList;

    public MyList(ArrayList<Productos> productosMyList) {
        this.productosMyList = new ArrayList<Productos>();
    }

    public ArrayList<Productos> getProductosMyList() {
        return productosMyList;
    }

    public boolean contains(Productos producto) {
        for (Productos p : productosMyList) {
            if (p.getIdProducto() == producto.getIdProducto()) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Productos producto) {
        if (!contains(producto)) {
            this.productosMyList.add(producto);
            return true;
        }
        return false;
    }

    public boolean remove(Productos producto) {
        if (contains(producto)) {
            this.productosMyList.remove(producto);
            return true;
        }
        return false;
    }
}
