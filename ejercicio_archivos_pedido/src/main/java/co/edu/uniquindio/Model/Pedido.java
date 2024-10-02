package co.edu.uniquindio.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Pedido {
    private String codigo;
    private String fechaPedido;
    private double total;
    private double iva;
    public LinkedList<Producto> productos = new LinkedList();

    // Constructor
    

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public Pedido(String codigo, String fechaPedido, double total, double iva) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.iva = iva;
        this.productos = productos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public LinkedList<Producto> getProductos() {
      return productos;
    }

    public static double calcularTotal(String producto, double cantidad){
        double total = 0;
        if(producto.equals("sencilla") || producto.equals("Sencilla") || producto.equals("SENCILLA")){
            total += 8000 * cantidad;
        }
        else if(producto.equals("gigante") || producto.equals("Gigante") || producto.equals("GIGANTE")){
            total += 17000 * cantidad;
        }
        else if(producto.equals("extraqueso") || producto.equals("Extraqueso") || producto.equals("EXTRAQUESO")){
            total += 15000 * cantidad;
        }
        return total;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    @Override
    public String toString() {
        return "Pedido [codigo=" + codigo + ", fechaPedido=" + fechaPedido + ", total=" + total + ", productos="
                + productos + "]";
    }
}
