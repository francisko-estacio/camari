/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.prueba;

import www.camari.org.entidades.clsCliente;
import www.camari.org.funciones.CrudCliente;

/**
 *
 * @author Usuario
 */
public class testCliente {
    //psvm tab tab 
    //psvm tab tab
public static void main(String[] args) {
            clsCliente c = new clsCliente(4, "16005229", "pedro", "mexico");
        //clsCliente d;
        CrudCliente cc = new CrudCliente();
            
        System.out.println(c.toString());
        
        if (cc.save(c)) {
            System.out.println("Guardado");
        }else{
            System.out.println("error!!!!");
        }
            
            
            System.out.println(c.toString());
            
//            clsFactura f = new clsFactura(,  , , , ,c);
//            System.out.println(f.toString);
            
    }

}
    
