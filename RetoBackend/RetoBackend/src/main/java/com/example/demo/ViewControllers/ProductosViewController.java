package com.example.demo.ViewControllers;

import com.example.demo.Controllers.ProductosController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductosViewController {

    public ProductosViewController() {
    }

    // añadido de "movies" para ver si funcionaba (no lo hace)
    @GetMapping("/productos")
    public ModelAndView GetMovies() {
        ModelAndView m = new ModelAndView("listProducts");
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/productos/edit/{idProducto}")

    public ModelAndView CreatePedido(@PathVariable("idProducto") int idProducto) {
        ModelAndView m = new ModelAndView("listProducts");
        m.addObject("producto", ProductosController.FindProductoByIdProducto(idProducto));
        // falta pasarle la cantidad del imput.
        // m.addObject("cantidad");
        return m;
    }

}
