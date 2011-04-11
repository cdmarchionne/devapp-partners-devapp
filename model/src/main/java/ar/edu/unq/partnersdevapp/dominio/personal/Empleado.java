package ar.edu.unq.partnersdevapp.dominio.personal;

import java.util.Date;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;

/**
 * TODO: description
 */
public class Empleado extends Persona {

    private String obraSocial;

    private String planPrapaga;

    private String nombreArt;

    private Integer telArt;

    private String dirArt;

    private Date fechaIngreso;

    private PlanDeCarrera planDeCarrera;

    private Posicion NivelPlanDeCarrera;// reprecentando (nivel,subNivel)

    private Skills conocimiento;

    // ******************
    // ****** Gets & Sets

    public String getObraSocial() {
        return obraSocial;
    }

    public Posicion getNivelPlanDeCarrera() {
        return NivelPlanDeCarrera;
    }

    public void setNivelPlanDeCarrera(final Posicion nivelPlanDeCarrera) {
        NivelPlanDeCarrera = nivelPlanDeCarrera;
    }

    public void setObraSocial(final String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getPlanPrapaga() {
        return planPrapaga;
    }

    public void setPlanPrapaga(final String planPrapaga) {
        this.planPrapaga = planPrapaga;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(final String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public Integer getTelArt() {
        return telArt;
    }

    public void setTelArt(final Integer telArt) {
        this.telArt = telArt;
    }

    public String getDirArt() {
        return dirArt;
    }

    public void setDirArt(final String dirArt) {
        this.dirArt = dirArt;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(final Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Skills getConocimiento() {
        return conocimiento;
    }

    public void setConocimiento(final Skills conocimiento) {
        this.conocimiento = conocimiento;
    }

    public PlanDeCarrera getPlanDeCarrera() {
        return planDeCarrera;
    }

    public void setPlanDeCarrera(final PlanDeCarrera planDeCarrera) {
        this.planDeCarrera = planDeCarrera;
    }

}
