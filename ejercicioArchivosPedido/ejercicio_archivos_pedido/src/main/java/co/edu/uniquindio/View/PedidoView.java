package co.edu.uniquindio.View;

import co.edu.uniquindio.Controller.PedidoController;

public class PedidoView {
    

    public void agregarProducto(){
        PedidoController pedidoController = new PedidoController();
        pedidoController.addProductos(null);
    }
}
