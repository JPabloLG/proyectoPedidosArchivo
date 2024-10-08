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

	public String obtenerRutaProperties(){
        Properties properties= new Properties();
		try {
			properties.load(new FileInputStream(new File("C:/td/rutas/properties.properties")));
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

    public void guardarPedido(Pedido pedido) throws IOException {
		rutaArchivoPedidos = obtenerRutaProperties();
		StringBuilder textoPedido = new StringBuilder();
		
		textoPedido.append(pedido.getCodigo()+",");
		textoPedido.append(pedido.getFechaPedido()+",");
		textoPedido.append(pedido.getTotal()+",");
		textoPedido.append(pedido.getIva() + ",");
		textoPedido.append(pedido.getProducto() + "\n");
		//textoPedido.append(pedido.getProductos()+"\n");

		ArchivoUtil.guardarArchivo(rutaArchivoPedidos,textoPedido.toString(),true);
	}

    public LinkedList<Pedido> cargarPedidos(LaBurguesa laBurguesa) throws IOException {

		rutaArchivoPedidos = obtenerRutaProperties();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoPedidos);

		for (String pedidoTexto : contenido) {
			String[] split = pedidoTexto.split(",");

			//(String codigo, String fechaPedido, double total, double iva)

			if (split.length >= 4) {
				Pedido pedido = new Pedido(split[0], split[1], Double.valueOf(split[2]), Double.valueOf(split[3]), split[4]);
				laBurguesa.getPedidos().add(pedido);
			} else {
				System.err.println("Línea con datos incompletos: " + pedidoTexto);
			}
		}
		return laBurguesa.getPedidos();
	} 
}
