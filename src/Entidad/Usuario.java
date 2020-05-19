package Entidad;

public class Usuario{

    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasenia;
    private long identificacion;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
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


    public Usuario(String nombre, String apellido, int identificacion, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre
                + "apellido " + apellido
                + "identifiacion " + identificacion
                + "contrasenia" + contrasenia;
    }

}
