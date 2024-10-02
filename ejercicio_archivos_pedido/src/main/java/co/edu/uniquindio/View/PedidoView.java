package co.edu.uniquindio.View;

import java.util.LinkedList;

import co.edu.uniquindio.Controller.PedidoController;
import co.edu.uniquindio.Model.Pedido;

public class PedidoView {
    

    public void agregarProducto(){
        PedidoController pedidoController = new PedidoController();
        pedidoController.addProductos(null);
    }

    public String mostrarListaPedidos(){
        PedidoController pedidoController = new PedidoController();
        LinkedList<Pedido> listaPedidos = pedidoController.mostrarPedidos();

        String pedidos = "";
        for(Pedido pedido : listaPedidos){
            pedidos += " Código: "+ pedido.getCodigo() + " Fecha: " + pedido.getFechaPedido() + "\n";
        }

        return pedidos;
    }
}
