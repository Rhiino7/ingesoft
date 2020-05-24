/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author cdgn2
 */
public class Admin {

    private String usuario;
    private String contrasenia;
    private long identificacion;

    public Admin() {
    }
    
    public Admin(String usuario, String contrasenia, long identificacion) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.identificacion = identificacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }
    
    
    
}
