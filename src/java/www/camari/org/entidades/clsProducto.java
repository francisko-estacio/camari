/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.entidades;

/**
 *
 * @author Usuario
 */
public class clsProducto {
    private int id_producto;
     private String _nombre;
    private int _stock;
    private  double _precio_venta;

    public clsProducto() {
    }

    public clsProducto(int id_producto, String _nombre, int _stock, double _precio_venta) {
        this.id_producto = id_producto;
        this._nombre = _nombre;
        this._stock = _stock;
        this._precio_venta = _precio_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getStock() {
        return _stock;
    }

    public void setStock(int _stock) {
        this._stock = _stock;
    }

    public double getPrecio_venta() {
        return _precio_venta;
    }

    public void setPrecio_venta(double _precio_venta) {
        this._precio_venta = _precio_venta;
    }

    @Override
    public String toString() {
        return "clsProducto{" + "id_producto=" + id_producto + ", _nombre=" + _nombre + ", _stock=" + _stock + ", _precio_venta=" + _precio_venta + '}';
    }
    
    
}
