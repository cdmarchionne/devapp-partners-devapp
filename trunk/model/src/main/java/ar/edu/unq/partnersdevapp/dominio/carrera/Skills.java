package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * TODO: description
 */
public class Skills {

    private Map<Tecnologia, Categoria> skill = new HashMap<Tecnologia, Categoria>();

    public void addSkill(final String tecnologia, final String categoria) {
        this.setSkill(new Tecnologia(tecnologia), new Categoria(categoria));
    }

    private void setSkill(final Tecnologia tecnologia, final Categoria categoria) {
        skill.put(tecnologia, categoria);
    }

    private Tecnologia buscarTecnologia(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = null;

        Iterator<Tecnologia> iterador = skill.keySet().iterator();
        while (iterador.hasNext()) {
            Tecnologia tecnologiaParticular = iterador.next();
            if (nombreTecnologiaBuscada.equals(tecnologiaParticular.getTecnologiaActual())) {
                tecnologiaBuscada = tecnologiaParticular;
                break;
            }
        }

        return tecnologiaBuscada;
    }

    public void bajarCategoria(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);

        if (tecnologiaBuscada != null) {
            skill.get(tecnologiaBuscada).bajarCategoria();
        }
    }

    public void subirCategoria(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);

        if (tecnologiaBuscada != null) {
            skill.get(tecnologiaBuscada).subirCategoria();
        }
    }

    public String getCategoria(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);
        String categoriaBuscada = null;

        if (tecnologiaBuscada != null) {
            categoriaBuscada = skill.get(tecnologiaBuscada).getCategoriaActual();
        }

        return categoriaBuscada;
    }

}