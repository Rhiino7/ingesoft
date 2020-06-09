/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Control.Conexion;
import Entidad.Cita;
import Entidad.Sucursal;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import DAO.CitaDAO.*;

/**
 *
 * @author cdgn2
 */
public class ComplimentDAO {
    public boolean registrar(Cita c){

        ComplimentDAO complimentDAO = new ComplimentDAO();
        ArrayList<Cita> complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        int a = complimentList.size()+1;
        String sql = "INSERT INTO COMPLIMENT values('" + a + "','" + c.getId_cita() + "','" + c.getSucursal().getId_sucursal() + "','" + c.getUsuario().getIdentificacion()
                + "','" + c.getFecha().toString() + "','" + c.getHora().toString() + "','" + c.getMotivo() + "','" + c.getEstado() + "');";

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

    public List<Cita> obtener() {

        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        //String sql = "SELECT * FROM CITA ORDER BY ID_CITA"; No tiene ID XD
        //Ahora si tiene ID :)
        String sql = "SELECT * FROM COMPLIMENT ORDER BY ID_APPOINTMENT";

        List<Cita> listaCita = new ArrayList<>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            List<Sucursal> sucursales = new SucursalDAO().obtener();
            List<Usuario> usuarios = new UsuarioDAO().obtener();

            while (rs.next()) {

                Cita c = new Cita();

                c.setId_cita(rs.getInt(2));

                int sID = rs.getInt(3);
                for (Sucursal s : sucursales){
                    if (s.getId_sucursal() == sID) c.setSucursal(s);
                }

                int uID = rs.getInt(4);
                for (Usuario u : usuarios){
                    if (u.getIdentificacion() == uID) c.setUsuario(u);
                }

                c.setFecha(LocalDate.parse(rs.getString(5)));

                String[] hora = rs.getString(6).split(":");
                c.setHora(LocalTime.of(Integer.parseInt(hora[0]), Integer.parseInt(hora[1])));
                c.setMotivo(rs.getInt(7));
                c.setEstado(rs.getInt(8));
                listaCita.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error en metodo obtener");
            e.printStackTrace();
        }

        return listaCita;
    }

    public boolean actualizar(Cita c) {
        Connection co = null;
        Statement stm = null;
        boolean actualizar = false;
        String sql = "UPDATE COMPLIMENT SET ID_APPOINTMENT='"+ c.getId_cita() + "',ID_BRANCH='" + c.getSucursal().getId_sucursal() + "',ID_USER='"
                + c.getUsuario().getIdentificacion() + "',DATE='" + c.getFecha().toString() + "',TIME='"
                + c.getHora().toString() + "',STATE='" + c.getEstado() + "'"
                + "WHERE ID_BRANCH=" + c.getSucursal().getId_sucursal() + " AND ID_USER=" + c.getUsuario().getIdentificacion()  + " AND DATE='" + c.getFecha() + "' AND TIME='" + c.getHora() + "'";
        try {System.out.println(sql);
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
    
//No tiene un identificador para poder borrarlo :v
    
//    public boolean eliminar(Cita c) {
//        Connection co = null;
//        Statement stm = null;
//        boolean eliminar = false;
//        String sql = "DELETE FROM APPOINTMENT WHERE ID_BRANCH=" + c.getSucursal().getId_sucursal() + " AND ID_USER=" + c.getUsuario().getIdentificacion();
//        try {
//            co = Conexion.conectar();
//            stm = co.createStatement();
//            stm.execute(sql);
//            eliminar = true;
//        } catch (SQLException e) {
//            System.out.println("Error metodo eliminar");
//            e.printStackTrace();
//        }
//        return eliminar;
//    }
    
    public boolean actualizarEstado (Cita c, String e){
        CitaDAO cit = new CitaDAO();
        switch(e) {
            case "PENDIENTE":
                c.setEstado(0);
                this.actualizar(c);
                cit.deComplimentACita(c);
                this.eliminar(c);
                break;
            case "APROBADA":
                c.setEstado(1);
                this.actualizar(c);
                cit.deComplimentACita(c);
                this.eliminar(c);
                break;
            case "CANCELADA":
                c.setEstado(2);
                this.actualizar(c);
                cit.registrar(c);
                this.eliminar(c);
                break;
            case "RECHAZADA":
                c.setEstado(3);
                this.actualizar(c);
                cit.registrar(c);
                this.eliminar(c);
                break;
            case "CUMPLIDA":
                c.setEstado(4);
                this.actualizar(c);
                break;
            default:
                System.out.println("Estado invalido");
                return false;
        }
        return true;
    }
    
    public boolean eliminar(Cita c) {
        Connection co = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM COMPLIMENT WHERE ID_COMPLIMENT=" + c.getId_cita();
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
