package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * TODO: description
 */
public class Skills {

    private Map<Tecnologia, Categoria> skill;

    public Skills() {
        super();
        skill = new HashMap<Tecnologia, Categoria>();
    }

    public void addSkill(final String tecnologia, final String categoria) {
        if (this.buscarTecnologia(tecnologia) == null) {
            this.setSkill(new Tecnologia(tecnologia), new Categoria(categoria));
        }
    }

    private void setSkill(final Tecnologia tecnologia, final Categoria categoria) {
        skill.put(tecnologia, categoria);
    }

    private Tecnologia buscarTecnologia(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = null;

        Tecnologia tecnologiaIterador;
        Iterator<Tecnologia> iterador = skill.keySet().iterator();
        while (iterador.hasNext()) {
            tecnologiaIterador = iterador.next();
            if (nombreTecnologiaBuscada.equals(tecnologiaIterador.getTecnologiaActual())) {
                tecnologiaBuscada = tecnologiaIterador;
                break;
            }
        }
        return tecnologiaBuscada;
    }

    private Tecnologia buscarTecnologia(final Tecnologia tecnologiaBuscada) {
        return this.buscarTecnologia(tecnologiaBuscada.getTecnologiaActual());
    }

    public void bajarCategoria(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);

        if (tecnologiaBuscada != null) {
            this.getCategoria(tecnologiaBuscada).bajarCategoria();
        }
    }

    public void subirCategoria(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);

        if (tecnologiaBuscada != null) {
            this.getCategoria(tecnologiaBuscada).subirCategoria();
        }
    }

    public String getCategoriaNombre(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);
        // String categoriaBuscada = null;
        //
        // if (tecnologiaBuscada != null) {
        // categoriaBuscada =
        // this.getCategoria(tecnologiaBuscada).getCategoriaActual();
        // }
        //
        // return categoriaBuscada;
        return tecnologiaBuscada != null ? this.getCategoria(tecnologiaBuscada).getCategoriaActual() : null;
    }

    public String getCategoriaNombre(final Tecnologia tecnologiaBuscada) {
        return this.getCategoriaNombre(tecnologiaBuscada.getTecnologiaActual());
    }

    public boolean satisfaceRequisito(final Skills condiciones) {
        boolean sabe = true;
        Tecnologia tecnologiaParticular;

        Tecnologia tecnologiaIterador;
        Iterator<Tecnologia> iterador = condiciones.getSkill().keySet().iterator();
        while (iterador.hasNext()) {
            tecnologiaIterador = iterador.next();
            tecnologiaParticular = this.buscarTecnologia(tecnologiaIterador);
            if (!this.dominaTecnologia(tecnologiaParticular, condiciones.getCategoriaNombre(tecnologiaIterador))) {
                sabe = false;
                break;
            }
        }
        return sabe;
    }

    private boolean dominaTecnologia(final Tecnologia tecnologia, final String categoriaMinima) {
        return tecnologia != null && this.getCategoria(tecnologia).cumbreNecesidades(categoriaMinima);
    }

    private Categoria getCategoria(final Tecnologia tecnologia) {
        return skill.get(tecnologia);
    }

    private Map<Tecnologia, Categoria> getSkill() {
        return skill;
    }

}
