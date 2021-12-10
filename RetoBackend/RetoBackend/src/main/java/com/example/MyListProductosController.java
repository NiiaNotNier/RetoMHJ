package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyListProductosController {

    public static ArrayList<Productos> productosMyList = new ArrayList(Arrays.asList());

    @GetMapping("/myList")
    public ArrayList<Productos> getAll() {
        return productosMyList;
    }

    @PostMapping("/myList/add/{idProducto}")
    public Productos add(@PathVariable("idProducto") int idProducto) {
        // compartimos nuestro listado para coger la info de ese metodo
        Productos p = ProductosController.FindProductoByIdProducto(idProducto);
        productosMyList.add(p);
        return p;
    }

    @DeleteMapping("/myList/{idProducto}")
    public Productos DeleteProductoFromList(@PathVariable("idProducto") int idProducto) {
        productosMyList.remove(idProducto);
        return null;
    }

    public static Productos DeleteProductoFromList(@RequestBody Productos deleProducto,
            @RequestParam(name = "idProducto", required = true) int idProducto) {
        Productos p = FindProductoByIdProducto(idProducto);
        productosMyList.remove(p);
        return p;
    }

    public static Productos FindProductoByIdProducto(int idProducto) {
        for (Productos p : productosMyList) {
            if (p.getIdProducto() == idProducto) {
                return p;
            }
        }
        throw new ElementNotFoundException();
    }
}
