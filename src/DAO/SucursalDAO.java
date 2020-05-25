package DAO;

import Control.Conexion;
import Entidad.Sucursal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO {

    public boolean registrar(Sucursal s) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO BRANCH values('" + s.getId_sucursal() + "','" + s.getNombre_s()
                + "','" + s.getDireccion() + "','" + s.getLugar_s() + "','" + s.getContrasenia_s() + "');";

        System.out.println(sql);
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

    public List<Sucursal> obtener() {

        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM BRANCH ORDER BY ID_BRANCH";

        List<Sucursal> listaSucursal = new ArrayList<Sucursal>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {

                Sucursal s = new Sucursal();
                s.setId_sucursal(rs.getInt(1));
                s.setNombre_s(rs.getString(2));
                s.setDireccion(rs.getString(3));
                s.setLugar_s(rs.getString(4));
                s.setContrasenia_s(rs.getString(5));
                listaSucursal.add(s);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error en metodo obtener");
            e.printStackTrace();
        }

        return listaSucursal;
    }

    public boolean validarExistencia(Sucursal s) {
        List<Sucursal> sucursales = obtener();
        boolean validacion = false;
        //System.out.println("identifiacion:" + u.getIdentificacion());
        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println(sucursales.get(i).getId_sucursal());
            if (sucursales.get(i).getId_sucursal() == s.getId_sucursal()) {
                validacion = true;

            }
        }
        return validacion;
    }

    public boolean actualizar(Sucursal s) {
        Connection co = null;
        Statement stm = null;
        boolean actualizar = false;
        String sql = "UPDATE BRANCH SET ID_BRANCH='" + s.getId_sucursal() + "',NAME_B='"
                + s.getNombre_s() + "',ADDRESS='" + s.getDireccion() + "',PLACE='"
                + s.getLugar_s() + "',PASSWORD_B='" + s.getContrasenia_s() + "'"
                + "WHERE ID_BRANCH=" + s.getId_sucursal();
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

    public boolean eliminar(Sucursal s) {
        Connection co = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM BRANCH WHERE ID_BRACH=" + s.getId_sucursal();
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
