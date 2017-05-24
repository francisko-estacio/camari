/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.entidades;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class clsFactura {
    private int _no;
    private clsCliente _cliente_id;
    private Date fecha;
    private double _subtotal;
     private double _iva;
      private double _total;

    public clsFactura() {
    }

    public clsFactura(int _no, clsCliente _cliente_id, Date fecha, double _subtotal, double _iva, double _total) {
        this._no = _no;
        this._cliente_id = _cliente_id;
        this.fecha = fecha;
        this._subtotal = _subtotal;
        this._iva = _iva;
        this._total = _total;
    }

    public int getNo() {
        return _no;
    }

    public void setNo(int _no) {
        this._no = _no;
    }

    public clsCliente getCliente_id() {
        return _cliente_id;
    }

    public void setCliente_id(clsCliente _cliente_id) {
        this._cliente_id = _cliente_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    public double getIva() {
        return _iva;
    }

    public void setIva(double _iva) {
        this._iva = _iva;
    }

    public double getTotal() {
        return _total;
    }

    public void setTotal(double _total) {
        this._total = _total;
    }

    @Override
    public String toString() {
        return "clsFactura{" + "_no=" + _no + ", _cliente_id=" + _cliente_id + ", fecha=" + fecha + ", _subtotal=" + _subtotal + ", _iva=" + _iva + ", _total=" + _total + '}';
    }
    
   
}
