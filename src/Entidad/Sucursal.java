package Entidad;


public class Sucursal {

    private int id_sucursal;
    private String nombre_s;
    private String direccion;
    private String lugar_s;
    private String contrasenia_s;

    public Sucursal() {
    }

    public Sucursal(int id_sucursal, String nombre_s, String direccion, String lugar_s, String contrasenia_s) {
        this.id_sucursal = id_sucursal;
        this.nombre_s = nombre_s;
        this.direccion = direccion;
        this.lugar_s = lugar_s;
        this.contrasenia_s = contrasenia_s;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public String getNombre_s() {
        return nombre_s;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLugar_s() {
        return lugar_s;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public void setNombre_s(String nombre_s) {
        this.nombre_s = nombre_s;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLugar_s(String lugar_s) {
        this.lugar_s = lugar_s;
    }

    public void setContrasenia_s(String contrasenia_s) {
        this.contrasenia_s = contrasenia_s;
    }

    public String getContrasenia_s() {
        return contrasenia_s;
    }
 
    
    
}
