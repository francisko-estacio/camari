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
import www.camari.org.funciones.CrudCliente;

/**
 *
 * @author Usuario
 */
public class clsrReporte2 {

     public static ArrayList<clsFactura> numeroComprasCliente() {
 ArrayList<clsFactura> listado = new ArrayList<>();
 String sql = "SELECT "
 + "\"public\".cliente.nombre, "
 + "Count(\"public\".factura.\"no\") AS \"Numero de compras\" "
 + "FROM "
 + "\"public\".cliente, INNER JOIN"
 + "\"public\".factura"
 + "ON"
 + "\"public\".factura.cliente_id = \"public\".cliente.\"id\""
 + "GROUP BY"
 + "\"public\".cliente.nombre";

 ArrayList<Parametro> lstPar = new ArrayList<>();
 try {
 ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
 clsFactura factura = null;
 while (cres.next()) {
 factura = new clsFactura();

 factura.setNo(cres.getInt("no"));
 factura.setCliente_id(CrudCliente.findbyId(cres.getInt("Id")));
 listado.add((factura));
 }
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
 return listado;
 }
    
}

    

