package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.Model.Pedido;
import co.edu.uniquindio.Model.LaBurguesa;
import co.edu.uniquindio.Model.Producto;
import co.edu.uniquindio.Model.TipoProducto;
import co.edu.uniquindio.Persistencia.Persistencia;
import co.edu.uniquindio.View.PedidoView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PedidoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregar_btn;

    @FXML
    private TextField codigo_txt;

    @FXML
    private TextField fecha_txt;

    @FXML
    private Button generar_pedido_btn;

    @FXML
    private Button mostrar_pedido_btn;

    @FXML
    private TextField producto_txt;

    @FXML
    private Label lista_pedidos_txt;

    @FXML
    private TextField cantidad_txt;

    @FXML
    private Text txt_iva;

    @FXML
    private Text txt_total;

    LaBurguesa  laBurguesa = new LaBurguesa();

    @FXML
    void agregar_producto_btn(ActionEvent event) {
        txt_total.setText("");
        txt_iva.setText("");
        String codigo = codigo_txt.getText();
        String producto = producto_txt.getText();
        
        if(producto == "sencilla" || producto == "Sencilla" || producto == "SENCILLA"){
            addProductos(new Producto(codigo, TipoProducto.SENCILLA, 8000));
        }
        else if(producto == "gigante" || producto == "Gigante" || producto == "GIGANTE"){
            addProductos(new Producto(codigo, TipoProducto.GIGANTE, 17000));
        }
        else if(producto == "extraqueso" || producto == "Extraqueso" || producto == "EXTRAQUESO"){
            addProductos(new Producto(codigo, TipoProducto.EXTRAQUESO, 15000));
        }

        codigo_txt.setText("");
        fecha_txt.setText("");
        producto_txt.setText("");
        cantidad_txt.setText("");
    }

    public void addProductos(Producto producto){
        Pedido pedido = new Pedido("", "", 0, 0);
        pedido.agregarProducto(producto);
    }

    @FXML
    void generar_pedido_btn(ActionEvent event) throws IOException {
        String codigo = codigo_txt.getText();
        String fecha = fecha_txt.getText();
        String cantidadtxt = cantidad_txt.getText();
        int cantidad = Integer.parseInt(cantidadtxt);
        String producto = producto_txt.getText();
        double total = Pedido.calcularTotal(producto, cantidad);
        double iva = total - (total - (total*0.19));
        String totalstr = String.valueOf(total);
        String ivastr = String.valueOf(iva);

        txt_total.setText("$" + totalstr);
        txt_iva.setText("$" + ivastr);

        Pedido pedido = new Pedido(codigo, fecha, total, iva); 

        Persistencia persistencia = new Persistencia();
        persistencia.guardarPedido(pedido);
        laBurguesa.getPedidos().add(pedido);

        codigo_txt.setText("");
        fecha_txt.setText("");
        producto_txt.setText("");
        cantidad_txt.setText("");
    }

    @FXML
    void mostrar_pedido_btn(ActionEvent event) {
        PedidoView pedidoView = new PedidoView();
        lista_pedidos_txt.setText(pedidoView.mostrarListaPedidos());
    }

    public LinkedList<Pedido> mostrarPedidos(){
        Persistencia persistencia = new Persistencia();
        try {
			persistencia.cargarPedidos(laBurguesa);
			
			return laBurguesa.getPedidos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @FXML
    void initialize() {
        assert agregar_btn != null : "fx:id=\"agregar_btn\" was not injected: check your FXML file 'PedidoView.fxml'.";
        assert codigo_txt != null : "fx:id=\"codigo_txt\" was not injected: check your FXML file 'PedidoView.fxml'.";
        assert fecha_txt != null : "fx:id=\"fecha_txt\" was not injected: check your FXML file 'PedidoView.fxml'.";
        assert generar_pedido_btn != null : "fx:id=\"generar_pedido_btn\" was not injected: check your FXML file 'PedidoView.fxml'.";
        assert producto_txt != null : "fx:id=\"producto_txt\" was not injected: check your FXML file 'PedidoView.fxml'.";
        assert cantidad_txt != null : "fx:id=\"producto_txt1\" was not injected: check your FXML file 'PedidoView.fxml'.";
        assert txt_iva != null : "fx:id=\"txt_iva\" was not injected: check your FXML file 'PedidoView.fxml'.";
        assert txt_total != null : "fx:id=\"txt_total\" was not injected: check your FXML file 'PedidoView.fxml'.";

    }
}
