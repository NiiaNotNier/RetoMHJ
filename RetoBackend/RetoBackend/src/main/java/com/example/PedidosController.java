package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

    public static ArrayList<Pedidos> pedidos = new ArrayList(Arrays.asList(
            new Pedidos(1, 20, "2021/12/31", "Antonio", "En curso"),
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
    public static Pedidos GetPedidosById(@PathVariable("idPedido") int idPedido, HttpServletRequest request,
            HttpServletResponse response) {
        // Error con los HttpServletRequest y HttpServletResponse
        var p = FindPedidosById(idPedido);
        if (p == null) {
            response.setStatus(
                    HttpServletResponse.SC_NOT_FOUND);

        }
        return p;
    }

    public static Pedidos FindPedidosById(int idPedido) {
        for (Pedidos pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        throw new ElementNotFoundException();
    }

    @PostMapping("/v2/Pedidos")
    public Pedidos AddPedidos(@RequestBody Pedidos newPedido) {
        pedidos.add(new Pedidos(newPedido.getIdPedido(), newPedido.getCantProductos(),
                newPedido.getFechaCreacion(), newPedido.getEstado(), newPedido.getNombreUsuario()));
        return newPedido;
    }

    @PutMapping("/v2/Pedidos/{id}")
    public Pedidos UpdatePedidos(@RequestBody Pedidos updatePedidos,
            @PathVariable("idPedido") int idPedido) throws Exception {
        Pedidos p = FindPedidosById(idPedido);
        p.setCantProductos((updatePedidos.getCantProductos()));
        p.setIdPedido(updatePedidos.getIdPedido());
        return p;
    }

    @DeleteMapping("/v2/Pedidos/{id}")
    public void DeletePedidos(@PathVariable("idPedidos") int idPedidos) throws Exception {
        Pedidos p = FindPedidosById(idPedidos);
        pedidos.remove(p);
    }

    public static ArrayList<Pedidos> getPedidosByIdPedido(int idPedido) {
        ArrayList<Pedidos> p = pedidos;
        if (idPedido != 0) {
            p = new ArrayList<Pedidos>();
            for (Pedidos pedido : pedidos) {
                if (pedido.getIdPedido() == idPedido)
                    p.add(pedido);
            }
        }
        return p;
    }
}
