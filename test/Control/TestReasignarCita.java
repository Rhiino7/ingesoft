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
public class TestReasignarCita {

    private static ValidarReasignarCita reasignar = new ValidarReasignarCita();

    
    private int PENDIENTE = 0;
    private int APROBADA = 1;
    private int RECHAZADA = 3;
    private int CUMPLIDA = 4;
    private int NO_CUMPLIDA = 5;
    private int REASIGNADA = 6;
    
    private static Cita cita1;
    private static Cita cita2;
    private static Cita cita4;
    private static Cita cita5;
    private static Cita cita6;
    private static Cita cita7;

    public TestReasignarCita() {
    }

    @BeforeClass
    public static void setUpClass() {
        ArrayList<Usuario> usuarios;
        usuarios = new ArrayList<>();

        Usuario a = new Usuario("Juan", "Cardona", 1010038260, "juan", "1234");

        usuarios.add(a);
        sistema.setUsuarios(usuarios);

        for (Usuario u : sistema.getUsuarios()) {
            System.out.println(u.getUsuario());
            System.out.println(u.getContrasenia());
            System.out.println("--------------");

        }
        
        Usuario u = new Usuario();
        u.setNombre("naruto");
        u.setIdentificacion(147852369);
        Sucursal sucursal1 = new Sucursal(1, "Sucursal1", "Cra 29 # 14 - 47 sur", "La fragua", "123456");
        Sucursal sucursal2 = new Sucursal(2, "Sucursal2", "Cra 30 # 41 - 14", "Restrepo", "123457");
        cita1 = new Cita(-1, sucursal1, a, LocalDate.of(2020, Month.JULY, 25), LocalTime.of(9, 0), 0);
        cita2 = new Cita(-2, sucursal2, u, LocalDate.of(2020, Month.JULY, 26), LocalTime.of(10, 0), 1);
        cita4 = new Cita(-4, sucursal2, u, LocalDate.of(2020, Month.JULY, 28), LocalTime.of(12, 0), 3);
        cita5 = new Cita(-5, sucursal1, u, LocalDate.of(2020, Month.JULY, 29), LocalTime.of(13, 0), 4);
        cita6 = new Cita(-6, sucursal2, a, LocalDate.of(2020, Month.JULY, 30), LocalTime.of(14, 0), 5);
        cita7 = new Cita(-7, sucursal1, u, LocalDate.of(2020, Month.JULY, 30), LocalTime.of(15, 0), 6);
        
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
    public void validarCitaReasignadaPendiente(){
        assertEquals(reasignar.verificarCitaReasignadaPendiente(cita7), REASIGNADA);
        assertEquals(reasignar.verificarCitaReasignadaPendiente(cita1), PENDIENTE);
    }
        
    @Test
    public void validarCitaReasignadaAprobada(){
        assertEquals(reasignar.verificarCitaReasignadaAprobada(cita7), REASIGNADA);
        assertEquals(reasignar.verificarCitaReasignadaAprobada(cita2), APROBADA);
    }
            
    @Test
    public void validarCitaReasignadaRechazada(){
        assertEquals(reasignar.verificarCitaReasignadaRechazada(cita7), REASIGNADA);
        assertEquals(reasignar.verificarCitaReasignadaRechazada(cita4), RECHAZADA);
    }
    
    @Test
    public void validarCitaReasignadaCumplida(){
        assertEquals(reasignar.verificarCitaReasignadaCumplida(cita7), REASIGNADA);
        assertEquals(reasignar.verificarCitaReasignadaCumplida(cita5), CUMPLIDA);
    }
    
    @Test
    public void validarCitaReasignadaNoCumplida(){
        assertEquals(reasignar.verificarCitaReasignadaNoCumplida(cita7), REASIGNADA);
        assertEquals(reasignar.verificarCitaReasignadaNoCumplida(cita6), NO_CUMPLIDA);
    }
}
