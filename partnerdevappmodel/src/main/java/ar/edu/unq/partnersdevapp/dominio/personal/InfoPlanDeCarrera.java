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
        this.setFechaInicio(date);
        this.setNivelPlanDeCarrera(posicion);
        this.setPlanDeCarrera(planDeCarrera);
    }

    @Override
    public int compareTo(final InfoPlanDeCarrera plan) {
        return (int) (this.getFechaInicio().getTime() - plan.getFechaInicio().getTime());
    }

    // **************************
    // ******* Gets & Sets
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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
