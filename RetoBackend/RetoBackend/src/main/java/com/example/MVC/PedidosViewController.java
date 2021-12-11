package com.example.MVC;


import com.example.Controllers.PedidosController;
import com.example.Controllers.ProductosController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PedidosViewController {

    @GetMapping("/")
    public ModelAndView Home(){
        ModelAndView m = new ModelAndView("listProducts");
        m.addObject("newPedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/{idPedido}")
    public ModelAndView GetAllPedidos(
        @RequestParam(name = "idPedidos", required = false, defaultValue = "0") int idPedidos) {
        ModelAndView mv = new ModelAndView("listProducts");
        mv.addObject("pedidos", PedidosController.getPedidosByIdPedido(idPedidos));
        mv.addObject("productos", ProductosController.productos);
        if(PedidosController.pedidos.size() == 0){
            PedidosController.addPedido();
        }
        return mv;
    }

    @GetMapping("/pedidos/new")
    public ModelAndView CreatePedido() {
        // igual hay que cambiar el details
        ModelAndView m = new ModelAndView("detailsProducts");
        m.addObject("newPedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/{idPedido}/add/{idProducto}")
    public static ModelAndView addProductoToPedido(@PathVariable("idPedido") int idPedido, 
                                            @PathVariable("idProducto") int idProducto){
        ModelAndView m = new ModelAndView("detailsProducts");
        PedidosController.addProductoToPedidos(idPedido, idProducto);
        m.addObject("newPedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/edit/{idPedidos}")
    public ModelAndView CreateUser(@PathVariable("idPedidos") int idPedidos) {
        ModelAndView m = new ModelAndView("detailsProducts");
        m.addObject("pedidos", PedidosController.FindPedidosById(idPedidos));
        m.addObject("productos", ProductosController.productos);
        return m;
    }
}
