package ar.edu.unq.partnersdevapp.dominio.personal;

import java.util.Date;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;

/**
 * Utilizada para modelar los históricos.
 * 
 */
public class InfoPlanDeCarrera implements Comparable<InfoPlanDeCarrera> {

    private Date fechaInicio;

    private PlanDeCarrera planDeCarrera;

    private Posicion NivelPlanDeCarrera;// reprecentando (nivel,subNivel)

    public InfoPlanDeCarrera() {

    }

    public InfoPlanDeCarrera(final Date date, final PlanDeCarrera planDeCarrera, final Posicion posicion) {
        this.setFechaInicio(date);
        this.setNivelPlanDeCarrera(posicion);
        this.setPlanDeCarrera(planDeCarrera);
    }

    @Override
    public int compareTo(final InfoPlanDeCarrera o) {
        return (int) (this.getFechaInicio().getTime() - o.getFechaInicio().getTime());
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
        return NivelPlanDeCarrera;
    }

    public void setNivelPlanDeCarrera(final Posicion nivelPlanDeCarrera) {
        NivelPlanDeCarrera = nivelPlanDeCarrera;
    }

}
