
package Control;

import DAO.AdminDAO;
import DAO.UsuarioDAO;
import Entidad.Admin;
import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.PrincipalFrame;

public class ValidarLogin {

    private UsuarioDAO dao = new UsuarioDAO();
    private AdminDAO adao = new AdminDAO();

    public ValidarLogin() {
    }

    public int verificarLogin(Usuario usuario, Admin admin) {
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
    
    public int verificarLogin(Usuario usuario) {
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
    
    public int verificarLogin(Admin admin) {
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

    public boolean verificarLongitudPassword(String password) {
        return (password.length() >= 4 && password.length() < 14);
    }
    
}
