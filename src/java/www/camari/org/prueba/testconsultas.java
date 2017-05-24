/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.prueba;

import java.util.ArrayList;
//import www.camari.org.Reportes.clsReporte2;
import www.camari.org.Reportes.clsReporte3;
import www.camari.org.Reportes.clsReporte4;
import www.camari.org.Reportes.clsReporte6;
import www.camari.org.entidades.clsFactura;

/**
 *
 * @author Usuario
 */
public class testconsultas {
  
    //psvm tab tab
public static void main(String[] args) {
    
    ArrayList<clsFactura> factura = new ArrayList<>();
    factura = clsReporte4.clienteFacturaMayorMil();
    System.out.print(factura.toString());

            
    }

//    consulta2
//    ArrayList<clsFactura> factura = new ArrayList<>();
//    factura = clsReporte2.numeroComprasCliente();
//    System.out.print(factura.toString());

            
    
//     consulta3
//    ArrayList<clsFactura> factura = new ArrayList<>();
//    factura = clsReporte3.NumeroComprasTotalCliente();
//    System.out.print(factura.toString());

//ArrayList<clsFactura> factura = new ArrayList<>();
//    factura = clsReporte6.promedioCompraCliente();
//    System.out.print(factura.toString());
}


