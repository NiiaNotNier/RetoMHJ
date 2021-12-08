package com.example;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PedidosViewController {

    @GetMapping("/pedidos")
    public ModelAndView GetAllPedidos(
            @RequestParam(name = "idPedidos", required = false, defaultValue = "0") int idPedidos) {
        ArrayList<Pedidos> p = PedidosController.getPedidosByIdPedido(idPedidos);
        ModelAndView mv = new ModelAndView("listProducts");
        mv.addObject("pedidos", p);
        mv.addObject("productos", ProductosController.productos);
        mv.addObject("idPedidos", idPedidos);
        return mv;
    }

    @GetMapping("/pedidos/new")
    public ModelAndView CreateUser() {
        // igual hay que cambiar el details
        ModelAndView m = new ModelAndView("detailsProducts");
        m.addObject("pedidos", new Pedidos());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/edit/{id}")
    public ModelAndView CreateUser(@PathVariable("idPedidos") int idPedidos) {
        ModelAndView m = new ModelAndView("detailsProducts");
        m.addObject("pedidos", PedidosController.FindPedidosById(idPedidos));
        m.addObject("productos", ProductosController.productos);
        return m;
    }
}
