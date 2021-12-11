package com.example.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.ElementNotFoundException;
import com.example.Models.Productos;

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

            new Productos(1, "Teclado", 24, "https://images.app.goo.gl/xwnFYdSjZ7JVXFpC6"),
            new Productos(2, "Mouse", 15, ""),
            new Productos(3, "Monitor", 210, ""),
            new Productos(4, "Impresora", 115, ""),
            new Productos(5, "Proyector", 180, ""),
            new Productos(6, "Pantalla", 300, ""),
            new Productos(7, "Móvil", 360.00, ""),
            new Productos(8, "Tablet", 80.00, ""),
            new Productos(9, "Laptop", 500.00, "")));

    public static ArrayList<Productos> productosMyList = new ArrayList(Arrays.asList());
    public static ArrayList<Productos> shoppingList = new ArrayList<>(Arrays.asList());

    @GetMapping("ProductosMyList")
    public List<Productos> GetProductosMyList() {
        return productosMyList;
    }

    @GetMapping("Productos")
    public List<Productos> GetAllProductos() {
        return productos;
    }

    @GetMapping("Productos/{NombreProducto}")
    public static Productos ProductoByNombre(@PathVariable("NombreProducto") String NombreProducto) {
        return FindProductoByNombreProducto(NombreProducto);
    }

    public static Productos FindProductoByNombreProducto(String NombreProducto) {
        for (Productos producto : productos) {
            if (producto.getNombreProducto() == NombreProducto) {
                return producto;
            }
        }
        throw new ElementNotFoundException();
    }

    public static Productos FindProductoByPrecio(double precio) {
        for (Productos producto : productos) {
            if (producto.getPrecio() == precio) {
                return producto;
            }
        }
        throw new ElementNotFoundException();
    }

    public static Productos FindProductoByIdProducto(int idProducto) {
        for (Productos producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                return producto;
            }
        }
        throw new ElementNotFoundException();
    }

    public static ArrayList<Productos> GetProductosByPedidoId(int idPedido) {
        ArrayList<Productos> result = productos;
        if (idPedido != 0) {
            result = new ArrayList<Productos>();
            for (Productos producto : productos) {
                if (producto.IdProducto == idPedido) {
                    result.add(producto);
                }
            }

        }
        return result;
    }

    @PostMapping("/add/Productos")
    public Productos AddProducto(@RequestBody Productos newProducto) {
        productos.add(newProducto);
        return newProducto;
    }

    // @PutMapping("/Productos/{idProducto}")
    @PutMapping("/Productos/{idProducto}")
    public Productos updateProductos(@PathVariable("idProducto") int idProducto, @RequestBody Productos updateProducto)
            throws Exception {
        Productos m = FindProductoByIdProducto(idProducto);
        m.setPrecio(updateProducto.getPrecio());
        return m;
    }

    // @DeleteMapping("/Productos/{idProducto}")
    @DeleteMapping("/Productos/{idProducto}")
    public Productos DeleteProducto(@PathVariable("idProducto") int idProducto) {
        Productos producto = FindProductoByIdProducto(idProducto);
        productos.remove(idProducto);
        return producto;
    }

}
