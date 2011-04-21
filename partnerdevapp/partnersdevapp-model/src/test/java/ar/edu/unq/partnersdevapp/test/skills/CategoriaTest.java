package ar.edu.unq.partnersdevapp.test.skills;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Categoria;

/**
 * Test de Categoria Terminado
 */
public class CategoriaTest extends TestCase {
    private static final String CATEGORIA_BORRADOR = "CategoriaBorrador";

    private static final String CATEGORIA_NOMBRE_NUEVO = "CategoriaNombreNuevo";

    private static final String BASICO = "Basico";

    private static final String MEDIO = "Medio";

    private static final String SEMIEXPERTO = "Semi-Experto";

    private static final String EXPERTO = "Experto";

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
        String message = "Agrego categoria ";

        assertEquals(message + BASICO, BASICO, Categoria.nombreCategoria(0));
        assertEquals(message + MEDIO, MEDIO, Categoria.nombreCategoria(1));
        assertEquals(message + EXPERTO, EXPERTO, Categoria.nombreCategoria(2));
    }

    public void testAgregarCategoriaPonderada() {
        Categoria.addCategoria(2, SEMIEXPERTO);
        String message;

        message = "Agrego categoria intermedia";
        assertEquals(message, SEMIEXPERTO, Categoria.nombreCategoria(2));
        message = "La categoria " + EXPERTO + " cambio de Nivel";
        assertEquals(message, EXPERTO, Categoria.nombreCategoria(3));

    }

    public void testAgregarCategoriaDuplicada() {
        String message;

        message = "La categoria " + BASICO + " ya existe";
        assertTrue(message, Categoria.existeCategoria(BASICO));

        Categoria.addCategoria(3, BASICO);
        message = "La categoria " + BASICO + " no se agrego pq ya existe";
        assertNotSame(message, Categoria.indiceCategoria(BASICO), 3);
    }

    public void testBorrarCategoria() {
        String message;

        message = "Agrego una categoria cualquiera";
        Categoria.addCategoria(CATEGORIA_BORRADOR);
        assertTrue(message, Categoria.existeCategoria(CATEGORIA_BORRADOR));

        message = "Borro esa categoria";
        Categoria.removeCategoria(CATEGORIA_BORRADOR);
        assertFalse(message, Categoria.existeCategoria(CATEGORIA_BORRADOR));
    }

    public void testCambiarNombreDeCategoria() {
        String message = "Agrego una categoria cualquiera y le cambio el nombre";

        Categoria.addCategoria(CATEGORIA_BORRADOR);
        Categoria.renameCategoria(CATEGORIA_BORRADOR, CATEGORIA_NOMBRE_NUEVO);

        assertFalse(message, Categoria.existeCategoria(CATEGORIA_BORRADOR));
        assertTrue(message, Categoria.existeCategoria(CATEGORIA_NOMBRE_NUEVO));
    }

    public void testSubirCategoria() {
        Categoria categoriaDePrueba = new Categoria(BASICO);
        String message;

        message = "Creo una categoria " + BASICO;
        assertEquals(message, BASICO, categoriaDePrueba.getCategoriaActual());

        message = "Subo la categoria a " + MEDIO;
        categoriaDePrueba.subirCategoria();
        assertEquals(message, MEDIO, categoriaDePrueba.getCategoriaActual());

        message = "Subo la categoria a " + EXPERTO;
        categoriaDePrueba.subirCategoria();
        assertEquals(message, EXPERTO, categoriaDePrueba.getCategoriaActual());

    }

    public void testSubirCategoriaTope() {
        Categoria categoriaDePrueba = new Categoria(Categoria.maxima());
        String message = "Las categorias tienen un tope Maximo y no suben mas";

        categoriaDePrueba.subirCategoria();
        assertEquals(message, Categoria.maxima(), categoriaDePrueba.getCategoriaActual());

    }

    public void testBajarCategoria() {
        Categoria categoriaDePrueba = new Categoria(EXPERTO);
        String message;

        message = "Creo una categoria " + EXPERTO;
        assertEquals(message, EXPERTO, categoriaDePrueba.getCategoriaActual());

        message = "Bajo la categoria a " + MEDIO;
        categoriaDePrueba.bajarCategoria();
        assertEquals(message, MEDIO, categoriaDePrueba.getCategoriaActual());

        message = "Bajo la categoria a " + BASICO;
        categoriaDePrueba.bajarCategoria();
        assertEquals(message, BASICO, categoriaDePrueba.getCategoriaActual());

    }

    public void testBajarCategoriaTope() {
        Categoria categoriaDePrueba = new Categoria(Categoria.minima());
        String message = "Las categorias tienen un tope minimi y no bajan mas";

        categoriaDePrueba.bajarCategoria();
        assertEquals(message, Categoria.minima(), categoriaDePrueba.getCategoriaActual());

    }
}
