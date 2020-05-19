package DAO;

import Control.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entidad.Usuario;

public class UsuarioDAO {

    public boolean registrar(Usuario usuario) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO USER values ('" + usuario.getIdentificacion() + "','"
                + usuario.getUsuario() + "','" + usuario.getNombre() + "','"
                + usuario.getApellido() + "','" + usuario.getContrasenia() + "')";

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

    public List<Usuario> obtener() {

        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM USER ORDER BY ID_USER";

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {

                Usuario u = new Usuario();
                u.setIdentificacion(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setApellido(rs.getString(4));
                u.setContrasenia(rs.getString(5));
                listaUsuarios.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error en metodo obtener");
            e.printStackTrace();
        }

        return listaUsuarios;
    }

    public boolean validarExistencia(Usuario u) {
        List<Usuario> usuarios = obtener();
        boolean validacion = false;
        //System.out.println("identifiacion:" + u.getIdentificacion());
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).getIdentificacion());
            if (usuarios.get(i).getUsuario().equals(u.getUsuario())) {
                validacion = true;
                
            }
        }
        return validacion;
    }

    public boolean actualizar(Usuario u) {
        Connection co = null;
        Statement stm = null;
        boolean actualizar = false;
        String sql = "UPDATE USER SET ID_USER='" + u.getIdentificacion() + "',USERNAME_U='"
                + u.getUsuario() + "',NAME_U='" + u.getNombre() + "',LAST_NAME_U='"
                + u.getApellido() + "',PASSWORD_U='" + u.getContrasenia() + "'"
                + "WHERE ID_USER=" + u.getIdentificacion();
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

    public boolean eliminar(Usuario u) {
        Connection co = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM USER WHERE ID_USER=" + u.getIdentificacion();
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
