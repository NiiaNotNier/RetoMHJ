package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductosController {
    public static ArrayList<Productos> productos = new ArrayList(Arrays.asList(

            new Productos(1, "Teclado", 25.95, ""),
            new Productos(2, "Mouse", 25.95, ""),
            new Productos(3, "Monitor", 25.95, ""),
            new Productos(4, "Impresora", 25.95, ""),
            new Productos(5, "Proyector", 25.95, ""),
            new Productos(6, "Pantalla", 25.95, ""),
            new Productos(7, "Celular", 25.95, ""),
            new Productos(8, "Tablet", 25.95, ""),
            new Productos(9, "Laptop", 25.95, ""),
            new Productos(10, "Cable", 25.95, "")));

    public static ArrayList<Productos> productosMyList = new ArrayList(Arrays.asList());

    @GetMapping("ProductosMyList")
    public List<Productos> GetProductosMyList() {
        return productosMyList;
    }

    @GetMapping("Productos")
    public List<Productos> GetProductos() {
        return productos;
    }

    @GetMapping("Productos/{NombreProducto}")
    public static Productos ProductoByNombre(@PathVariable("NombreProducto") String NombreProducto) {
        return FindProductoByNombreProducto(NombreProducto);
    }

    public static Productos FindProductobyNombre(String NombreProducto) {
        for (Productos producto : productos) {
            if (producto.getNombreProducto() == NombreProducto) {
                return producto;
            }
        }
        throw new ElementNotFoundException();
    }

    private static Productos FindProductoByNombreProducto(String NombreProducto) {
        return null;
    }

    // findProductobyPrecio
    public static Productos FindProductoByPrecio(double precio) {
        for (Productos producto : productos) {
            if (producto.getPrecio() == precio) {
                return producto;
            }
        }
        throw new ElementNotFoundException();
    }

    @PostMapping("/Productos")
    public Productos AddProducto(@RequestBody Productos newProducto) {
        productos.add(newProducto);
        return newProducto;
    }

    // @PutMapping("/Productos/{NombreProducto}")
    @PutMapping("/Productos/{idProducto}")
    public Productos updateProductos(@PathVariable("idProducto") int idProducto, @RequestBody Productos updateProducto)
            throws Exception {
        Productos m = FindProductobyNombreProducto(NombreProducto);
        m.setPrecio(updateProducto.getPrecio());
        return m;
    }

    // @DeleteMapping("/Productos/{NombreProducto}")
    @DeleteMapping("/Productos/{NombreProducto}")
    public Productos DeleteProducto(@PathVariable("NombreProducto") String NombreProducto) {
        Productos producto = FindProductobyNombreProducto(NombreProducto);
        productos.remove(NombreProducto);
        return producto;
    }

}
