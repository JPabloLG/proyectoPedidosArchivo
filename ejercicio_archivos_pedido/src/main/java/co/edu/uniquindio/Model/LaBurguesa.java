package co.edu.uniquindio.Model;

import java.util.ArrayList;
import java.util.LinkedList;

public class LaBurguesa {
    private static LaBurguesa instanciaUnica;
    public String nombre = "La Burguesa";
    public LinkedList<Pedido> pedidos;


    public LaBurguesa() {
        this.pedidos = new LinkedList<>();
    }

    public static LaBurguesa getInstanciaUnica() {
        if(instanciaUnica == null){
            instanciaUnica = new LaBurguesa();
        }
        return instanciaUnica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }
}
