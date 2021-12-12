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
        ModelAndView m = new ModelAndView("home");
        m.addObject("pedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos")
    public ModelAndView VerPedidos(){
        ModelAndView m = new ModelAndView("verPedidos");
        m.addObject("pedido", PedidosController.getAllPedidos());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/{idPedido}")
    public ModelAndView GetAllPedidos(
        @RequestParam(name = "idPedido", required = false, defaultValue = "0") int idPedido) {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedido", PedidosController.getPedidosByIdPedido(idPedido));
        mv.addObject("productos", ProductosController.productos);
        if(PedidosController.pedidos.size() == 0){
            PedidosController.addPedido();
        }
        return mv;
    }

    @GetMapping("/pedidos/new")
    public ModelAndView CreatePedido() {
        ModelAndView m = new ModelAndView("home");
        m.addObject("pedido", PedidosController.addPedido());
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/{idPedido}/add/{idProducto}")
    public static ModelAndView addProductoToPedido(@PathVariable("idPedido") int idPedido, 
                                            @PathVariable("idProducto") int idProducto){
        ModelAndView m = new ModelAndView("home");
        PedidosController.addProductoToPedidos(idPedido, idProducto);
        m.addObject("pedido", PedidosController.GetPedidosById(idPedido));
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/{idPedido}/remove/{idProducto}")
    public static ModelAndView removeProductoFromPedido(@PathVariable("idPedido") int idPedido, 
                                            @PathVariable("idProducto") int idProducto){
        ModelAndView m = new ModelAndView("home");
        PedidosController.deleteProductoFromPedidos(idPedido, idProducto);
        m.addObject("pedido", PedidosController.GetPedidosById(idPedido));
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/{idPedido}/favoritos/add/{idProducto}")
    public static ModelAndView addProductoToFavoritos(@PathVariable("idPedido") int idPedido, 
                                            @PathVariable("idProducto") int idProducto){
        ModelAndView m = new ModelAndView("home");
        PedidosController.addProductoAFavoritos(idPedido, idProducto);
        m.addObject("pedido", PedidosController.GetPedidosById(idPedido));
        m.addObject("productos", ProductosController.productos);
        return m;
    }

    @GetMapping("/pedidos/{idPedido}/favoritos/remove/{idProducto}")
    public static ModelAndView removeProductoFromFavoritos(@PathVariable("idPedido") int idPedido, 
                                            @PathVariable("idProducto") int idProducto){
        ModelAndView m = new ModelAndView("home");
        PedidosController.deleteProductoFromFavoritos(idPedido, idProducto);
        m.addObject("pedido", PedidosController.GetPedidosById(idPedido));
        m.addObject("productos", ProductosController.productos);
        return m;
    }
}
