package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProductController {

    public static ArrayList<OrderProduct> order = new ArrayList(Arrays.asList(
            new OrderProduct(1, "Teclado", 3),
            new OrderProduct(2, "Proyector", 2)));

    @GetMapping("OrderProduct")
    public List<OrderProduct> GetAllOrderProduct() {
        return order;
    }

    @GetMapping("OrderProduct/{idPedido}")
    public static OrderProduct GetPedidosById(@PathVariable("idPedido") int idPedido) {
        return FindOrderProductById(idPedido);
    }

    public static OrderProduct FindOrderProductById(int idPedido) {
        for (OrderProduct op : order) {
            if (op.getIdPedido() == idPedido) {
                return op;
            }
        }
        throw new ElementNotFoundException();
    }

}
