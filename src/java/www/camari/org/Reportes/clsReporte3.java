/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.Reportes;

import java.util.ArrayList;
import www.camari.org.accesodatos.AccesoDatos;
import www.camari.org.accesodatos.ConjuntoResultado;
import www.camari.org.accesodatos.Parametro;
import www.camari.org.entidades.clsFactura;

/**
 *
 * @author Usuario
 */
public class clsReporte3 {
    public static ArrayList<clsFactura> NumeroComprasTotalCliente() {
 ArrayList<clsFactura> listado = new ArrayList<>();
 String sql = "SELECT "
 + "Count(\"public\".factura.\"numerofac\") AS NUMERO_COMPRAS "
 + "sum(\"public\".factura.total) AS total"
 + "FROM "
 + "\"public\".factura";

 ArrayList<Parametro> lstPar = new ArrayList<>();
 try {
 ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
 clsFactura factura = null;
 while (cres.next()) {
 factura = new clsFactura();

 factura.setNo(cres.getInt("no"));
 factura.setTotal(cres.getInt("total"));

 listado.add((factura));
 }
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listado;
 }
    
}
