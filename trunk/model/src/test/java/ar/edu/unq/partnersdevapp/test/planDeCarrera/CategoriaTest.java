package ar.edu.unq.partnersdevapp.test.planDeCarrera;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Categoria;

/**
 * Test de Categoria Terminado
 */
public class CategoriaTest extends TestCase {
    private static final String CATEGORIA_BORRADOR = "CategoriaBorrador";

    private static final String CATEGORIA_NOMBRE_NUEVO = "CategoriaNombreNuevo";

    private static final String SEMIEXPERTO = "Semi-Experto";

    private static final String EXPERTO = "Experto";

    private static final String MEDIO = "Medio";

    private static final String BASICO = "Basico";

    @Override
    protected void setUp() throws Exception {
        Categoria.addCategoria(0, BASICO);
        Categoria.addCategoria(1, MEDIO);
        Categoria.addCategoria(2, EXPERTO);
    }

    @Override
    protected void tearDown() throws Exception {
        Categoria.removeCategoria(BASICO);
        Categoria.removeCategoria(MEDIO);
        Categoria.removeCategoria(EXPERTO);
    }

    public void testAgregarCategoria() {
        assertEquals(BASICO, Categoria.nombreCategoria(0));
        assertEquals(MEDIO, Categoria.nombreCategoria(1));
        assertEquals(EXPERTO, Categoria.nombreCategoria(2));
    }

    public void testAgregarCategoriaPonderada() {
        Categoria.addCategoria(2, SEMIEXPERTO);

        assertEquals(SEMIEXPERTO, Categoria.nombreCategoria(2));
        assertEquals(EXPERTO, Categoria.nombreCategoria(3));

    }

    public void testAgregarCategoriaDuplicada() {
        Categoria.addCategoria(3, BASICO);

        assertTrue(Categoria.existeCategoria(BASICO));
        assertFalse(Categoria.indiceCategoria(BASICO) == 3);
    }

    public void testBorrarCategoria() {
        Categoria.addCategoria(CATEGORIA_BORRADOR);
        assertTrue(Categoria.existeCategoria(CATEGORIA_BORRADOR));

        Categoria.removeCategoria(CATEGORIA_BORRADOR);
        assertFalse(Categoria.existeCategoria(CATEGORIA_BORRADOR));
    }

    public void testCambiarNombreDeCategoria() {
        Categoria.addCategoria(CATEGORIA_BORRADOR);
        Categoria.renameCategoria(CATEGORIA_BORRADOR, CATEGORIA_NOMBRE_NUEVO);

        assertFalse(Categoria.existeCategoria(CATEGORIA_BORRADOR));
        assertTrue(Categoria.existeCategoria(CATEGORIA_NOMBRE_NUEVO));
    }

    public void testSubirCategoria() {
        Categoria categoriaDePrueba = new Categoria(BASICO);

        assertEquals(BASICO, categoriaDePrueba.getCategoriaActual());

        categoriaDePrueba.subirCategoria();
        assertEquals(MEDIO, categoriaDePrueba.getCategoriaActual());

        categoriaDePrueba.subirCategoria();
        assertEquals(EXPERTO, categoriaDePrueba.getCategoriaActual());

    }

    public void testSubirCategoriaTope() {
        Categoria categoriaDePrueba = new Categoria(Categoria.maxima());

        categoriaDePrueba.subirCategoria();
        assertEquals(Categoria.maxima(), categoriaDePrueba.getCategoriaActual());

    }

    public void testBajarCategoria() {
        Categoria categoriaDePrueba = new Categoria(EXPERTO);

        assertEquals(EXPERTO, categoriaDePrueba.getCategoriaActual());

        categoriaDePrueba.bajarCategoria();
        assertEquals(MEDIO, categoriaDePrueba.getCategoriaActual());

        categoriaDePrueba.bajarCategoria();
        assertEquals(BASICO, categoriaDePrueba.getCategoriaActual());

    }

    public void testBajarCategoriaTope() {
        Categoria categoriaDePrueba = new Categoria(Categoria.minima());

        categoriaDePrueba.bajarCategoria();
        assertEquals(Categoria.minima(), categoriaDePrueba.getCategoriaActual());

    }
}
