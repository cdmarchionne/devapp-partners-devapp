package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Los Skills son un conjunto de caracteristicas. Mantienen la relacion de los
 * conocimientos sobre una Tecnologia con un determinado Nivel de experiencia
 */
public class Skills extends Entidad {

    private static final long serialVersionUID = 1L;

    private Map<Tecnologia, Experiencia> skill;

    public Skills() {
        super();
        skill = new HashMap<Tecnologia, Experiencia>();
    }

    /** Metodo para Agregar el conocimiento de una tecnologia nueva */
    public void addSkill(final String tecnologia, final String experiencia) {
        if (this.buscarTecnologia(tecnologia) == null) {
            this.setSkill(new Tecnologia(tecnologia), new Experiencia(experiencia));
        }
    }

    /**
     * Busco dentro de mis conocimientos una determinada tecnologia y si la
     * tengo la devuelvo
     */
    private Tecnologia buscarTecnologia(final Tecnologia tecnologiaBuscada) {
        return this.buscarTecnologia(tecnologiaBuscada.getTecnologiaActual());
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

    /** Bajo un Nivel de Experiencia en el dominio de una Tecnologia determinada */
    public void bajarExperiencia(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);

        if (tecnologiaBuscada != null) {
            this.getExperiencia(tecnologiaBuscada).bajarExperiencia();
        }
    }

    /** Subo un Nivel de Experiencia en el dominio de una Tecnologia determinada */
    public void subirExperiencia(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);

        if (tecnologiaBuscada != null) {
            this.getExperiencia(tecnologiaBuscada).subirExperiencia();
        }
    }

    /**
     * Devuelvo el Nivel de Experiencia en el dominio de una Tecnologia
     * determinada
     */
    public String getExperienciaNombre(final Tecnologia tecnologiaBuscada) {
        return this.getExperienciaNombre(tecnologiaBuscada.getTecnologiaActual());
    }

    public String getExperienciaNombre(final String nombreTecnologiaBuscada) {
        Tecnologia tecnologiaBuscada = this.buscarTecnologia(nombreTecnologiaBuscada);
        return tecnologiaBuscada == null ? null : this.getExperiencia(tecnologiaBuscada).getExperienciaActual();
    }

    /** Compruebo si todos mis conocimientos satisfacen las condiciones minimas */
    public boolean satisfaceRequisito(final Skills condiciones) {
        boolean sabe = true;
        Tecnologia tecnologiaParticular;

        Tecnologia tecnologiaIterador;
        Iterator<Tecnologia> iterador = condiciones.getSkill().keySet().iterator();
        while (iterador.hasNext()) {
            tecnologiaIterador = iterador.next();
            tecnologiaParticular = this.buscarTecnologia(tecnologiaIterador);
            if (!this.dominaTecnologia(tecnologiaParticular, condiciones.getExperienciaNombre(tecnologiaIterador))) {
                sabe = false;
                break;
            }
        }
        return sabe;
    }

    /** Verifico si mi conocimientos satisfacen una condicion minima */
    private boolean dominaTecnologia(final Tecnologia tecnologia, final String experienciaMinima) {
        return tecnologia != null && this.getExperiencia(tecnologia).cumbreNecesidades(experienciaMinima);
    }

    /**
     * Devuelvo un puntaje referido a los conocimientos. Mientras mas cercano a
     * los requisitos esta mas chico es el numero
     */
    public Integer diferenciaRequisitos(final Skills condiciones) {
        Integer puntaje = 0;
        Tecnologia tecnologiaParticular;

        Tecnologia tecnologiaIterador;
        Iterator<Tecnologia> iterador = condiciones.getSkill().keySet().iterator();
        while (iterador.hasNext()) {
            tecnologiaIterador = iterador.next();
            tecnologiaParticular = this.buscarTecnologia(tecnologiaIterador);
            puntaje += this.puntajeTecnologia(tecnologiaParticular,
                    condiciones.getExperienciaNombre(tecnologiaIterador));
        }
        return puntaje;
    }

    /**
     * Devuelvo un puntaje referido al dominio de una Tecnologia. Mientras mas
     * cercano a los requisitos esta mas chico es el numero
     */
    private Integer puntajeTecnologia(final Tecnologia tecnologia, final String experienciaMinima) {
        return this.getExperiencia(tecnologia).difenciaNecesidades(experienciaMinima);
    }

    private Experiencia getExperiencia(final Tecnologia tecnologia) {
        return skill.get(tecnologia);
    }

    public Map<Tecnologia, Experiencia> getSkill() {
        return skill;
    }

    public void setSkill(final Map<Tecnologia, Experiencia> skills) {
        skill = skills;
    }

    public void setSkill(final Tecnologia tecnologia, final Experiencia experiencia) {
        skill.put(tecnologia, experiencia);
    }

}
