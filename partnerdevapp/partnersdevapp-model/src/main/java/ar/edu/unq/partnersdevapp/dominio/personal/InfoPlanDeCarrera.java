package ar.edu.unq.partnersdevapp.dominio.personal;

import java.util.Date;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;

/**
 * Utilizada para modelar los históricos.
 * 
 * @author leo
 */
public class InfoPlanDeCarrera implements Comparable<InfoPlanDeCarrera> {

    private Date fechaInicio;

    private PlanDeCarrera planDeCarrera;

    private Posicion nivelPlanDeCarrera;// reprecentando (nivel,subNivel)

    public InfoPlanDeCarrera() {
        super();
    }

    public InfoPlanDeCarrera(final Date date, final PlanDeCarrera planDeCarrera, final Posicion posicion) {
        setFechaInicio(date);
        setNivelPlanDeCarrera(posicion);
        setPlanDeCarrera(planDeCarrera);
    }

    @Override
    public int compareTo(final InfoPlanDeCarrera plan) {
        return getFechaInicio().compareTo(plan.getFechaInicio());
    }

    @Override
    public boolean equals(final Object obj) {
        // return obj == null ? false : compareTo((InfoPlanDeCarrera) obj) == 0;
        boolean rta = false;

        if (!(obj == null || getClass() != obj.getClass())) {
            if (this == obj) {
                rta = true;
            } else {
                rta = isSame((InfoPlanDeCarrera) obj);
            }
        }
        return rta;
    }

    private boolean isSame(final InfoPlanDeCarrera infoPlanDeCarrera) {
        boolean rta;

        if (equalsFechaInicio(infoPlanDeCarrera) && equalsPlanDeCarrera(infoPlanDeCarrera)
                && equalsNivelPlanDeCarrera(infoPlanDeCarrera)) {
            rta = true;
        } else {
            rta = false;
        }

        return rta;
    }

    private boolean equalsFechaInicio(final InfoPlanDeCarrera infoPlanDeCarrera) {
        return getFechaInicio() == null ? infoPlanDeCarrera.getFechaInicio() == null : getFechaInicio().equals(
                infoPlanDeCarrera.getFechaInicio());
    }

    private boolean equalsPlanDeCarrera(final InfoPlanDeCarrera infoPlanDeCarrera) {
        return getPlanDeCarrera() == null ? infoPlanDeCarrera.getPlanDeCarrera() == null : getPlanDeCarrera().equals(
                infoPlanDeCarrera.getPlanDeCarrera());
    }

    private boolean equalsNivelPlanDeCarrera(final InfoPlanDeCarrera infoPlanDeCarrera) {
        return getNivelPlanDeCarrera() == null ? infoPlanDeCarrera.getNivelPlanDeCarrera() == null
                : getNivelPlanDeCarrera().equals(infoPlanDeCarrera.getNivelPlanDeCarrera());
    }

    @Override
    public int hashCode() {
        int result = 10;
        result += getFechaInicio() == null ? 0 : getFechaInicio().hashCode();
        result += getPlanDeCarrera() == null ? 0 : getPlanDeCarrera().hashCode();
        result += getNivelPlanDeCarrera() == null ? 0 : getNivelPlanDeCarrera().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" + fechaInicio + "," + planDeCarrera.getEspecialidad() + "," + nivelPlanDeCarrera + "} \n";
    }

    // **************************
    // ******* Gets & Sets
    public Date getFechaInicio() {
        return (Date) fechaInicio.clone();
    }

    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = (Date) fechaInicio.clone();
    }

    public PlanDeCarrera getPlanDeCarrera() {
        return planDeCarrera;
    }

    public void setPlanDeCarrera(final PlanDeCarrera planDeCarrera) {
        this.planDeCarrera = planDeCarrera;
    }

    public Posicion getNivelPlanDeCarrera() {
        return nivelPlanDeCarrera;
    }

    public void setNivelPlanDeCarrera(final Posicion nivelPlanDeCarrera) {
        this.nivelPlanDeCarrera = nivelPlanDeCarrera;
    }

}
