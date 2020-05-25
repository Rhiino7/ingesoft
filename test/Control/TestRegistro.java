/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Admin;
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
public class TestRegistro {

    private static ValidarRegistro validarRegistro = new ValidarRegistro();

    private int LONG_NOMBRE_INCORRECTA = 0;
    private int LONG_PASSWORD_INCORRECTA = 1;
    private int DATOS_INCORRECTOS = 2;
    private int USUARIO_AUTORIZADO = 3;
    private int ADMINISTRADOR_AUTORIZADO = 4;
    private boolean REGISTRO_COMPLETO = true;
    private boolean USUARIO_Y_PASSWORD = true;
    private boolean NOMBRE_NO_EXISTE = true;
    private boolean APELLIDO_NO_EXISTE = true;
    private boolean IDENTIFICACION_NO_EXISTE = true;
    private boolean PASSWORD_NO_EXISTE = true;
    private boolean IDENTIFICACION_NUMERICA = true;
    private boolean NOMBRE_NUMERICO = true;
    private boolean APELLIDO_NUMERICO = true;

    public TestRegistro() {
    }

    @BeforeClass
    public static void setUpClass() {
        ArrayList<Usuario> usuarios;
        usuarios = new ArrayList<>();

        Usuario a = new Usuario("Nombre1", "Apellido1", 1013678200, "usuario1", "1234");
        Usuario b = new Usuario("Nombre2", "Apellido2", 1013678201, "usuario2", "1234");
        Usuario c = new Usuario("Nombre3", "Apellido3", 1013678202, "usuario3", "1234");
        Usuario d = new Usuario("Nombre4", "Apellido4", 1013678203, "usuario4", "1234");
        Usuario e = new Usuario("naruto", "uzumaki", 1013678203, "naruto", "123456");

        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        usuarios.add(d);
        usuarios.add(e);

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
        u.setUsuario("Lo");
        u.setContrasenia("123456");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_NOMBRE_INCORRECTA);

        u.setUsuario("CesarAugusto");
        u.setContrasenia("123456");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_NOMBRE_INCORRECTA);
    }

    @Test
    public void testLongitudContrasenia() {
        Usuario u = new Usuario();
        u.setUsuario("Cesar");
        u.setContrasenia("123");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_PASSWORD_INCORRECTA);

        u.setUsuario("Cesar");
        u.setContrasenia("12345678901234");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_PASSWORD_INCORRECTA);
    }

    @Test
    public void testNombre() {
        Usuario u = new Usuario();
        u.setUsuario("Cesar");
        u.setContrasenia("12345");
        assertEquals(validarRegistro.verificarRegistro(u), DATOS_INCORRECTOS);
    }

    @Test
    public void testContrasenia() {
        Usuario u = new Usuario();
        u.setUsuario("maria");
        u.setContrasenia("1234");
        assertEquals(validarRegistro.verificarRegistro(u), DATOS_INCORRECTOS);
    }

    @Test
    public void testDatos() {
        Usuario u = new Usuario();
        u.setUsuario("Cesar");
        u.setContrasenia("B2A4");
        assertEquals(validarRegistro.verificarRegistro(u), DATOS_INCORRECTOS);
    }

    @Test
    public void testUsuarioCorrecto() {
        Usuario u = new Usuario();
        u.setNombre("Cesar");
        u.setApellido("Solano");
        u.setIdentificacion(1013678232);
        u.setUsuario("csolano");
        u.setContrasenia("12345");
        assertEquals(validarRegistro.registroCompleto(u), !REGISTRO_COMPLETO);
    }

    @Test
    public void testAdmin() {
        Admin a = new Admin();
        a.setUsuario("admin");
        a.setContrasenia("12345");
        assertEquals(validarRegistro.verificarRegistro(a), ADMINISTRADOR_AUTORIZADO);
    }
    
    @Test
    public void testUsuarioYPassword(){
        Usuario u = new Usuario();
        u.setUsuario("naruto");
        u.setContrasenia("123456");
        assertEquals(validarRegistro.verificarUsuarioYPassword(u.getUsuario(), u.getContrasenia()), USUARIO_Y_PASSWORD);
    }
    
    @Test
    public void testExistenciaNombre() {
        Usuario u = new Usuario();
        u.setNombre("");
        assertEquals(validarRegistro.existe(u.getNombre()), !NOMBRE_NO_EXISTE);
    }
    
    @Test
    public void testExistenciaApellido() {
        Usuario u = new Usuario();
        u.setApellido("");
        assertEquals(validarRegistro.existe(u.getApellido()), !APELLIDO_NO_EXISTE);
    }
    
    @Test
    public void testExistenciaIdentificacion() {
        assertEquals(validarRegistro.existe(Integer.toString(1234)), IDENTIFICACION_NO_EXISTE);
    }
    
    @Test
    public void testExistenciaPassword() {
        Usuario u = new Usuario();
        u.setContrasenia("12345");
        assertEquals(validarRegistro.existe(u.getContrasenia()), PASSWORD_NO_EXISTE);
    }
    
    @Test
    public void testIdentificacionNumerica() {
        assertEquals(validarRegistro.identificacionNumerica("123"), IDENTIFICACION_NUMERICA);
    }
    
    @Test
    public void testIdentificacionNumericaFalla() {
        assertEquals(validarRegistro.identificacionNumerica("hola"), !IDENTIFICACION_NUMERICA);
    }
    
    @Test
    public void testNombreNumerico() {
        Usuario u = new Usuario();
        u.setNombre("12345");
        assertEquals(validarRegistro.nombreNumerico(u.getNombre()), NOMBRE_NUMERICO);
    }
    
    @Test
    public void testApellidoNumerico() {
        Usuario u = new Usuario();
        u.setApellido("12345");
        assertEquals(validarRegistro.apellidoNumerico(u.getApellido()), APELLIDO_NUMERICO);
    }
}
