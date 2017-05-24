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
import www.camari.org.entidades.clsCliente;
import www.camari.org.entidades.clsFactura;

/**
 *
 * @author Usuario
 */
public class CrudFactura {
    public class crudfactura {
    
//GUARDAR
     public boolean save(clsFactura factura){
        boolean resultado = false;
        String sql = "INSERT INTO public.factura(cliente_Id,fecha,subtotal,iva,total) VALUES(?,?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getCliente_id()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getSubtotal()));
         lstPar.add(new Parametro(4,factura.getIva()));
         lstPar.add(new Parametro(5,factura.getTotal()));
      
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
        return resultado;
    }
    
     ///ELIMINAR
         public boolean delete(clsFactura factura) {
        boolean res=false;
        String sql = "DELETE FROM public.factura WHERE no=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,factura.getNo()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        return res;
    }

//          //ACTUALIZAR
         public boolean update(clsFactura factura) {
        boolean res = false;
        String sql = "UPDATE public.factura" +
                "SET =?,cliente_id=?,fecha=?, subtotal=?, iva=?, total=?" + 
                "WHERE no=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,factura.getCliente_id().getId_cliente()));
        lstPar.add(new Parametro(2,factura.getFecha()));
        lstPar.add(new Parametro(3,factura.getSubtotal()));
        lstPar.add(new Parametro(6,factura.getIva()));
        lstPar.add(new Parametro(4,factura.getTotal()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
         ///BUSQUEDA POR TODOS//
          public ArrayList<clsFactura> findbyAll() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT no, cliente_id, fecha, subtotal, iva, total"+
                "FROM public.factura";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                factura.setNo(cres.getInt("no"));
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getInt("subtotal"));
                factura.setIva(cres.getInt("iva"));
                factura.setTotal(cres.getInt("total"));
               
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    }

   
    public static clsFactura findby(int id) {
        clsFactura fac = null;
        String sql = "SELECT no, cliente_id, fecha, subtotal, iva, total  FROM public.factura WHERE no=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                fac = new clsFactura();
                fac.setNo(cres.getInt("no"));
                fac.setFecha(cres.getDate("fecha"));
                fac.setSubtotal(cres.getInt("subtotal"));
                fac.setIva(cres.getInt("iva"));
                fac.setTotal(cres.getInt("total"));
                fac.setCliente_id(CrudCliente.findbyId(cres.getInt("cliente_id")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fac;
    }

    }
