
package Control;

import DAO.AdminDAO;
import DAO.UsuarioDAO;
import Entidad.Admin;
import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.PrincipalFrame;

public class ValidarRegistro {

    private UsuarioDAO dao = new UsuarioDAO();
    private AdminDAO adao = new AdminDAO();

    public ValidarRegistro() {
    }

    public int verificarRegistro(Usuario usuario, Admin admin) {
        if (!verificarLongitudNombre(usuario.getUsuario())) {
            return 0;
        }
        if (!verificarLongitudPassword(usuario.getContrasenia())) {
            return 1;
        }
        if (dao.validarExistencia(usuario) == true) {
            return 3;
        }
        if (adao.validarExistencia(admin) == true) {
            return 4;
        }
        return 2;
    }
    
    public int verificarRegistro(Usuario usuario) {
        if (!verificarLongitudNombre(usuario.getUsuario())) {
            return 0;
        }
        if (!verificarLongitudPassword(usuario.getContrasenia())) {
            return 1;
        }
        if (dao.validarExistencia(usuario) == true) {
            return 3;
        }
        return 2;
    }
    
    public int verificarRegistro(Admin admin) {
        if (!verificarLongitudNombre(admin.getUsuario())) {
            return 0;
        }
        if (!verificarLongitudPassword(admin.getContrasenia())) {
            return 1;
        }
        if (adao.validarExistencia(admin) == true) {
            return 4;
        }
        return 2;
    }

    public boolean verificarLongitudNombre(String nombre) {
        return (nombre.length() >= 3 && nombre.length() < 12);
    }

    public Boolean verificarLongitudPassword(String password) {
        return (password.length() >= 4 && password.length() < 14);
    }
    
    
    public boolean registroCompleto(String nombre, String apellido, String identificacion, String usuario, String password, String password2){
        boolean vN = existe(nombre);
        boolean vLN = verificarLongitudNombre(nombre);
        boolean vNaN = nombreNumerico(nombre);
        boolean vA = existe(apellido);
        boolean vLA = verificarLongitudApellido(apellido);
        boolean vAaN = apellidoNumerico(apellido);
        boolean vI = existe(identificacion);
        boolean vIaN = identificacionNumerica(identificacion);
        boolean vU = existe(password);
        boolean vLU = verificarLongitudNombre(usuario);
        boolean vP = verificarLongitudPassword(password);
        boolean vP2 = verificarLongitudPassword(password2);
        boolean vPI = verificarPasswordIguales(password, password2);
        
        return vN && vLN && vNaN && vA && vLA && vAaN && vI && vIaN && vU && vLU && vP && vP2 && vPI;
    }
    
    public boolean registroCompleto(Usuario u){
        boolean vN = existe(u.getNombre());
        boolean vLN = verificarLongitudNombre(u.getNombre());
        boolean vNaN = nombreNumerico(u.getNombre());
        boolean vA = existe(u.getApellido());
        boolean vLA = verificarLongitudApellido(u.getApellido());
        boolean vAaN = apellidoNumerico(u.getApellido());
        boolean vI = existe(Long.toString(u.getIdentificacion()));
        boolean vIaN = identificacionNumerica(Long.toString(u.getIdentificacion()));
        boolean vU = existe(u.getUsuario());
        boolean vLU = verificarLongitudNombre(u.getUsuario());
        boolean vP = verificarLongitudPassword(u.getContrasenia());
        boolean vP2 = verificarLongitudPassword(u.getContrasenia());
        boolean vPI = verificarPasswordIguales(u.getContrasenia(), u.getContrasenia());
        
        return vN && vLN && vNaN && vA && vLA && vAaN && vI && vIaN && vU && vLU && vP && vP2 && vPI;
    }
    
    
    public boolean verificarLongitudApellido(String apellido){
        return (apellido.length() >= 3 && apellido.length() < 12);
    }
    
    public boolean identificacionNumerica(String identificacion){
        try{
            Integer.parseInt(identificacion);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
    public boolean nombreNumerico(String nombre){
        try{
            for(char c:nombre.toCharArray()){
                Integer.parseInt(Character.toString(c));
            }
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
    public boolean apellidoNumerico(String apellido){
        try{
            for(char c:apellido.toCharArray()){
                Integer.parseInt(Character.toString(c));
            }
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
    public boolean verificarUsuarioYPassword(String usuario, String password){
        return verificarLongitudNombre(usuario) && verificarLongitudPassword(password);
    }
    
    public boolean existe(String palabra){
        return !palabra.isEmpty();
    }
    
    public boolean verificarPasswordIguales(String password, String password2){
        return password.equals(password2);
    }
}
