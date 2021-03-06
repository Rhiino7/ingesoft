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
import DAO.ComplimentDAO.*;

public class CitaDAO {

    public boolean deComplimentACita (Cita c){
        CitaDAO citaDAO = new CitaDAO();
        ComplimentDAO complimentDAO = new ComplimentDAO();
        
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO APPOINTMENT values('"+ c.getId_cita() +"','" + c.getSucursal().getId_sucursal() + "','" + c.getUsuario().getIdentificacion()
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
    
    public boolean registrar(Cita c){
        
        CitaDAO citaDAO = new CitaDAO();
        ComplimentDAO complimentDAO = new ComplimentDAO();
        ArrayList<Cita> citasList = (ArrayList<Cita>) citaDAO.obtener();
        ArrayList<Cita> complimentList = (ArrayList<Cita>) complimentDAO.obtener();
        
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        int a = citasList.size() + complimentList.size()+1;
        
        String sql = "INSERT INTO APPOINTMENT values('"+ a +"','" + c.getSucursal().getId_sucursal() + "','" + c.getUsuario().getIdentificacion()
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
        String sql = "SELECT * FROM APPOINTMENT ORDER BY ID_APPOINTMENT";

        List<Cita> listaCita = new ArrayList<>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            List<Sucursal> sucursales = new SucursalDAO().obtener();
            List<Usuario> usuarios = new UsuarioDAO().obtener();

            while (rs.next()) {

                Cita c = new Cita();

                c.setId_cita(rs.getInt(1));

                int sID = rs.getInt(2);
                for (Sucursal s : sucursales){
                    if (s.getId_sucursal() == sID) c.setSucursal(s);
                }

                int uID = rs.getInt(3);
                for (Usuario u : usuarios){
                    if (u.getIdentificacion() == uID) c.setUsuario(u);
                }

                c.setFecha(LocalDate.parse(rs.getString(4)));

                String[] hora = rs.getString(5).split(":");
                c.setHora(LocalTime.of(Integer.parseInt(hora[0]), Integer.parseInt(hora[1])));
                c.setMotivo(rs.getInt(6));
                c.setEstado(rs.getInt(7));
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
        String sql = "UPDATE APPOINTMENT SET ID_BRANCH='" + c.getSucursal().getId_sucursal() + "',ID_USER='"
                + c.getUsuario().getIdentificacion() + "',DATE='" + c.getFecha().toString() + "',TIME='"
                + c.getHora().toString() + "',STATE='" + c.getEstado() + "'"
                + "WHERE ID_BRANCH=" + c.getSucursal().getId_sucursal() + " AND ID_USER=" + c.getUsuario().getIdentificacion();//  + " AND DATE='" + c.getFecha() + "' AND TIME='" + c.getHora() + "'";
        System.out.println(sql);
        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            stm.execute(sql);
            System.out.println("La base de datos se actualizo.");
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
    
    public boolean verificarDisponibilidad(Cita cita){
        List<Cita> citas = this.obtener();
        for (Cita c : citas){
            if (c.getSucursal().getId_sucursal() == cita.getSucursal().getId_sucursal() 
                    && c.getFecha().toString().equals(cita.getFecha().toString()) 
                    && c.getHora().toString().equals(cita.getHora().toString())){
                return false;
            }
        }
        return true;
    }
    
    public boolean verificarTengaMasCitasSucursal (Cita cita){
        List<Cita> citas = this.obtener();
        for (Cita c : citas){
            if (c.getSucursal().getId_sucursal() == cita.getSucursal().getId_sucursal() 
                    && c.getUsuario().getIdentificacion() == cita.getUsuario().getIdentificacion()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizarEstado (Cita c, String e){
        ComplimentDAO com = new ComplimentDAO();
        switch(e) {
            case "PENDIENTE":
                c.setEstado(0);
                this.actualizar(c);
                break;
            case "APROBADA":
                c.setEstado(1);
                this.actualizar(c);
                break;
            case "CANCELADA":
                c.setEstado(2);
                com.registrar(c);
                this.eliminar(c);
                break;
            case "RECHAZADA":
                c.setEstado(3);
                com.registrar(c);
                this.eliminar(c);
                break;
            case "CUMPLIDA":
                c.setEstado(4);
                com.registrar(c);
                this.eliminar(c);
                break;
            case "NO CUMPLIDA":
                c.setEstado(5);
                com.registrar(c);
                this.eliminar(c);
                break;
            case "REASIGNADA":
                c.setEstado(6);
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
        String sql = "DELETE FROM APPOINTMENT WHERE ID_APPOINTMENT=" + c.getId_cita();
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

