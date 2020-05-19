package Control;

import DAO.UsuarioDAO;
import DAO.SucursalDAO;
import Entidad.Sucursal;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Inicializacion {

    public Inicializacion() {
    }

    @Test
    public void initData() {

        UsuarioDAO dao = new UsuarioDAO();
        SucursalDAO sdao = new SucursalDAO();
        ArrayList<Usuario> usuarios;
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        usuarios = new ArrayList<>();

        Usuario a = new Usuario("Juan", "Cardona", 1010038260, "juan", "1234");
        Usuario b = new Usuario("Pedro", "Nieto", 1010038259, "pedro", "1234567");
        Usuario c = new Usuario("Maria del Mar", "Rojas", 1010038258, "maria", "12345");
        Usuario d = new Usuario("Carlos", "Galvis", 1010038257, "CarlosKC26", "Carlosdgn2000");
        Sucursal b1 = new Sucursal(1, "Bancolombia", "cll 145 n50-58", "Exito Suba", "123");
        Sucursal b2 = new Sucursal(2, "Bancolombia", "cll 152 n103f-1", "calle", "123");
        Sucursal b3 = new Sucursal(3, "Bancolombia", "cll 145 n91-50", "Centro Suba", "123");
        Sucursal b4 = new Sucursal(4, "Bancolombia", "transversal 99 nm 70a-89", "DiverPlaza", "123");
        Sucursal b5 = new Sucursal(5, "Bancolombia", "kr 127 n66-59", "Bulevar", "123");

        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        usuarios.add(d);
        sucursales.add(b1);
        sucursales.add(b2);
        sucursales.add(b3);
        sucursales.add(b4);
        sucursales.add(b5);

        //sistema.setUsuarios(usuarios);
        /*
        for (Usuario u : usuarios) {
            System.out.println(u.getUsuario());
            System.out.println(u.getContrasenia());
            System.out.println("--------------");
            dao.registrar(u);
        }
         */
 
        for (Sucursal s : sucursales) {
            System.out.println(s.getId_sucursal());
            System.out.println(s.getNombre_s() + s.getLugar_s());
            System.out.println("--------------");
            sdao.registrar(s);
        }
         
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
