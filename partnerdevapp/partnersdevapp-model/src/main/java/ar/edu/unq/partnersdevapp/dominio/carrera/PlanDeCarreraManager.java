package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.personal.InfoPlanDeCarrera;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * Alivia de responsabilidades a Empleado. Todos los eventos relacionados con un
 * plan de carrera de un empleado estan aqui.
 * 
 * @author leo
 */
public class PlanDeCarreraManager {

    private List<InfoPlanDeCarrera> infoPlanDeCarrera = new ArrayList<InfoPlanDeCarrera>();

    /** Agrega un informacion nueva de su plan de carrera. */
    public void addPlanDeCarrera(final Date fechaInicio, final PlanDeCarrera planDeCarrera,
            final Posicion posicionInicial) {
        this.getInfoPlanDeCarrera().add(new InfoPlanDeCarrera(fechaInicio, planDeCarrera, posicionInicial));
    }

    /**
     * Sube solo una posicon en el plan de carrera.
     * 
     * @throws NoHayResultadoException
     */
    public void subirPosicion() throws NoHayResultadoException {
        this.subirPosicion(Calendar.getInstance().getTime());
    }

    public void subirPosicion(final Date date) throws NoHayResultadoException {
        Posicion posicionNueva = this.getPlanActual().getPosicionSuperior(this.getPosicionActual());
        this.addPlanDeCarrera(date, this.getPlanActual(), posicionNueva);
    }

    /** Devuelve la ultima posicion en el plan de carrera actual */
    public Posicion getPosicionActual() throws NoHayResultadoException {
        return this.getUltimaInfo().getNivelPlanDeCarrera();
    }

    /**
     * Devuelve el último plan de carrera
     * 
     * @throws NoHayResultadoException
     */
    public PlanDeCarrera getPlanActual() throws NoHayResultadoException {
        return this.getUltimaInfo().getPlanDeCarrera();
    }

    /** Devuelve la informacion correspondiente al ultimo plan de carrera */
    private InfoPlanDeCarrera getUltimaInfo() throws NoHayResultadoException {
        Collections.sort(this.getInfoPlanDeCarrera());
        int ultimoElemento = this.getInfoPlanDeCarrera().size() - 1;
        if (ultimoElemento < 0)
            throw new NoHayResultadoException();
        return this.getInfoPlanDeCarrera().get(ultimoElemento);
    }

    // ******************
    // ****** Gets & Sets
    public List<InfoPlanDeCarrera> getInfoPlanDeCarrera() {
        return infoPlanDeCarrera;
    }

    public void setInfoPlanDeCarrera(final List<InfoPlanDeCarrera> infoPlanDeCarrera) {
        this.infoPlanDeCarrera = infoPlanDeCarrera;
    }

}
