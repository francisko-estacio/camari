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
public class clsReporte4 {
   
    //listado de todos los clienes con comoras mayores a mil
    //mostrar el numero,fecha,total,y el cliente factura y el nombre del ciente
    
   
     public static ArrayList<clsFactura> clienteFacturaMayorMil() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
"\"public\".cliente.nombre,\n" +
"\"public\".cliente.direccion,\n" +
"\"public\".factura.fecha,\n" +
"\"public\".factura.total,\n" +
"\"public\".factura.no\n" +
"FROM\n" +
"\"public\".cliente\n" +
"INNER JOIN \"public\".factura ON \"public\".factura.cliente_id = \"public\".cliente.\"id\"\n" +
"WHERE\n" +
"\"public\".factura.total > '1000'";
                         
            
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                factura.setNo(cres.getInt("id"));
                factura.setFecha(cres.getDate("fecha"));
                factura.setTotal(cres.getInt("total"));
                //dfactura.setGenero(cres.getString("genero"));
               // dfactura.setIdpropietario(crudPropietario.findbyId(cres.getInt("idpropietario")));
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
}