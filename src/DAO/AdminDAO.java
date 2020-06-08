/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Control.Conexion;
import Entidad.Admin;
import Entidad.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cdgn2
 */
public class AdminDAO {
    
     public boolean registrar(Admin admin) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO ADMIN values ('" + admin.getIdentificacion() + "','"
                + admin.getUsuario() + "','" + admin.getContrasenia() + "')";

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: metodo registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    public List<Admin> obtener() {

        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM ADMIN ORDER BY ID_ADMIN";

        List<Admin> listaAdmins = new ArrayList<Admin>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {

                Admin a = new Admin();
                a.setIdentificacion(rs.getInt(1));
                a.setUsuario(rs.getString(2));
                a.setContrasenia(rs.getString(3));
                listaAdmins.add(a);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error en metodo obtener");
            e.printStackTrace();
        }

        return listaAdmins;
    }

    public boolean validarExistencia(Admin a) {
        List<Admin> admins = obtener();
        boolean validacion = false;
        //System.out.println("identifiacion:" + a.getIdentificacion());
        for (int i = 0; i < admins.size(); i++) {
//            System.out.println(admins.get(i).getIdentificacion());
                System.out.println(admins.get(i).getUsuario());
                System.out.println(admins.get(i).getContrasenia());
            if (admins.get(i).getUsuario().equals(a.getUsuario()) && admins.get(i).getContrasenia().equals(a.getContrasenia())) {
                validacion = true;
            }
        }
        return validacion;
    }

    public boolean actualizar(Admin a) {
        Connection co = null;
        Statement stm = null;
        boolean actualizar = false;
        String sql = "UPDATE ADMIN SET ID_ADMIN='" + a.getIdentificacion() + "',USERNAME_A='"
                + a.getUsuario() + "',PASSWORD_A='" + a.getContrasenia() + "'"
                + "WHERE ID_ADMIN=" + a.getIdentificacion();
        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("error metodo actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminar(Admin u) {
        Connection co = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM ADMIN WHERE ID_ADMIN=" + u.getIdentificacion();
        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error metodo eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
}
