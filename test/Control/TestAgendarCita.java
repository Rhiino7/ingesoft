/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Cita;
import Entidad.Sucursal;
import Entidad.Usuario;
import static Frontera.PrincipalFrame.sistema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
public class TestAgendarCita {

    private static ValidarSolicitarCita validar = new ValidarSolicitarCita();

    private int FECHA_NULA = 1;
    private int HORA_NULA = 2;
    private int FECHA_NO_INGRESADA = 3;
    private int FECHA_ANTERIOR = 4;
    private int CITA_DISPONIBLE = 5;
    private static Cita cita;
    private static Sucursal sucursal;

    public TestAgendarCita() {
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
        
        Usuario u = new Usuario();
        u.setNombre("naruto");
        u.setIdentificacion(147852369);
        Sucursal sucursal = new Sucursal(1, "Sucursal", "Cra 29 # 14 - 47 sur", "La fragua", "123456");
        cita = new Cita(sucursal, u, LocalDate.of(2020, Month.MAY, 27), LocalTime.of(9, 0), 0);
        
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
    public void verificarFechaNula(){
        int prueba = 1;
        if(cita.getFecha().equals("")){
            prueba = 0;
        }
        assertEquals(prueba, FECHA_NULA);
    }
    
    @Test
    public void verificarHoraNula(){
        int prueba = 2;
        if(cita.getHora().equals("")){
            prueba = 0;
        }
        assertEquals(prueba, HORA_NULA);
    }
    
    @Test
    public void verificarFechaNoIngresada(){
        int prueba = 3;
        LocalDate testFecha = LocalDate.parse("3800-02-01");
        if(cita.getFecha().equals(testFecha)){
            prueba = 0;
        }
        assertEquals(prueba, FECHA_NO_INGRESADA);
    }
    
    @Test
    public void verificarFechaAnterior(){
        int prueba = 4;
        if(cita.getFecha().isBefore(LocalDate.now())){
            prueba = 0;
        }
        assertEquals(prueba, FECHA_ANTERIOR);
    }
    
    @Test
    public void verificarDisponibilidad(){
        int prueba = 5;
        assertEquals(validar.verificarSolicitarCita(cita), CITA_DISPONIBLE);
    }
}
