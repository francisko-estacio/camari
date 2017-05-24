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


/**
 *
 * @author Usuario
 */
public class CrudCliente {
     public boolean save(clsCliente cliente){
        boolean resultado = false;
        String sql = "INSERT INTO public.cliente(ruc, nombre, direccion) VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getRuc()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getDireccion()));
        
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
         public boolean delete(clsCliente cliente) {
        boolean res=false;
        String sql = "DELETE FROM public.cliente WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,cliente.getId_cliente()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public boolean update(clsCliente micliente) {
        boolean res = false;
        String sql = "UPDATE public.cliente " +
                "SET ruc=?, nombre=?, direccion=? " +
                "WHERE id_cliente=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,micliente.getId_cliente()));
        lstPar.add(new Parametro(2,micliente.getRuc()));
        lstPar.add(new Parametro(3,micliente.getNombre()));
        lstPar.add(new Parametro(4,micliente.getDireccion()));
        
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public ArrayList<clsCliente> findbyAll() {
        ArrayList<clsCliente> listado = new ArrayList<>();
        String sql = "SELECT id_cliente, ruc, nombre, direccion "+
                "FROM public.cliente";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsCliente cliente = null;
            while (cres.next())
            {
                cliente = new clsCliente();
                cliente.setId_cliente(cres.getInt("id_cliente"));
                   cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setDireccion(cres.getString("direccion"));
                listado.add((cliente));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsCliente findbyId(clsCliente cli) {
        clsCliente cliente = null;
        String sql = "SELECT id_cliente, ruc, nombre, direccion "+
                "FROM public.cliente WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cli.getId_cliente()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsCliente();
                cliente.setId_cliente(cres.getInt("id_cliente"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setDireccion(cres.getString("direccion"));
               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
     public static clsCliente findbyId(int id) {
        clsCliente cliente = null;
        String sql = "SELECT id_cliente, ruc, nombre, direccion "+
                "FROM public.clientes WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,id));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsCliente();
                cliente.setId_cliente(cres.getInt("id_cliente"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setDireccion(cres.getString("direccion"));
                     
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
}

