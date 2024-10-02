package co.edu.uniquindio.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import co.edu.uniquindio.Model.LaBurguesa;
import co.edu.uniquindio.Model.Pedido;

public class Persistencia {
    
    String rutaArchivoPedidos = "";

    public void guardarEmpleado(Pedido pedido) throws IOException {

		StringBuilder textoPedido = new StringBuilder();
		
		textoPedido.append(pedido.getCodigo()+",");
		textoPedido.append(pedido.getFechaPedido()+",");
		textoPedido.append(pedido.getTotal()+",");
		textoPedido.append(pedido.getIva()+"\n");
		//textoPedido.append(pedido.getProductos()+"\n");

		ArchivoUtil.guardarArchivo(rutaArchivoPedidos,textoPedido.toString(),true);
	}

    public String obtenerRutaProperties(){
        Properties properties= new Properties();
		try {
			properties.load(new FileInputStream(new File("C:/td/rutas/pedidos.txt")));
            return properties.get("rutaArchivoPedidos").toString();
		} 
        catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

    public LinkedList<Pedido> cargarPedidos(LaBurguesa laBurguesa) throws IOException {

		rutaArchivoPedidos = obtenerRutaProperties();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoPedidos);
		//int codigo, Date fechaPedido, double total, double iva, ArrayList<Producto> productos
		for (String pedidoTexto : contenido) {
			String[] split = pedidoTexto.split(",");
			
            Pedido pedido = new Pedido(split[0], split[1], Double.valueOf(split[2]), Double.valueOf(split[3]));
            laBurguesa.getPedidos().add(pedido);
		}
		return laBurguesa.getPedidos();
	}
    
}
