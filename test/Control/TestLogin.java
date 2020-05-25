/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.PrincipalFrame.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cdgn2
 */
public class TestLogin {

    private static ValidarLogin validarLogin = new ValidarLogin();

    private int LONG_NOMBRE_INCORRECTA = 0;
    private int LONG_PASSWORD_INCORRECTA = 1;
    private int DATOS_INCORRECTOS = 2;
    private int USUARIO_AUTORIZADO = 3;
    private int ADMINISTRADOR_AUTORIZADO = 4;

    public TestLogin() {
    }

    @BeforeClass
    public static void setUpClass() {
        ArrayList<Usuario> usuarios;
        usuarios = new ArrayList<>();

        Usuario a = new Usuario("Juan", "Cardona", 1010038260, "juan", "1234");
        Usuario b = new Usuario("Pedro", "Nieto", 1010038259, "pedro", "1234567");
        Usuario c = new Usuario("Maria del Mar", "Rojas", 1010038258, "maria", "12345");
        Usuario d = new Usuario("Carlos", "Galvis", 1010038257, "CarlosKC26", "Carlosdgn2000");

        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        usuarios.add(d);

        sistema.setUsuarios(usuarios);

        for (Usuario u : sistema.getUsuarios()) {
            System.out.println(u.getUsuario());
            System.out.println(u.getContrasenia());
            System.out.println("--------------");

        }
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
    @Test
    public void testLongitudNombre() {
        Usuario u = new Usuario();
        u.setUsuario("Ro");
        u.setContrasenia("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);

        u.setUsuario("RobertoCamilo");
        u.setContrasenia("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
    }

    @Test
    public void testLongitudContrasenia() {
        Usuario u = new Usuario();
        u.setUsuario("Pepe");
        u.setContrasenia("123");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);

        u.setUsuario("Pepe");
        u.setContrasenia("12345678901234");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
    }

    @Test
    public void testNombre() {
        Usuario u = new Usuario();
        u.setUsuario("Henry");
        u.setContrasenia("12345");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);

    }

    @Test
    public void testContrasenia() {
        Usuario u = new Usuario();
        u.setUsuario("maria");
        u.setContrasenia("1234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);

    }

    @Test
    public void testDatos() {
        Usuario u = new Usuario();
        u.setUsuario("Henry");
        u.setContrasenia("A234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);

    }

    @Test
    public void testUsuarioCorrecto() {
        Usuario u = new Usuario();
        u.setUsuario("juan");
        u.setContrasenia("1234");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);

        u.setUsuario("pedro");
        u.setContrasenia("1234567");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);

        u.setUsuario("maria");
        u.setContrasenia("12345");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
    }

    @Test
    public void testAdmin() {
        Usuario u = new Usuario();
        u.setUsuario("CarlosKC26");
        u.setContrasenia("Carlosdgn2000");
        assertEquals(validarLogin.verificarLogin(u), ADMINISTRADOR_AUTORIZADO);
    }
}
