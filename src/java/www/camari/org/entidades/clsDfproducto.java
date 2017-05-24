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
public class clsDfproducto {
    private int _id;
    private clsProducto _id_producto;
    private clsFactura _no;
    private int _cantidad ;
    private double _subtotal;

    public clsDfproducto() {
        
    }

    public clsDfproducto(int _id, clsProducto _id_producto, clsFactura _no, int _cantidad, double _subtotal) {
        this._id = _id;
        this._id_producto = _id_producto;
        this._no = _no;
        this._cantidad = _cantidad;
        this._subtotal = _subtotal;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public clsProducto getId_producto() {
        return _id_producto;
    }

    public void setId_producto(clsProducto _id_producto) {
        this._id_producto = _id_producto;
    }

    public clsFactura getNo() {
        return _no;
    }

    public void setNo(clsFactura _no) {
        this._no = _no;
    }

    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
        
    }

    @Override
    public String toString() {
        return "clsDfproducto{" + "_id=" + _id + ", _id_producto=" + _id_producto + ", _no=" + _no + ", _cantidad=" + _cantidad + ", _subtotal=" + _subtotal + '}';
    }
}
