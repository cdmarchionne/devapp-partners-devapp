package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.Date;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Utilizada para modelar los históricos.
 * 
 * @author leo
 */
public class InfoPlanDeCarrera extends Entidad implements Comparable<InfoPlanDeCarrera> {

    private static final long serialVersionUID = 1L;

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
        return this.getFechaInicio().compareTo(plan.getFechaInicio());
    }

    @Override
    public boolean equals(final Object obj) {
        // return obj == null ? false : compareTo((InfoPlanDeCarrera) obj) == 0;
        boolean rta = false;

        if (!(obj == null || this.getClass() != obj.getClass())) {
            if (this == obj) {
                rta = true;
            } else {
                rta = this.isSame((InfoPlanDeCarrera) obj);
            }
        }
        return rta;
    }

    private boolean isSame(final InfoPlanDeCarrera infoPlanDeCarrera) {
        boolean rta;

        if (this.equalsFechaInicio(infoPlanDeCarrera) && this.equalsPlanDeCarrera(infoPlanDeCarrera)
                && this.equalsNivelPlanDeCarrera(infoPlanDeCarrera)) {
            rta = true;
        } else {
            rta = false;
        }

        return rta;
    }

    private boolean equalsFechaInicio(final InfoPlanDeCarrera infoPlanDeCarrera) {
        return this.getFechaInicio() == null ? infoPlanDeCarrera.getFechaInicio() == null : this.getFechaInicio()
                .equals(infoPlanDeCarrera.getFechaInicio());
    }

    private boolean equalsPlanDeCarrera(final InfoPlanDeCarrera infoPlanDeCarrera) {
        return this.getPlanDeCarrera() == null ? infoPlanDeCarrera.getPlanDeCarrera() == null : this.getPlanDeCarrera()
                .equals(infoPlanDeCarrera.getPlanDeCarrera());
    }

    private boolean equalsNivelPlanDeCarrera(final InfoPlanDeCarrera infoPlanDeCarrera) {
        return this.getNivelPlanDeCarrera() == null ? infoPlanDeCarrera.getNivelPlanDeCarrera() == null : this
                .getNivelPlanDeCarrera().equals(infoPlanDeCarrera.getNivelPlanDeCarrera());
    }

    @Override
    public int hashCode() {
        int result = 10;
        result += this.getFechaInicio() == null ? 0 : this.getFechaInicio().hashCode();
        result += this.getPlanDeCarrera() == null ? 0 : this.getPlanDeCarrera().hashCode();
        result += this.getNivelPlanDeCarrera() == null ? 0 : this.getNivelPlanDeCarrera().hashCode();
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
