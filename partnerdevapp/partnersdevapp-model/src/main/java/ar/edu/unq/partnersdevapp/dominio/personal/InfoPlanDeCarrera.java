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
    @SuppressWarnings("FindBugs")
    public int compareTo(final InfoPlanDeCarrera plan) {
        return getFechaInicio().compareTo(plan.getFechaInicio());
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
