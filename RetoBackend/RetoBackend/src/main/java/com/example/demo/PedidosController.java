package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {
    
    public static ArrayList<Pedidos> listaPedidos = new ArrayList(Arrays.asList(

            new Pedidos(1, 20, "2021/12/24", "Antonio", "En curso"),
            new Pedidos(2, 5, "2021/12/24", "Manuel", "Cancelado"),
            new Pedidos(3, 14, "2021/12/24", "Isabel", "Aceptado"),
            new Pedidos(4, 8, "2021/12/24", "Marta", "Enviado")
            ));
    
    

    public String CheckEstado(String estado){
        if(listaPedidos....?){

        }
    }
}
