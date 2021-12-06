package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.Pedidos;
import com.example.demo.Models.ElementNotFoundException;
import com.example.demo.Models.Productos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

    public static ArrayList<Pedidos> pedidos = new ArrayList(Arrays.asList(
            new Pedidos(1, 20, "2021-12-31", "Antonio", "En curso"),
            new Pedidos(2, 5, "2021/12/24", "Manuel", "Cancelado"),
            new Pedidos(3, 14, "2021/12/22", "Isabel", "Aceptado"),
            new Pedidos(4, 8, "2021/12/24", "Marta", "Enviado")

    ));

    // Devuelve el listado de pedidos con todos sus campos. No es necesario que se
    // devuelva el número de productos de cada pedido.

    @GetMapping("Pedidos")
    public List<Pedidos> GetAllPedidos() {
        return pedidos;
    }

    @GetMapping("Pedidos/{idPedido}")
    public static Pedidos GetPedidosById(@PathVariable("idPedido") int idPedido) {
        return FindPedidosById(idPedido);
    }

    public static Pedidos FindPedidosById(int idPedido) {
        for (Pedidos pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        throw new ElementNotFoundException();
    }

}
