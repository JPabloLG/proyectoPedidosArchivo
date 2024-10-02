package co.edu.uniquindio.Model;

public class Producto {
    public String codigo;
    public TipoProducto tipoProducto;
    public double precio;

    public Producto(String codigo, TipoProducto tipoProducto, double precio) {
        this.codigo = codigo;
        this.tipoProducto = tipoProducto;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
