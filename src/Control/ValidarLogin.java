
package Control;

import DAO.UsuarioDAO;
import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.PrincipalFrame;

public class ValidarLogin {

    private UsuarioDAO dao = new UsuarioDAO();

    public ValidarLogin() {
    }

    public int verificarLogin(Usuario usuario) {
        if (!verificarLongitudNombre(usuario.getUsuario())) {
            return 0;
        }
        if (!verificarLongitudPassword(usuario.getContrasenia())) {
            return 1;
        }
        /*
        for (Usuario u: sistema.getUsuarios()){
            if (u.getUsuario().equals(usuario.getUsuario()) && u.getContrasenia().equals(usuario.getContrasenia())){
                if (u.isAdmin()){
                return 4;
                }else{
                    return 3;
                }
            }
        }
         */
        if (dao.validarExistencia(usuario) == true) {
            return 3;
        }
        return 2;
    }

    public boolean verificarLongitudNombre(String nombre) {
        return (nombre.length() >= 3 && nombre.length() < 12);
    }

    public Boolean verificarLongitudPassword(String password) {
        return (password.length() >= 4 && password.length() < 14);
    }

}
