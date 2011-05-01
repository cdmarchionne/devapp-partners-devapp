package ar.edu.unq.partnersdevapp.test.empleado;

import java.util.Date;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;
import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * Test de Empleado
 */
public class EmpleadoTest extends TestCase {
    private static final String POSICION = "senior";

    private static final String MENSAJE = "Test Empleado";

    private static final Date FECHA_01_04_2011 = FechaUtils.crearFecha("01/04/2011");

    private static PlanDeCarrera plan;

    private static Empleado empleado;

    @Override
    protected void setUp() throws Exception {
        plan = BaseDeDatosHelper.getPlanDeCarreraStandartTester();
        empleado = new Empleado("Nombre", "Apellido", "12345678");
    }

    public void testGetPlanActual() throws NoHayResultadoException {
        try {
            empleado.getPlanActual();
        } catch (Exception e) {
            assertEquals(MENSAJE, e.getClass(), NoHayResultadoException.class);
        }

        empleado.addPlanDeCarrera(FECHA_01_04_2011, plan, new Posicion(POSICION, 66));
        assertTrue(MENSAJE, new Posicion(POSICION, 66).isIgual(empleado.getPosicionActual()));
    }

    public void testSubirPosicion() throws NoHayResultadoException {
        empleado.addPlanDeCarrera(FECHA_01_04_2011, plan, new Posicion(POSICION, 66));
        assertTrue(MENSAJE, new Posicion(POSICION, 66).isIgual(empleado.getPosicionActual()));

        empleado.subirPosicion();
        assertTrue(MENSAJE, new Posicion(POSICION, 100).isIgual(empleado.getPosicionActual()));

        empleado.subirPosicion();
        assertTrue(MENSAJE, new Posicion("lider", 00).isIgual(empleado.getPosicionActual()));

    }

    /**
     * Si se modifica un plan de carrera , el empleado debera tener la posicion
     * mas cercana
     */
    // public void testIntegridadDatosDePlan() {
    // TODO: agregar los metodos para modificar bandas. Cada vez que se hace
    // una operacion de estas hay que modificar todas las posiciones
    // afectadas.
    // }

    public void testSueldo() throws NoHayResultadoException {
        empleado.addPlanDeCarrera(FECHA_01_04_2011, plan, new Posicion(POSICION, 66));
        assertEquals(MENSAJE, empleado.getSueldo(), 4990.0f);

    }

}
