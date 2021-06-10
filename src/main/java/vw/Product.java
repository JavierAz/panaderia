package vw;

public class Product {
    int idProducto;
    private String producto;
    private  Double precio;
    private int cantidad;

    public Product(){

    }

    public Product(int idProducto, String producto, Double precio, int cantidad) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
