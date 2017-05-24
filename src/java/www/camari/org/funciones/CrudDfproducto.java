/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.camari.org.funciones;

import java.util.ArrayList;
import www.camari.org.accesodatos.AccesoDatos;
import www.camari.org.accesodatos.ConjuntoResultado;
import www.camari.org.accesodatos.Parametro;
import www.camari.org.entidades.clsDfproducto;

/**
 *
 * @author Usuario
 */
public class CrudDfproducto {
    
    //GUARDAR
     public boolean save(clsDfproducto dfactura){
        boolean resultado = false;
        String sql = "INSERT INTO public.dfproducto(noFactura,id_producto,cantidad,subtotal) VALUES(?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        //lstPar.add(new Parametro(1, dfactura.getNumerofac().getNumerofac()));
        lstPar.add(new Parametro(1, dfactura.getId_producto().getId_producto()));
        lstPar.add(new Parametro(2, dfactura.getCantidad()));
         lstPar.add(new Parametro(3, dfactura.getSubtotal()));
      
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
          
        }
        return resultado;
    }
    
     ///ELIMINAR
         public boolean delete(clsDfproducto dfactura) {
        boolean res=false;
        String sql = "DELETE FROM public.dfproducto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,dfactura.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        return res;
    }

//          //ACTUALIZAR
         public boolean update(clsDfproducto dfactura) {
        boolean res = false;
        String sql = "UPDATE public.dfproducto" +
                "SET noFctura=?,cantidad=?,subtotal=?, id_producto=?" + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,dfactura.getNo().getNo()));
        lstPar.add(new Parametro(2,dfactura.getId_producto().getId_producto()));
        lstPar.add(new Parametro(3,dfactura.getCantidad()));
        lstPar.add(new Parametro(6,dfactura.getSubtotal()));
        lstPar.add(new Parametro(4,dfactura.getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
         ///BUSQUEDA POR TODOS//
          public ArrayList<clsDfproducto> findbyAll() {
        ArrayList<clsDfproducto> listado = new ArrayList<>();
        String sql = "SELECT id=?, cantidad=?, subtotal=?"+
                "FROM public.dfProducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDfproducto dfactura = null;
            while (cres.next())
            {
                dfactura = new clsDfproducto();
                dfactura.setId(cres.getInt("id"));
                dfactura.setCantidad(cres.getInt("cantidad"));
                dfactura.setSubtotal(cres.getInt("subtotal"));
                
               // dfactura.setIdpropietario(crudPropietario.findbyId(cres.getInt("idpropietario")));
                listado.add((dfactura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
     
}
