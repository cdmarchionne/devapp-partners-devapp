package ar.edu.unq.partnersdevapp.test.skills;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Experiencia;

/**
 * Test de Experiencia Terminado
 */
public class ExperienciaTest extends TestCase {
    private static final String EXPERIENCIA_BORRADOR = "Borrador";

    private static final String EXPERIENCIA_NOMBRE_NUEVO = "ExperienciaNuevo";

    private static final String BASICO = "Basico";

    private static final String MEDIO = "Medio";

    private static final String SEMIEXPERTO = "Semi-Experto";

    private static final String EXPERTO = "Experto";

    @Override
    protected void setUp() throws Exception {
        Experiencia.addExperiencia(0, BASICO);
        Experiencia.addExperiencia(1, MEDIO);
        Experiencia.addExperiencia(2, EXPERTO);
    }

    @Override
    protected void tearDown() throws Exception {
        Experiencia.removeExperiencia(BASICO);
        Experiencia.removeExperiencia(MEDIO);
        Experiencia.removeExperiencia(EXPERTO);
    }

    public void testAgregarExperiencia() {
        assertEquals("", BASICO, Experiencia.nombreExperiencia(0));
        assertEquals("", MEDIO, Experiencia.nombreExperiencia(1));
        assertEquals("", EXPERTO, Experiencia.nombreExperiencia(2));
    }

    public void testAgregarExperienciaPonderada() {
        Experiencia.addExperiencia(2, SEMIEXPERTO);

        assertEquals("", SEMIEXPERTO, Experiencia.nombreExperiencia(2));
        assertEquals("", EXPERTO, Experiencia.nombreExperiencia(3));

    }

    public void testAgregarExperienciaDuplicada() {
        Experiencia.addExperiencia(3, BASICO);

        assertTrue("", Experiencia.existeExperiencia(BASICO));
        assertNotSame("", Experiencia.indiceExperiencia(BASICO), 3);
    }

    public void testBorrarExperiencia() {
        Experiencia.addExperiencia(EXPERIENCIA_BORRADOR);
        assertTrue("", Experiencia.existeExperiencia(EXPERIENCIA_BORRADOR));

        Experiencia.removeExperiencia(EXPERIENCIA_BORRADOR);
        assertFalse("", Experiencia.existeExperiencia(EXPERIENCIA_BORRADOR));
    }

    public void testCambiarNombreDeExperiencia() {
        Experiencia.addExperiencia(EXPERIENCIA_BORRADOR);
        Experiencia.renameExperiencia(EXPERIENCIA_BORRADOR, EXPERIENCIA_NOMBRE_NUEVO);

        assertFalse("", Experiencia.existeExperiencia(EXPERIENCIA_BORRADOR));
        assertTrue("", Experiencia.existeExperiencia(EXPERIENCIA_NOMBRE_NUEVO));
    }

    public void testSubirExperiencia() {
        Experiencia experienciaDePrueba = new Experiencia(BASICO);

        assertEquals("", BASICO, experienciaDePrueba.getExperienciaActual());

        experienciaDePrueba.subirExperiencia();
        assertEquals("", MEDIO, experienciaDePrueba.getExperienciaActual());

        experienciaDePrueba.subirExperiencia();
        assertEquals("", EXPERTO, experienciaDePrueba.getExperienciaActual());

    }

    public void testSubirExperienciaTope() {
        Experiencia experienciaDePrueba = new Experiencia(Experiencia.maxima());

        experienciaDePrueba.subirExperiencia();
        assertEquals("", Experiencia.maxima(), experienciaDePrueba.getExperienciaActual());

    }

    public void testBajarExperiencia() {
        Experiencia experienciaDePrueba = new Experiencia(EXPERTO);

        assertEquals("", EXPERTO, experienciaDePrueba.getExperienciaActual());

        experienciaDePrueba.bajarExperiencia();
        assertEquals("", MEDIO, experienciaDePrueba.getExperienciaActual());

        experienciaDePrueba.bajarExperiencia();
        assertEquals("", BASICO, experienciaDePrueba.getExperienciaActual());

    }

    public void testBajarExperienciaTope() {
        Experiencia experienciaDePrueba = new Experiencia(Experiencia.minima());

        experienciaDePrueba.bajarExperiencia();
        assertEquals("", Experiencia.minima(), experienciaDePrueba.getExperienciaActual());

    }
}
