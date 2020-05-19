/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.*;

public class Conexion {

    public static Connection conectar() {
        String url = "C:\\Users\\josteda99\\Documents\\NetBeansProjects\\ingesoft-master\\BD\\BankApp.db";//cada uno pone la ruta de la base de datos
        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("no se pudo encontrar la base de datos" + ex.getMessage());
        }
        return connect;
    }
/*
    public void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("no se pudo encontrar la base de datos" + ex.getMessage());
        }
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrar() {
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from USER");
            result = st.executeQuery();
            while (result.next()) {
                System.out.println("ID_USER: ");
                System.out.println(result.getInt("ID_USER"));
                System.out.println("USERNAME: ");
                System.out.println(result.getString("USERNAME_U"));
                System.out.println("___________");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.connect();
        con.mostrar();
        con.close();
    }
*/
}
