package co.edu.uniquindio.Model;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private String codigo;
    private String fechaPedido;
    private double total;
    private double iva;
    public ArrayList<Producto> productos = new ArrayList<>();

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

    public ArrayList<Producto> getProductos() {
      return productos;
    }

    public static double calcularTotal(String producto, int cantidad){
        double total = 0;
        if(producto == "sencilla" || producto == "Sencilla" || producto == "SENCILLA"){
            total = 8000 * cantidad;
        }
        else if(producto == "gigante" || producto == "Gigante" || producto == "GIGANTE"){
            total = 17000 * cantidad;
        }
        else if(producto == "extraqueso" || producto == "Extraqueso" || producto == "EXTRAQUESO"){
            total = 15000 * cantidad;
        }
        return total;
    }
}